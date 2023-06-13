package Silver4;

import java.io.*;
import java.util.Stack;
public class BJ10773_제로 { // 4min.
	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<k;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num!=0) stack.push(num);
			else stack.pop();
		}
		
		int sum=0;
		for(int num : stack) {
			sum += num;
		}
		System.out.println(sum);
	}
}