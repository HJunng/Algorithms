package Stack_Queue;
import java.util.*;
public class Lv2_괄호회전하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(solution("[](){}"));
	}
	static public int solution(String s) {
        int answer = 0;
        
        Queue<Character> string = new LinkedList<>();
        for(int i=0;i<s.length();i++)
            string.add(s.charAt(i));
        
        int n = s.length();
        Queue<Character> tempQ;
        //문자열 길이만큼 왼쪽으로 회전.
        for(int i=0;i<n;i++){
            
            tempQ = string;
            //System.out.println(string);
            
            Stack<Character> stack = new Stack<>();//괄호 검사
            //System.out.println(string);
            for(int j=0;j<n;j++){
                char ch = tempQ.poll();
                
                //비어있으면 그냥 넣고
                if(stack.isEmpty()){
                    stack.push(ch);
                    continue;
                }
                //비어있지 않으면 검사
                if(stack.peek()==ch)
                    stack.pop();
                else
                    break;
                //System.out.println(j+" "+string);
            }
            //올바른 괄호 문자열이면
            if(tempQ.isEmpty() && stack.isEmpty())
                answer++;
            
            //System.out.println(string);
            //문자열 회전
            string.add(string.poll());
            //System.out.println(string);
        }
        
        return answer;
    }
}
