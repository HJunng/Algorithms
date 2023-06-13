package Silver2;

import java.util.Scanner;
public class BJ2004_조합0의개수 {	//42min. 답.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		long cnt2 = count2(n) - count2(m) - count2(n-m);// n!/(m! * (n-m)!)
		long cnt5 = count5(n) - count5(m) - count5(n-m);
		
		if(cnt2<=0 && cnt5<=0) System.out.println(0);// 둘 중 하나라도 0개 이하이면 뒤에 0없음.
		else if(cnt2<cnt5) System.out.println(cnt2);
		else System.out.println(cnt5);
	}
	private static int count5(int num) {//num!에서 5의 개수 세는 함수.
		int result=0;
		while(num/5>0) {
			result += num/5;
			num/=5;
		}
		return result;
	}
	private static int count2(int num) {
		int result=0;
		while(num/2>0) {
			result += num/2;
			num/=2;
		}
		return result;
	}
}