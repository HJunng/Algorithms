package Silver4;

import java.io.*;
import java.util.Stack;

public class BJ4949_균형잡힌세상 { // 20min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str;
		Stack<Integer> stack = new Stack<>(); //괄호를 담을 stack
		// () : 0으로 나타내고, [] : 1로 나타냄, 그리고 오류는 2로 넣을 것임.
		
		while(!(str = br.readLine()).equals(".")) { //한 문장 받아와서 "."인지 체크
			//스택 초기화
			stack.clear();
			
			for(int i=0;i<str.length();i++) {
				
				if(str.charAt(i)=='(') {
					stack.push(0); // ( : 0
				}else if(str.charAt(i)=='[') {
					stack.push(1); // [ : 1
					
				}else if(str.charAt(i)==')') { //괄호를 닫으려면 
					
					//empty 검사를 해주지 않고 하면 pop를 했을 때 emtpyStackException.
					if(stack.empty()) {
						stack.push(2); //오류.
						break;
					}else if(stack.pop()==0){
						continue;
						
					}else { // 앞의 괄호가 0이 아니면 또 오류.
						stack.push(2); //오류.
						break;
					}
				}else if(str.charAt(i)==']') { //위와 같은 방식
					if(stack.empty()) {
						stack.push(2); // 비어있는데 pop하면 오류.
						break;
					}else if(stack.pop()==1){
						continue;
						
					}else { // 앞의 괄호가 1이 아니면 또 오류.
						stack.push(2); //오류.
						break;
					}
				}
			}
			if(stack.empty()) //정상적으로 stack이 비어있으면
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		System.out.println(sb);
	}
}