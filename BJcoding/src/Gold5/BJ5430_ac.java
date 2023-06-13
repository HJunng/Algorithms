package Gold5;

import java.io.*;
import java.util.*;
public class BJ5430_ac { // 60min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //테스트케이스
		
		String p[]; // 수행할 함수
		int n;		// 배열에 들어있는 수의 개수
		while(T-- > 0) {
			p = br.readLine().split("");
			n = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			s = s.substring(1, s.length()-1); // "["와 "]"분리됨.
			String[] arr = s.split(","); // 주어진 배열을 숫자들만 분리
			
			LinkedList<Integer> deque = new LinkedList<>();
			for(int i=0;i<n;i++)
				deque.add(Integer.parseInt(arr[i]));
			
			int direction = 0;	// 0: 앞에부터, 1:뒤에부터, 2:error
			for(int i=0;i<p.length;i++) {
				if(p[i].equals("R")) {//명령이 R(순서뒤집기) 이면
					direction = (direction+1)%2;
				}else { // 명령이 D(버리기) 이면
					if(deque.isEmpty()) {
						sb.append("error").append("\n");
						direction=2; // error라는 걸 표시
						break;
					}else if(direction==0) { // 숫자를 빼는 방향이 앞이면
						deque.pollFirst();
					}else {
						deque.pollLast();
					}
				}
			}
			
			if(direction==0) { // 출력순서가 앞에부터이면 
				sb.append("[");
				if(!deque.isEmpty()) {
					while(!deque.isEmpty()) {
						sb.append(deque.pollFirst()).append(",");
					}
					sb.deleteCharAt(sb.length()-1); // 배열 개수 0개 일때 "[" 지워버릴 수 있음.
				}
				sb.append("]").append("\n");
			}else if(direction==1) { // 출력순서가 뒤에부터이면 
				sb.append("["); 
				if(!deque.isEmpty()) {
					while(!deque.isEmpty()) {
						sb.append(deque.pollLast()).append(",");
					}
					sb.deleteCharAt(sb.length()-1); // 배열 개수 0개 일때 "[" 지워버릴 수 있음.
				}
				sb.append("]").append("\n"); 
			 }
			//direction==2 로 error 난 것은 출력 없이 다음으로 넘어감.
		}
		System.out.println(sb);
	}
}