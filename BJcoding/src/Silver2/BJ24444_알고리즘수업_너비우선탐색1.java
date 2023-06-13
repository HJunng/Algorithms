package Silver2;

import java.io.*;
import java.util.*;
public class BJ24444_알고리즘수업_너비우선탐색1 {
	static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
	static int orders[];
	static int cnt=1;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]); //정점 개수
		int M = Integer.parseInt(s[1]); //간선 개수
		int R = Integer.parseInt(s[2]);
		orders = new int[N+1];
		
		for(int i=0;i<N;i++)
			graph.put(i+1, new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//인접 정점 오름차순 정렬.
		for(int i=0;i<N;i++)
			Collections.sort(graph.get(i+1));
		
		bfs(R);
		
		for(int i=1;i<=N;i++)
			sb.append(orders[i]).append("\n");
		
		System.out.println(sb);
		
	}
	public static void bfs(int now) {
		//now 정점 방문 순서 입력, 그 후 +1.
		orders[now]=cnt++;
		q.add(now);
		while(q.size()>0) {
			int u = q.poll();
			for(int i=0;i<graph.get(u).size();i++) {
				//인접한 정점
				int v = graph.get(u).get(i);
				
				if(orders[v]==0) { //아직 방문하지 않았으면
					orders[v]=cnt++;
					q.add(v);
				}
			}
		}
		
	}
}
