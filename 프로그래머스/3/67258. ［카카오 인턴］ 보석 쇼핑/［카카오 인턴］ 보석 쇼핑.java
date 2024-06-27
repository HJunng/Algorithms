import java.util.*;

class Solution {
    Map<String,Integer> now;
    public int[] solution(String[] gems) {
        int[] answer = {1,gems.length};
        
        Set<String> total = new HashSet<>();
        for(String gem : gems) total.add(gem);
        
        int left = 0;
        int right = 0;
        now = new HashMap<>();
        now.put(gems[0],1);
        
        while(left<gems.length && right<gems.length){
            if(right != gems.length-1 && now.size()<total.size()){
                right++;
                now.put(gems[right], now.getOrDefault(gems[right],0)+1);
            } else if(now.size()==total.size()){
                if(right-left < answer[1]-answer[0]){
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                
                mapDel(gems[left]);
                left++;
            } else {
                mapDel(gems[left]);
                left++;
            }
        }
        
        return answer;
    }
    void mapDel(String s){
        
        if(now.get(s)==1){
            now.remove(s);
        } else {
            now.put(s, now.get(s)-1);
        }
    }
}