import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        
        while(n-->0 && !pq.isEmpty()){
             int now = pq.poll();
            if(now>0) pq.add(now-1); 
        }
        
        for(int remain : pq){
            answer += Math.pow(remain,2);
        }
        
        
        return answer;
    }
}