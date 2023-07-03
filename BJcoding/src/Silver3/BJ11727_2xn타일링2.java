package Silver3;

import java.util.Scanner;
public class BJ11727_2xn타일링2 {
	static int[] cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		cnt = new int[n+1];
		
		System.out.println(dp(n));
		
	}
	static int dp(int n) {
		
		cnt[1]=1;
		if(n>=2) cnt[2]=3;
		
		for(int i=3;i<=n;i++)
			cnt[i]=(cnt[i-1]+2*cnt[i-2])%10007;
		
		return cnt[n];
	}
}
