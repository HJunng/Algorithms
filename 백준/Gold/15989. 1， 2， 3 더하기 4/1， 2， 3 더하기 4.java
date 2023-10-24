import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		int[] ns = new int[T];
		int maxN=3;
		for(int i=0;i<T;i++) {
			ns[i]=s.nextInt();
			maxN = Math.max(maxN, ns[i]);
		}
		
		int[] dp = new int[maxN+1];
//		dp[1]=1; // 1
//		dp[2]=2; // 11 2
//		dp[3]=3; // 111 21 3
		
		for(int i=1;i<=3;i++) {
			dp[i]+=1; // 자기자신으로 만들 수 있는 수 : 1, 2, 3 
			
			for(int j=i;j<=maxN;j++) {
				dp[j] += dp[j-i]; // i를 사용하기 전의 경우의수 + i 사용!
			}
		}
		
		for(int i=0;i<T;i++) System.out.println(dp[ns[i]]);
		
	}
}