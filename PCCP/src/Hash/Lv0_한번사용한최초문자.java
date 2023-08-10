package Hash;

import java.util.*;

public class Lv0_한번사용한최초문자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("statitsics"));
		System.out.println(solution("aabb"));
		System.out.println(solution("stringshowtime"));
		System.out.println(solution("abcdeabcdfg"));
	}
	public static int solution(String s) {
		int answer=0;
		
		Map<Character, Integer> cnt = new HashMap<>();
		for(int i=0;i<s.length();i++) cnt.put(s.charAt(i),cnt.getOrDefault(s.charAt(i),0)+1);
		
		
		answer=-1;
		for(int i=0;i<s.length();i++) {
			if(cnt.get(s.charAt(i))==1) {
				answer=i+1;break;
			}
		}
		return answer;
	}
}
