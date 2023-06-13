package Silver4;

import java.io.*;
public class BJ3036_링 {		//10min.
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int A[] = new int [N];
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		int denom;//분모=최대공약수
		for(int i=1;i<N;i++) {
			denom = gcd(A[0],A[i]);
			sb.append(A[0]/denom).append("/").append(A[i]/denom).append("\n");
			//8이랑 4면 최대공약수인 4로 나눈값을 /붙여서 출력하면 됨.
		}
		System.out.println(sb);
	}
	private static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;
	}
}