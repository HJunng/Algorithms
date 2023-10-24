import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[] ns = new int[T];
		
		int maxN=0;
		for(int i=0;i<T;i++) {
			ns[i] = s.nextInt();
			if(ns[i]>maxN) maxN = ns[i];
		}
		
		// 1: 1만 사용, 2: 2~1 사용, 3:3~1 사용 
		int[][] dp = new int[maxN+1][4];
		
		dp[1][1]=1; // 1
		dp[1][2]=0;
		dp[1][3]=0;
		
		if(maxN>=2) {
			dp[2][1]=1; // 11
			dp[2][2]=1; //2
			dp[2][3]=0;
		}
		if(maxN>=3) {
			dp[3][1]=1; // 111
			dp[3][2]=1; // 21
			dp[3][3]=1; // 3
		}
		
		//dp[4][1] = 1111
		//dp[4][2] = 112 22
		//dp[4][3] = 13
		
		for(int i=4;i<=maxN;i++) fillDP(i,dp);
		
		for(int i=0;i<T;i++) System.out.println(dp[ns[i]][1]+dp[ns[i]][2]+dp[ns[i]][3]);
		
	}
	static void fillDP(int now, int[][] dp) {
		dp[now][1] = dp[now-1][1];
		dp[now][2] = dp[now-2][1]+dp[now-2][2];
		dp[now][3] = dp[now-3][1]+dp[now-3][2]+dp[now-3][3];
	}
}
