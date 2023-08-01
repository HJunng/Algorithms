package Silver1;

import java.io.*;
import java.util.*;

public class BJ1931_회의실배정_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int[][] time = new int[n][2];
		
		String[] s;
		for(int i=0;i<n;i++) {
			s=br.readLine().split(" ");
			
			time[i][0]=Integer.parseInt(s[0]);
			time[i][1]=Integer.parseInt(s[1]);
		}
		//회의가 빨리 끝나는 순으로 정렬
		//Arrays.sort(time, (a,b)-> a[1]-b[1]);
		Arrays.sort(time,new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[1]==b[1]) return a[0]-b[0];
				else return a[1]-b[1];
			}
		});
		
		int now=0;//현재시각
		int cnt=0;//회의 배정
		for(int i=0;i<time.length;i++) {
			if(time[i][0]>=now) {
				now=time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
