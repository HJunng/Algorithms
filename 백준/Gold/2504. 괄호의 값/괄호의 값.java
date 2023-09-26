import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		Stack<Character> stack = new Stack<>(); //괄호
		Stack<Integer> sum = new Stack<>(); //괄호 안의 값 계산.
		
		for(int i=0;i<str.length();i++) {
			char bracket = str.charAt(i);
			
			if(bracket=='(' || bracket=='[') {
				sum.push(0);//괄호 열리면 0 넣기.
				stack.push(bracket);
				
			}else if(bracket==')' || bracket==']') { //닫힌 괄호라면 
				
				if(stack.isEmpty()) {
					System.out.println(0);return;
				}
				
				if(bracket==')') { 
					if(stack.peek()=='(') { //괄호가 잘 닫혔는지 먼저 확인. 
						stack.pop();
						
						int tempsum=0;
						while(true) {
							int temp=sum.pop();
							
							if(temp==0) break;
							tempsum+=temp;
						}
						if(tempsum==0) sum.push(2);
						else sum.push(tempsum*2);
						
					}else { //잘못된 괄호 닫힘. 
						System.out.println(0);return;
					}
				}else { // ]
					if(stack.peek()=='[') { //괄호가 잘 닫혔는지 먼저 확인.
						stack.pop();
						
						int tempsum=0;
						while(true) {
							int temp=sum.pop();
							
							if(temp==0) break;
							tempsum+=temp;
						}
						if(tempsum==0) sum.push(3);
						else sum.push(tempsum*3);
						
					}else{
						System.out.println(0);return;
					}
				}
			}else {
				System.out.println(0);return;
			}
		}
		
		if(!stack.isEmpty()) { //괄호가 제대로 안닫힌 경우.
			System.out.println(0);return;
		}
		int answer=0;
		while(sum.size()>0) {
			answer+=sum.pop();
		}
		System.out.println(answer);
	}
}