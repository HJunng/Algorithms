import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 작업량이 많은 순으로 정렬되게 일을 pq에 넣음.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        
        for(int i=0;i<n;i++){
            if(pq.peek()==0) break;
            pq.add(pq.poll()-1);
        }
        
        for(int i=0;i<works.length;i++)
            answer+=Math.pow(pq.poll(),2);
        
        return answer;
    }
}