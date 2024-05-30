import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int idx=0;
        
        for(int i=1;i<=order.length;i++){
            // 순서랑 맞으면 트럭에 싣고, 아니면 stack에 담아두기.
            if(i==order[idx]) idx++;
            else stack.push(i);
            
            while(!stack.isEmpty() && stack.peek()==order[idx]){
                stack.pop();
                idx++;
            }
        }
        
        return idx;
    }
}