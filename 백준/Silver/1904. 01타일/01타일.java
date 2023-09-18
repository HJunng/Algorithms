import java.util.*;

public class Main {
	static int[] dp;
	static int MOD=15746;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		dp = new int[n+1];
		dp[1]=1;
		if(n>=2) dp[2]=2;
		
		System.out.println(find(n));
		
	}
	static int find(int n) {
		if(dp[n]>0) return dp[n];
		
		dp[n]=(find(n-1)%MOD+find(n-2)%MOD)%MOD;
		return dp[n];
	}
}