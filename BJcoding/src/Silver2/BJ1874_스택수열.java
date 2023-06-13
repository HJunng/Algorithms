package Silver2;

import java.io.*;
import java.util.Stack;
public class BJ1874_스택수열 { // 20min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int top=0;
		for(int i=0;i<n;i++) {
			int target = Integer.parseInt(br.readLine()); // 만들어야 하는 수.
			
			//현재 스택 top값이 만들어야 하는 수보다 작을 경우.
			while(top < target) { 
				stack.push(++top);
				sb.append("+").append("\n");
			}
			if(stack.pop()==target) { //최상위 값이 target이랑 같을 경우
				sb.append("-").append("\n");
				
			}else {// 불가능한 경우.
				System.out.println("NO");
				System.exit(0); //프로그램 종료
			}
		}
		System.out.println(sb);
	}
}