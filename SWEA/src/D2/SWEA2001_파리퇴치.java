package D2;

import java.io.*;

public class SWEA2001_파리퇴치 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;
		for(int t=1;t<=tc;t++) {
			s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int[][] flies = new int[N+1][N+1]; //[1][1]부터 전체합.
			for(int i=1;i<=N;i++) {
				s = br.readLine().split(" ");
				int sum=0; //가로 합.
				for(int j=1;j<=N;j++) {
					sum+=Integer.parseInt(s[j-1]);
					flies[i][j]=flies[i-1][j]+sum;
				}
			}
			
			int max=0;
			for(int i=M;i<=N;i++) {
				for(int j=M;j<=N;j++) {
					int temp = flies[i][j]-flies[i-M][j]-flies[i][j-M]+flies[i-M][j-M];
					
					if(temp>max) max=temp;
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
	}
}