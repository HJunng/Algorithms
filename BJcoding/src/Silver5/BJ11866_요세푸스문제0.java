package Silver5;

import java.util.*;
public class BJ11866_요세푸스문제0 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = s.nextInt();
		int k = s.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) // 1-n번까지의 사람을 queue에 넣음.
			q.add(i);
		
		int count=0;
		sb.append("<");
		while(!q.isEmpty()) {
			count++;
			
			if(count==k) {
				sb.append(q.poll());
				count=0;
				if(!q.isEmpty()) //last을 제외하고 ", "을 붙임.
					sb.append(", ");
			}
			else
				q.add(q.poll());
		}
		sb.append(">");
		System.out.println(sb);
	}
}