package Silver4;

import java.util.Scanner;

public class BJ1065 {	//36min

	public static boolean Han(int n) {
		if(n<100)return true;
		else {
			int num = n;
			int sub = (num/10)%10 - num%10;
			int sub2 = sub;
			while((num/=10)>=10) {
				sub2 = (num/10)%10 - num%10;
				if(sub!=sub2)break;
			}
			if(sub!=sub2)return false;
			else return true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		int result=0;
		for(int i=1;i<=N;i++) {
			if(Han(i)==true)result++;
		}
		System.out.println(result);
	}
}
