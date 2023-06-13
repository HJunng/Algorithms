package Silver4;

import java.util.Scanner;

public class BJ2839 {	//14min

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int a = N/5;	//a는 5로 나눈 몫
		int b=0;
		
		int result=0;
		while(a>=0) {
			int n = N - (a*5);
			if(n%3==0) {
				b = n/3;
				result = a+b;
				break;
			}else if(a==0) {
				result=-1;break;
			}else {
				a--;
			}
		}
		System.out.println(result);		
	}

}
