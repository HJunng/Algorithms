import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 일단 문자열을 다 대문자만 있도록 만들어 주기.
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String,Integer> a = new HashMap<>();
        Map<String,Integer> b = new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            if(str1.charAt(i)<'A'|| str1.charAt(i)>'Z') continue;
            if(str1.charAt(i+1)<'A'|| str1.charAt(i+1)>'Z') continue;
            
            String temp = str1.charAt(i)+""+str1.charAt(i+1);
            a.put(temp, a.getOrDefault(temp,0)+1);
        }
        
        for(int i=0;i<str2.length()-1;i++){
            if(str2.charAt(i)<'A'|| str2.charAt(i)>'Z') continue;
            if(str2.charAt(i+1)<'A'|| str2.charAt(i+1)>'Z') continue;
            
            String temp = str2.charAt(i)+""+str2.charAt(i+1);
            b.put(temp, b.getOrDefault(temp,0)+1);
        }
        //System.out.println(a);
        //System.out.println(b);
        
        int union=0;        // 합집합 원소 갯수
        int intersection=0; // 교집합 원소 갯수
        
        for(String aElement : a.keySet()){
            int aCnt = a.get(aElement);
            int bCnt = b.getOrDefault(aElement,0);
            
            union += Math.max(aCnt,bCnt);
            intersection += Math.min(aCnt,bCnt);
        }
        for(String bElement : b.keySet()){
            // 이전에 중복된 원소는 앞에서 다 추가됨.
            if(a.containsKey(bElement)) continue;
            
            // a집합에 중복되지 않은 원소들만 합집합에 갯수 더하기.
            union += b.get(bElement);
        }
        
        // 자카드 유사도
        double similar = 0;
        if(union==0 && intersection==0) similar=1;
        else if(union==0 || intersection==0) similar=0;
        else similar = intersection/(double)union;
        
        answer = (int)(similar * 65536);
        
        return answer;
    }
}