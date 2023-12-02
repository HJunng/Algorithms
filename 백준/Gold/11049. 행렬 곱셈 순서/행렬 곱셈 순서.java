import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n][n]; // dp[i][j] : i부터 j까지 행렬 곱 연산의 최솟값.
		int[][] num = new int[n][2];
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			num[i][0]=Integer.parseInt(s[0]);
			num[i][1] = Integer.parseInt(s[1]);
		}
		
		for(int k=1;k<n;k++) {
			for(int i=0;i+k<n;i++) {
				dp[i][i+k] = Integer.MAX_VALUE;
				for(int j=i;j<i+k;j++) {
					dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k]+num[i][0]*num[j][1]*num[i+k][1]);
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
	}
}