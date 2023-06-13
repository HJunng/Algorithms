package Stack_Queue;

import java.util.*;
public class Lv2_올바른괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
				//Integer형으로 만들면 효율성 오류 남.
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='('){
                stack.push('(');
                
            }else{ // ')'
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(answer){ // 중간에 오류나지 않고 끝까지 검사를 마쳤을 때
            //검사 끝나고 stack이 비어있으면 완벽한 true
            if(!stack.isEmpty())
                answer = false;
        }
        
        return answer;
    }
}
