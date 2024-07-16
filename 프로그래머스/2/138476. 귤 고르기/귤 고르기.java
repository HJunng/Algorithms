import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> kindCount = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            kindCount.put(tangerine[i], kindCount.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> sortedList = new ArrayList<>(kindCount.keySet());
        Collections.sort(sortedList, (a,b) -> kindCount.get(b)-kindCount.get(a));
        
        for(int tan : sortedList){
            if(k>0){
                answer++;
                k -= kindCount.get(tan);
            }
            
            if(k==0) break;
        }
        
        return answer;
    }
}