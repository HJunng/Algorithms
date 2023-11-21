import java.util.Scanner;

public class Main {
	static int mod = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		int[] Lens = new int[T];
		int maxLen=0; // 주어진 tc의 길이 중 가장 긴 길이.
		for(int i=0;i<T;i++) {
			Lens[i] = s.nextInt();
			maxLen = Math.max(maxLen, Lens[i]);
		}
		maxLen = Math.max(4, maxLen);
		
		long[] dp = new long[maxLen+1];
		dp[0]=1; dp[2]=1;
		
		for(int i=2;i<=maxLen/2;i++) {
			for(int j=0;j<i;j++) {
				dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
				dp[i*2]%=mod;
			}
		}
		
		for(int i=0;i<T;i++)
			System.out.println(dp[Lens[i]]);
	}
}