package Silver4;

import java.io.*;
import java.util.Stack;
public class BJ9012_괄호 {  // 15min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		String str[];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<t;i++) { // 주어진 TestCase만큼 반복
			str = br.readLine().split("");
			stack.clear();
			
			for(int j=0;j<str.length;j++) { // 입력된 String 한줄에 대해
				
				//괄호가 열리면 무조건 push
				if(str[j].equals("("))
					stack.push(1);
				else { // 괄호를 닫을 때
					
					//stack이 비어있는데 닫으려고 하면 underflow가 나기때문에 empty검사 해줌.
					if(stack.empty()) {
						//비어있는데 pop을 해야하므로 push를 하고 break해서, 마지막 empty검사할 때 걸리도록 만듦.
						stack.push(0); 
						break;	
					}else
						stack.pop(); //정상적인 pop실행.
				}
			}
			if(stack.empty()) //올바른 괄호 문자열 : vps 이면
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}