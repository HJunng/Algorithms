package Silver3;

import java.io.*;
import java.util.*;
public class BJ2606_바이러스 {
	static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int cnt=0; //감염된 컴퓨터 수.

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());
		
		visited = new boolean[nodes+1];
		
		for(int i=0;i<nodes;i++)
			graph.put(i+1, new ArrayList<>());
		
		String[] s;
		for(int i=0;i<edges;i++) {
			s= br.readLine().split(" ");
			
			graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
			graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
		}
		bfs(1);
		System.out.println(cnt-1); //1번 컴퓨터는 빼야함.
	}

	private static void dfs(int start) {
		visited[start]=true;
		cnt++;
		
		for(int i:graph.get(start)) {
			if(!visited[i])
				dfs(i);
		}
	}
	private static void bfs(int start) {
		visited[start]=true;
		cnt++;
		q.add(start);
		
		while(q.size()>0) {
			int now = q.poll();
			
			for(int i:graph.get(now)) {
				if(!visited[i]) {
					q.add(i);
					visited[i]=true;
					cnt++;
				}
			}
		}
	}
}