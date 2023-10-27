import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		int[] ns = new int[T];
		int max=0;
		for(int i=0;i<T;i++) {
			ns[i] = s.nextInt();
			max = Math.max(ns[i], max);
		}
		
		int[] dp = new int[max+1];
		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 4; // 1+1, 1+2, 2+1, 3
		dp[4] = 7; // 1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 2+2, 3+1, 1+3
		
		for(int i=5;i<=max;i++) {
			dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
		}
		
		for(int i=0;i<T;i++) System.out.println(dp[ns[i]]);
	}
}