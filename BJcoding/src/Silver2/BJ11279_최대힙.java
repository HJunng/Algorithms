package Silver2;

import java.io.*;
import java.util.*;

public class BJ11279_최대힙 { //20min. 답.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			int command = Integer.parseInt(br.readLine());
			
			if(command==0) {
				if(q.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(q.poll()).append("\n");
				}
			}else {
				q.add(command);
			}
		}
		System.out.println(sb);
	}
}