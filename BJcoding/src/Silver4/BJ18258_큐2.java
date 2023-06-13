package Silver4;

import java.io.*;
import java.util.*;
public class BJ18258_큐2 { // 20min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>(); //까먹었음.
		String str[];
		
		int back=0; //queue에는 마지막값을 빼는 방법 없음.
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			
			switch(str[0]){ // 입력 명령어
			
			case("push"):{
				back = Integer.parseInt(str[1]);
				q.add(back);
				break;
			}
			case("pop"):{
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.poll()).append("\n");
				break;
			}
			case("size"):{
				sb.append(q.size()).append("\n");
				break;
			}
			case("empty"):{
				if(q.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			}
			case("front"):{
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peek()).append("\n");
				break;
			}
			case("back"):{
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(back).append("\n");
				break;
			}
			}
		}
		System.out.println(sb);
	}
}