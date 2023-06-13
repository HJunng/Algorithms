package Silver4;

import java.io.*;
import java.util.Stack;
public class BJ10828_스택 { // 7m.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		String str[];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			
			// push X : 정수 X를 스택에 넣음
			if(str[0].equals("push")) {
				stack.push(Integer.parseInt(str[1]));
				
			//pop : 스택의 가장 위에 있는 정수를 빼서 출력. 없으면 -1.
			}else if(str[0].equals("pop")) {
				if(stack.empty())
					sb.append(-1).append("\n");
				else
					sb.append(stack.pop()).append("\n");
				
			//size : 스택에 들어있는 정수의 개수 출력.
			}else if(str[0].equals("size")) {
				sb.append(stack.size()).append("\n");
				
			//empty : 비어있으면 1, 아니면 0 출력.
			}else if(str[0].equals("empty")) {
				if(stack.empty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				
			//스택에 가장 위에 있는 정수 출력. 없으면 -1.
			}else if(str[0].equals("top")) {
				if(stack.empty())
					sb.append(-1).append("\n");
				else
					sb.append(stack.peek()).append("\n");
			}
		}
		System.out.println(sb);
	}
}