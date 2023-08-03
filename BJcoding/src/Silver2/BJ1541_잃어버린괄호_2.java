package Silver2;

import java.util.*;

public class BJ1541_잃어버린괄호_2 {
	static ArrayList<Integer> num;
	static ArrayList<Character> sign;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		num = new ArrayList<>();//숫자 순서대로 저장
		sign = new ArrayList<>();//부호 저장.
		
		int idx=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)<'0' || str.charAt(i)>'9') {//기호를 만났을 때
				//idx~기호 이전까지 숫자를 저장
				num.add(Integer.parseInt(str.substring(idx,i)));
				idx=i+1;
				
				//기호 저장
				sign.add(str.charAt(i));
			}
		}
		//마지막 숫자 저장.
		num.add(Integer.parseInt(str.substring(idx)));
		
		
		calculate('+');
		calculate('-');
		
		System.out.println(num.get(0));
	}
	// ss기호를 계산한다.
	static void calculate(char ss) {
		int idx=0;
		while(idx<sign.size()) {
			if(sign.get(idx)==ss) {
				//더하기
				if(ss=='+') num.add(idx,num.remove(idx)+num.remove(idx));
				//빼기
				else num.add(idx, num.remove(idx)-num.remove(idx));
				
				sign.remove(idx);
			}
			else idx++;//계산해야 하는 기호가 아니라면 다음 기호 가져오기.
		}
	}
}
