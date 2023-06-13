package Gold1;

import java.util.Scanner;
public class BJ11401_이항계수3 { // 메모리 초과.
	
	static long arr[][];
	static long mod = 1000000007;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		
		if(N-K < K) // nCr = nCn-r
			K = N-K;
		
		arr = new long[N][K];
		
		
	}
	private static void BC(int n, int k) {
		
		if(k==1)
			arr[n][1]=n;
		if(n==k)
			arr[n][k]=1;
		
	}
}