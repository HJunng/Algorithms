package Silver1;

import java.io.*;
import java.util.*;

public class BJ11286_절댓값힙 { // 40min. 답.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if(Math.abs(i1)>Math.abs(i2)) {
					return Math.abs(i1)-Math.abs(i2);	//i1-i2 : 오름차순
				}else if(Math.abs(i1)==Math.abs(i2)) {
					return i1-i2;
				}else {
					return -1; // 그대로 둠.
				}
			}
		});
		
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