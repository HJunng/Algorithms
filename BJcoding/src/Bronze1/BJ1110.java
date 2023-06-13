package Bronze1;

import java.util.Scanner;

public class BJ1110 {	//16min

	public static int cycle(int n) {
		int result = n%10;
		result*=10;
		if(n/10==0) result+=n;
		else {
			int temp = n/10 + n%10;
			result+=temp%10;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int r=0;
		
		if(n==0) {
			System.out.println(1);return;
		}
		int temp = cycle(n);
		r++;
		while(temp!=n) {
			temp = cycle(temp);
			r++;
		}
		System.out.println(r);
	}

}
