import java.util.Scanner;

public class Main {
	static int mod = 10007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		int[][] dp = new int[N][10]; // index+1번째 자릿수가 0~9일때까지의 경우의 수
		
		for(int i=0;i<10;i++) dp[0][i]=1; //첫번째 자리에 i가 오는 경우의 수는 1가지.
										  // 0~, 1~, 2~, ...9~
		
		for(int i=1;i<N;i++) {
			int sum=0;
			for(int j=0;j<10;j++) {
				sum+=dp[i-1][j];
				sum%=mod;
				
				dp[i][j] = sum;
			}
		}
		
		int cnt=0;
		for(int i=0;i<10;i++) {
			cnt = (cnt+dp[N-1][i])%mod;
		}
		
		System.out.println(cnt);
	}
}