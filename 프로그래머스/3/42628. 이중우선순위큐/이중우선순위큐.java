import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<operations.length;i++){
            String[] now = operations[i].split(" ");
            
            if(now[0].equals("I")){
                pqMin.add(Integer.parseInt(now[1]));
                pqMax.add(Integer.parseInt(now[1]));
                
            } else if(now[1].equals("1") && !pqMax.isEmpty()){
                int out = pqMax.poll();
                pqMin.remove(out);
            } else if(now[1].equals("-1") && !pqMax.isEmpty()) {
                int out = pqMin.poll();
                pqMax.remove(out);
            }
        }
        
        if(pqMax.isEmpty()) return new int[]{0,0};
        else {
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        return answer;
    }
}