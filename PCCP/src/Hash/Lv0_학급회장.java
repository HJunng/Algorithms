package Hash;

import java.util.*;

public class Lv0_학급회장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(solution("BACBACCACCBDEDE"));
		System.out.println(solution("AAAAABBCCDDDD"));
		System.out.println(solution("AABBCCDDEEABCB"));
		
	}
	public static char solution(String s) {
		
		Map<Character, Integer> cnt = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0)+1);
		}
		
		char answer='1';
		int max=0;
		for(char c : cnt.keySet()) {
			if(cnt.get(c)>max) {
				max=cnt.get(c);
				answer=c;
			}
		}
		
		return answer;
	}
}
