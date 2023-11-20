import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			// i가 제곱수이면, 항 1개가 가장 적은 것.
			if(Math.sqrt(i)%1==0) {
				dp[i]=1; continue;
			}
			
			dp[i]=i; // 1+... 의 개수로 초기화.
			for(int j=1;j<i;j++) {
				dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}