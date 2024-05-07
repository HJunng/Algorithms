import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            
            while(!stack.isEmpty() && stack.peek()[0]>prices[i]) {
                int[] out = stack.pop();
                answer[out[1]] = i-out[1];
            }
            
            stack.push(new int[]{prices[i],i});
        }
        
        for(int[] out : stack){
            answer[out[1]] = prices.length-out[1]-1;
        }
        
        return answer;
    }
}