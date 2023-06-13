package Bronze1;

import java.io.*;
public class BJ2609_최대공약수와최소공배수 {	//8min.
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int gcd_result;
		if(A>B)
			gcd_result = gcd(A, B);
		else
			gcd_result = gcd(B,A);
		System.out.println(gcd_result);//최대공약수.
		System.out.println((A/gcd_result)*B);//최소공배수
	}

	private static int gcd(int a, int b) {	//유클리드 호제법.
		while(b!=0) {
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
}
