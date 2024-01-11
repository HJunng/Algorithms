import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.replace("{","");
        s = s.replace("}","");
        
        String[] nums = s.split(",");
        
        Map<Integer,Integer> numCnt = new HashMap<>();
        for(String num : nums){
            int n = Integer.parseInt(num);
            numCnt.put(n, numCnt.getOrDefault(n,0)+1);
        }
        
        ArrayList<Integer> key = new ArrayList<>(numCnt.keySet());
        Collections.sort(key, (a,b)-> numCnt.get(b)-numCnt.get(a));
        
        answer = new int[key.size()];
        for(int i=0;i<key.size();i++){
            answer[i] = key.get(i);
        }
        
        return answer;
    }
}