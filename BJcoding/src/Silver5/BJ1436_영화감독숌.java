package Silver5;

import java.util.Scanner;

public class BJ1436_영화감독숌 {	//30min.

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int count=1;
		int num=666;
		
		while(count != N) {	//N=1이면 바로 출력으로 넘어감.
			num++;
			if(String.valueOf(num).contains("666")) {//contains 사용해서 쉽게 풀 수 있음.
				count++;
			}
		}
		System.out.println(num);
	}
}