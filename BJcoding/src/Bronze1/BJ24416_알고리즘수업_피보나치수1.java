package Bronze1;

import java.util.Scanner;
public class BJ24416_알고리즘수업_피보나치수1 {		//10min.
	public static int A = 0;//코드1 실행 횟수.
	public static int B = 0;//코드2 실행 횟수.

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int resultA = fib(n);
		int resultB = fibonacci(n);
		
		System.out.println(A+" "+B);
	}
	private static int fib(int n) {//재귀호출 의사 코드
		
		if(n==1 || n==2) {
			A++;
			return 1;	//# 코드1
		}
		else
			return (fib(n-1) + fib(n-2));
	}
	private static int fibonacci(int n) {//동적 프로그래밍 의사 코드
		int f[] = new int[n+1];
		f[1] = f[2] = 1;
		for(int i=3;i<=n;i++) {
			B++;
			f[i] = f[i-1] + f[i-2];	// # 코드2
		}
		return f[n];
	}
}