package Silver3;

import java.util.*;
public class BJ11726_2xn타일링 {
	static int mod=10007;
	static int[] sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		sum = new int[n+1];
		
		dp(n);
		
		System.out.println(sum[n]%mod);
		
	}
	static private void dp(int n) {
		
		if(n>=1) sum[1]=1;
		if(n>=2) sum[2]=2;
		
		for(int i=3;i<=n;i++)
			sum[i]=(sum[i-1]%mod+sum[i-2]%mod)%mod;
	}
}
