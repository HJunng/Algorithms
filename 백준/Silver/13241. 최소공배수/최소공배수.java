import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		
		int gcdNum = num1>num2? gcd(num1,num2):gcd(num2,num1);
		
		System.out.println((long)gcdNum*(num1/gcdNum)*(num2/gcdNum));
		
	}
	static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b,a%b);
	}
}