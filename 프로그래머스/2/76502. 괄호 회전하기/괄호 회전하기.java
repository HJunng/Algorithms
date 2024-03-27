import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            String newStr = s.substring(i)+s.substring(0,i);
            if(isCorrect(newStr)) answer++;
        }
        
        return answer;
    }
    public boolean isCorrect(String s){
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            
            // 일단 스택이 비어있는지부터 확인 -> 비어있는데 닫는 괄호 나오면 올바른 괄호열 아님.
            else if(stack.isEmpty()) return false;
            
            // 괄호가 올바르게 짝지어졌는지 확인
            else if(stack.peek() == '(' && ch==')') stack.pop();
            else if(stack.peek() == '{' && ch=='}') stack.pop();
            else if(stack.peek() == '[' && ch==']') stack.pop();
            
            // 나머지의 경우 모두 false.
            else return false;
            
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}