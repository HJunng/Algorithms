package Hash;

import java.util.*;

public class Lv0_같은빈도수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution("aaabc");
		solution("aabb");
		solution("abcde");
		solution("abcdeabc");
		solution("abbccddee");
		
	}
	public static int[] solution(String s) {
		int[]  answer = {};
		
		
		Map<Character, Integer> cnt = new HashMap<>();
		
		//a, b, c, d, e 빈도수 0으로 초기화
		for(char c='a';c<='e';c++) cnt.put(c, 0);
		
		for(int i=0;i<s.length();i++) {
			cnt.put(s.charAt(i), cnt.get(s.charAt(i))+1);
			
//			if(cnt.get(s.charAt(i))>max) {//최대 빈도수 구하기
//				max=cnt.get(s.charAt(i));
//			}
		}
		int max = Collections.max(cnt.values());//Collections는 max 구하기 쉬움.
		
		answer = new int[cnt.size()];
		
		for(char c='a';c<='e';c++) {
			answer[c-'a']=max-cnt.get(c);
		}
		
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}
