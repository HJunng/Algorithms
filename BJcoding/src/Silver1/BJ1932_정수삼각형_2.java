package Silver1;

import java.io.*;
public class BJ1932_정수삼각형_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[n][n];
		
		String[] s;
		int max=0;
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<=i;j++) {
				dp[i][j]=Integer.parseInt(s[j]);
				
				if(i==0) {
					max=dp[i][j];continue;//n=1일 때에도 max값을 출력해야한다.
				}
				if(j==0) dp[i][j]+=dp[i-1][j];
				else dp[i][j]+=Math.max(dp[i-1][j-1], dp[i-1][j]);
				
				if(i==n-1 && dp[i][j]>max) max=dp[i][j]; 
			}
		}
		System.out.println(max);
	}
}
