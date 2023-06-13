package Silver3;

import java.util.Scanner;

public class BJ1463_2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		
		System.out.println(dp(x,0));
	}

	private static int dp(int x, int count) {

		if(x==1) return count;
		
		int temp = dp(x-1,count+1); //왜 인지 모르겠지만 1빼는 연산을 먼저 넣지 않으면 오류남.
		
		if(x%3==0)
			temp = Math.min(temp, dp(x/3,count+1));
		
		if(x%2==0)
			temp = Math.min(temp, dp(x/2,count+1));

		return temp;
	}
}