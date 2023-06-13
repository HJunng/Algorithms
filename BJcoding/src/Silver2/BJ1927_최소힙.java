package Silver2;

import java.io.*;
import java.util.PriorityQueue;

public class BJ1927_최소힙 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				if(q.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(q.poll()).append("\n");
				}
			}else {
				q.add(num);
			}
		}
		System.out.println(sb);
	}
}