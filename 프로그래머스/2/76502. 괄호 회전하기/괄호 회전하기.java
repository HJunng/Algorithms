import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            String rotate = s.substring(i)+s.substring(0,i);
            
            if(isCorrect(rotate)){
                answer++;
            }
        }
        return answer;
    }
    boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c=='(' || c=='{' || c=='[') stack.push(c);
            else{
                if(stack.isEmpty()){
                    flag = false; break;
                }
                
                if((stack.peek()=='(' && c==')') || 
                  (stack.peek()=='{' && c=='}') ||
                  (stack.peek()=='[' && c==']')){
                    stack.pop();
                } else{
                    flag = false; break;
                }
            }
        }
        if(!stack.isEmpty()) flag = false;
        
        return flag;
    }
}