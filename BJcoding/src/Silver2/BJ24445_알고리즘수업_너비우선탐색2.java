package Silver2;

import java.io.*;
import java.util.*;
public class BJ24445_알고리즘수업_너비우선탐색2 {
	static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
	static Queue<Integer> q = new LinkedList<>();
	static int[] orders;
	static int cnt=1;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		
		orders = new int[N+1];
		
		for(int i=0;i<N;i++)
			graph.put(i+1, new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			
			graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
			graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
		}
		for(int i=0;i<N;i++)
			Collections.sort(graph.get(i+1),Collections.reverseOrder());
		
		bfs(R);
		
		for(int i=1;i<=N;i++)
			System.out.println(orders[i]);
	}

	private static void bfs(int start) {
		
		orders[start] = cnt++;
		q.add(start);
		
		while(q.size()>0) {
			int now = q.poll();
			for(int i:graph.get(now)) {
				if(orders[i]==0) {
					orders[i]=cnt++;
					q.add(i);
				}
			}
		}
	}
}