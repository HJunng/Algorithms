package Hash;

import java.util.*;
public class Lv2_뉴스클러스터링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String str1, String str2) {
        int answer = 0;
        
        //다 소문자로 바꿔주기
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        
        //map에 알파벳 2글자씩 끊어서 저장.
        Map<String,Integer> s1 = new HashMap<>();
        Map<String,Integer> s2 = new HashMap<>();
        
        for(int i=0;i+1<str1.length();i++){
            if(str1.charAt(i)<'a' || str1.charAt(i)>'z') continue; // 알파벳이 아니면 넘김.
            if(str1.charAt(i+1)<'a' || str1.charAt(i+1)>'z') continue;
            
            //글자 당 개수 저장.
            s1.put(str1.substring(i,i+2),s1.getOrDefault(str1.substring(i,i+2),0)+1);
        }
        for(int i=0;i+1<str2.length();i++){
            if(str2.charAt(i)<'a' || str2.charAt(i)>'z') continue;
            if(str2.charAt(i+1)<'a' || str2.charAt(i+1)>'z') continue;
            
            s2.put(str2.substring(i,i+2),s2.getOrDefault(str2.substring(i,i+2),0)+1);
        }
        
        //System.out.println(s1 +" "+s2);
        if(s1.isEmpty() && s2.isEmpty()) return 1*65536; //두 집합 모두 공집합이면 -> 1
        if(s1.isEmpty() || s2.isEmpty()) return 0;       // 둘 중 하나만 비어있으면 교집합x ->0
        
        
        Map<String,Integer> intersect = new HashMap<>(); //교집합
        Map<String,Integer> union = new HashMap<>(s1); //합집합 -> s1 단어들 다 넣기.
        
        
        for(String ss:s2.keySet()){
            
            if(s1.containsKey(ss)){//같은 단어가 있으면
                union.put(ss, Math.max(s1.get(ss),s2.get(ss))); // 합집합은 ss개수 max값만큼
                intersect.put(ss, Math.min(s1.get(ss),s2.get(ss))); //교집합은 ss개수 min값
            }
            else union.put(ss, s2.get(ss)); //같은 단어 없으면 -> 합집합에 추가
        }
        
        //System.out.println(union+" "+intersect);
        
        int uSize=0;//합집합 개수
        for(String ss:union.keySet()) uSize+=union.get(ss);
        
        int iSize=0;//교집합 개수
        for(String ss:intersect.keySet()) iSize+=intersect.get(ss);
        
        return (int)((iSize/(double)uSize)*65536);
    }
}
