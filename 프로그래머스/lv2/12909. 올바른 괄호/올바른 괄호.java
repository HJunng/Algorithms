import java.util.*;
class Solution {
    boolean solution(String s) { //주어진 괄호 문자열: s

        Stack<Character> stack = new Stack<>(); //스택 선언.
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){ //열린 괄호열은 그냥 stack에 넣어주기.
                stack.push('('); 
                
            }else{  //닫힌 괄호열이라면
                if(stack.isEmpty()){ //열린 괄호 없이 닫는다면, 올바르지 않은 괄호열 
                    return false;
                }
                stack.pop(); //정상적인 괄호 닫기. -> pop
            }
        }
     
        if(!stack.isEmpty()) //문자열이 모두 끝났는데 닫히지 않은 괄호가 남아있으면 false.
            return false;
        
        return true;
    }
}