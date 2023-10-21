import java.util.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		int[] worth = new int[n];
		for(int i=0;i<n;i++) worth[i] = s.nextInt();
		
		dp = new int[k+1];
		dp[0]=1;
		
		for(int i=0;i<worth.length;i++) {
			for(int j=worth[i];j<=k;j++) {
				dp[j]+=dp[j-worth[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}