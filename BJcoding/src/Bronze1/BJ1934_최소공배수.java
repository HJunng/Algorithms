package Bronze1;

import java.io.*;
public class BJ1934_최소공배수 {	//4min.
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str[];
		int a,b,result_gcd;
		for(int i=0;i<T;i++) {
			str=br.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			if(a>b)	//최대공약수 구하기
				result_gcd=gcd(a,b);
			else
				result_gcd=gcd(b,a);
			System.out.println(a/result_gcd*b);	//a와 b를 최대공약수로 나누고 (최소공배수 = 최대공약수 * a * b)
		}
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