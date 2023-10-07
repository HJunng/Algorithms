import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights); //오름차순 정렬.
        Map<Double,Integer> nums = new HashMap<>();
        
        for(int i=0;i<weights.length;i++){
            double a = weights[i]*1.0;
            double b = a/2.0;
            double c = a*2/3.0;
            double d = a*3/4.0;
            
            if(nums.containsKey(a)) answer+=nums.get(a);
            if(nums.containsKey(b)) answer+=nums.get(b);
            if(nums.containsKey(c)) answer+=nums.get(c);
            if(nums.containsKey(d)) answer+=nums.get(d);
            
            nums.put(a,nums.getOrDefault(a,0)+1);
        }
        
        return answer;
    }
}