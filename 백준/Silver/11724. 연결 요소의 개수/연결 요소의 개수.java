import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]); // 정점의 개수 
		int M = Integer.parseInt(s[1]); // 간선의 개수 
		
		Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
		for(int i=1;i<=N;i++) graph.put(i,new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new boolean[N+1];
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				cnt++;
				bfs(i,graph);
			}
		}
		
		System.out.println(cnt);
	}
	
	static void bfs(int start, Map<Integer,ArrayList<Integer>> graph) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : graph.get(now)) {
				if(!visited[next]) {
					visited[next]=true;
					q.add(next);
				}
			}
		}
	}
}