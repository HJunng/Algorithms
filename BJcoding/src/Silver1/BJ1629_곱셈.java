package Silver1;

import java.io.*;
public class BJ1629_곱셈 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		long A = Long.parseLong(str[0]);
		long B = Long.parseLong(str[1]);
		long C = Long.parseLong(str[2]);
		
		System.out.println(Multiply(A,B,C));
	}
	private static long Multiply(long a, long b, long c) {
		
		if(a==1) return 1;
		if(b==1) {
			return a%c;
		}
		long temp = Multiply(a,b/2,c);
		if(b%2==1) {
			return temp*temp%c*a%c;
		}
		return temp*temp%c;
	}
}