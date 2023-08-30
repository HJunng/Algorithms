package GoormthonChallenge;

import java.util.*;
import java.io.*;
public class Day05_이진수정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		int[][] num = new int[n][2];
		s = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			num[i][0]=Integer.parseInt(s[i]);
			
			int number = num[i][0];
			while(number>1){
				num[i][1]+=number%2;
				number/=2;
			}
			num[i][1]+=1;
		}
		
		Arrays.sort(num, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				if(a[1]!=b[1]) return b[1]-a[1];
				else return b[0]-a[0];
			} 
		});
		
		System.out.println(num[k-1][0]);
	}
}
