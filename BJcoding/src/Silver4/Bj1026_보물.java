package Silver4;

import java.io.*;
import java.util.*;

public class Bj1026_보물 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[][] b = new int[n][2];
		
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++) a[i]=Integer.parseInt(s[i]);
		
		s=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			b[i][0]=Integer.parseInt(s[i]);
			b[i][1]=i;//index 넣기
		}
		
		Arrays.sort(a);
		Arrays.sort(b,(o1,o2)->o2[0]-o1[0]);
		
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=a[i]*b[i][0];
		}
		System.out.println(sum);
	}

}
