import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String sub = str1.substring(i,i+2).toUpperCase();
            
            if(sub.charAt(0)<'A' || sub.charAt(0)>'Z') continue;
            if(sub.charAt(1)<'A' || sub.charAt(1)>'Z') continue;
            
            a.put(sub, a.getOrDefault(sub,0)+1);
        }
        
        for(int i=0;i<str2.length()-1;i++){
            String sub = str2.substring(i,i+2).toUpperCase();
            
            if(sub.charAt(0)<'A' || sub.charAt(0)>'Z') continue;
            if(sub.charAt(1)<'A' || sub.charAt(1)>'Z') continue;
            
            b.put(sub, b.getOrDefault(sub,0)+1);
        }
        
        // 두 집합이 공집합일 경우
        if(a.size()==0 && b.size()==0) return 65536;
        else if(a.size()==0 || b.size()==0) return 0;
        
        Map<String, Integer> union = new HashMap<>(); //합집합
        Map<String, Integer> intersection = new HashMap<>(); //교집합
        
        for(String s : a.keySet()){
            union.put(s, union.getOrDefault(s,0)+a.get(s));
        }
        
        for(String s : b.keySet()){
            if(union.containsKey(s)){
                union.put(s, Math.max(a.get(s), b.get(s)));
                intersection.put(s, Math.min(a.get(s),b.get(s)));
            }else{
                union.put(s, union.getOrDefault(s,0)+b.get(s));
            }
        }
        
        // System.out.println(intersection);
        // System.out.println(union);
        
        int unionCnt = 0;
        for(int i : union.values()){
            unionCnt+=i;
        }
        
        int interCnt = 0;
        for(int i : intersection.values())
            interCnt += i;
        
        
        return (int)((interCnt / (double)unionCnt) * 65536);
    }
}