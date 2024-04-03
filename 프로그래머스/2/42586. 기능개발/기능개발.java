import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++) 
            q.add(new int[]{progresses[i],speeds[i]});
        
        int days =0;
        List<Integer> answer = new ArrayList<>();
        
        while(!q.isEmpty()){
            int[] first = q.peek();
            
            // 첫번째 process를 100이상으로 만들기 위해서 며칠이 필요한지 계산
            days += (100 - first[0] -days * first[1]) % first[1] == 0 ?
                (100 - first[0] -days * first[1]) / first[1] :
                (100 - first[0] -days * first[1]) / first[1] +1;
            
            int cnt =0;
            while(!q.isEmpty()) {
                int[] p = q.peek();
                
                if(p[0]+days*p[1]>=100){
                    cnt++;
                    q.poll();
                }
                else break;
            }
            
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}