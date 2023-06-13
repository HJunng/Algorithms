package Bronze1;

import java.util.*;
public class BJ1193 {	//22min
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int X = s.nextInt();	//X번째 분수 구할 때 쓰는 X

		int n = 2;				//분모, 분자의 합이 n인 수들끼리 묶어서 개수를 제할 것임.
		while(X>=n) {
			X -= n-1;
			n++;
		}
		
		//반복문을 끝내고 나오면 합이 n인 분수의 X번째 값을 구하면 된다.
		if(n%2==1) {//분모, 분자의 합이 홀수이면
			System.out.println(X+"/"+(n-X));
		}else {
			System.out.println((n-X)+"/"+X);
		}
	}
}
