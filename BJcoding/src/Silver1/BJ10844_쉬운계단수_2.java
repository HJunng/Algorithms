package Silver1;

import java.util.*;
public class BJ10844_쉬운계단수_2 {	//40m.

	public static long[][] dp;
	public static int n;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		dp = new long[n+1][10];	//dp[길이][끝자리 수]=누적 개수
		long mod = 1000000000;
		
		for(int i=1;i<=9;i++) {
			dp[1][i] =1;
			//1자리수의 i번째 자리는 1~9까지 한개씩 밖에
		}
		for(int i=2;i<=n;i++) {	//두번째 자리수 부터 계산.
			for(int j=0;j<10;j++) {
				if(j==0) dp[i][j] = dp[i-1][j+1] %mod;	//끝자리 0이면 다음 자리는 1밖에 안됨.
				else if(j==9) dp[i][j] = dp[i-1][j-1]%mod; 	//끝자리가 9이면 다음 자리는 8만 가능.
				else dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
			}
		}
		
		long result =0;
		for(int i=0;i<10;i++)
			result+= dp[n][i];
		System.out.println(result%mod);
	}
}