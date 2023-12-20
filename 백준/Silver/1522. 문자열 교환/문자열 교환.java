import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		int aCnt=0; // 주어진 문자열의 총 a의 개수 
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a') aCnt++;
		}
		
		int left=0;
		int right=aCnt-1;
		
		int minSwitch=0;
		
		// 처음 (0 ~ aCnt-1)까지의 윈도우를 보면서 바꿔야할 문자 개수를 세어준다.
		for(int i=0;i<aCnt;i++) {
			if(str.charAt(i)=='b') minSwitch++;
		}
		
		int switchCnt=minSwitch; // 윈도우 당 스위치해야하는 개수.
		
		// 슬라이딩 윈도우
		// 윈도우 자체를 오른쪽으로 한칸씩 이동하면서 바꿔야 할 문자 개수 +-1 해준다.
		for(int i=0;i<str.length();i++) {
			
			right++; // 윈도우를 오른쪽으로 한칸 이동 
			right%=str.length(); // 범위를 벗어나면 맨 앞으로 이동.
			
			if(str.charAt(right)=='b') switchCnt++;
			if(str.charAt(left)=='b') switchCnt--;
			
			left++; left%=str.length();
			
			minSwitch = Math.min(minSwitch, switchCnt);
		}
		
		System.out.println(minSwitch);
	}
}