
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<priorities.length;i++){
            if(i==location) q.add(new int[]{priorities[i],1});
            else q.add(new int[]{priorities[i],0});
            
            pq.add(priorities[i]);
        }
        
        int cnt=1;
        while(!q.isEmpty()){
            int pr = pq.poll();
            
            while(q.peek()[0] != pr){
                q.add(q.poll());
            }
            
            int[] now = q.poll();
            if(now[1]==1) break;
            else cnt++;
        }
        
        return cnt;
    }
}