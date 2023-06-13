package Bronze1;

import java.util.Scanner;
public class BJ11050_이항계수1 {	//6min.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		
		int result=1;
		for(int i=N;i>K;i--)//N부터 K+1까지 곱함. = (N! / K!)
			result *= i;

		for(int i=N-K;i>1;i--)// 	result / (N-K)!
			result /= i;
		System.out.println(result);
	}
}