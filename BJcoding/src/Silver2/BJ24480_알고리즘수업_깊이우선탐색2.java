package Silver2;

import java.io.*;
import java.util.*;
public class BJ24480_알고리즘수업_깊이우선탐색2 {
	static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
	static int orders[];
	static int count=1;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		orders = new int[N+1];
		
		for(int i=0;i<N;i++)
			graph.put(i+1, new ArrayList<>());
		
		//그래프 저장.
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//인접 정점은 내림차순 정렬.
		for(int i=1;i<=N;i++)
			Collections.sort(graph.get(i), Collections.reverseOrder());
		
		dfs(R);
		
		for(int i=1;i<=N;i++)
			sb.append(orders[i]).append("\n");
		
		System.out.println(sb);
	}
	public static void dfs(int now) {
		orders[now]=count++; //정점 방문 표시 및 방문순서+1
		
		for(int i=0;i<graph.get(now).size();i++) {
			int next = graph.get(now).get(i);
			if(orders[next]==0) {//다음 정점이 아직 방문되지 않은 정점이면
				dfs(next);
			}
		}
	}
}
