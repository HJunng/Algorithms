import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> descend = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> ascend = new PriorityQueue<>();
        
        for(int i=0;i<operations.length;i++){
            String[] ops = operations[i].split(" ");
            
            if(ops[0].equals("I")){
                descend.add(Integer.parseInt(ops[1]));
                ascend.add(Integer.parseInt(ops[1]));
                
            }else{ // "D"
                if(ascend.isEmpty()) continue;
                
                int pop = Integer.parseInt(ops[1]);
                
                if(pop>0){ // 최댓값 삭제
                    int max = descend.poll();
                    ascend.remove(max);
                }else{ // 최솟값 삭제
                    int min = ascend.poll();
                    descend.remove(min);
                }
            }
        }
        if(ascend.isEmpty()) return new int[]{0,0};
        
        answer[0] = descend.poll();
        answer[1] = ascend.poll();
        
        return answer;
    }
}