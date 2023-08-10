package Hash;

import java.util.*;

public class Lv0_팰린드롬길이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("abcbbbccaaeee"));
		System.out.println(solution("aabbccddee"));
		System.out.println(solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg"));
		System.out.println(solution("aabcefagcefbcabbcc"));
		System.out.println(solution("abcbbbccaa"));
		
	}
	public static int solution(String s) {
		int answer=0;
		
		Map<Character, Integer> cnt = new HashMap<>();
		for(int i=0;i<s.length();i++) cnt.put(s.charAt(i),cnt.getOrDefault(s.charAt(i), 0)+1);
		
		boolean odd=false;
		for(char c : cnt.keySet()) {
			
			if(cnt.get(c)%2==1 && !odd) {
				answer+=cnt.get(c)/2*2+1;
				odd=true;
			}else
				answer+=cnt.get(c)/2*2;
			
		}
		
		return answer;
	}
}
