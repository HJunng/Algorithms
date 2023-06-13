package Silver5;

import java.util.Scanner;
public class BJ1676_팩토리얼0의개수 {	//18min.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		int result=0;
		for(int i=5;i<=N;i+=5) {
			int temp=i;
			while(temp%5 == 0) {//25, 50 이런건 5가 두개씩 있음.
				result++;
				temp/=5;
			}
		}
		System.out.println(result);
	}
}