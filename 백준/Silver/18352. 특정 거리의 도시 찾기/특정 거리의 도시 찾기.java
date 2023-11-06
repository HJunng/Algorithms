import java.io.*;
import java.util.*;

public class Main {
	static int N; 								// 도시의 개수 
	static ArrayList<ArrayList<Integer>> graph; // 연결된 도시 정보.
	static int[] dist;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]); // 도시의 개수 
		int M = Integer.parseInt(s[1]); // 도로의 개수 
		int K = Integer.parseInt(s[2]); //  구해야 하는 도시의 최단 거리.
		int start = Integer.parseInt(s[3]); // 출발 도시 번호 
		
		graph = new ArrayList<>(); // 연결된 도시 정보.
		for(int i=0;i<=N;i++) graph.add(new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			
			int from = Integer.parseInt(s[0]);
			int to = Integer.parseInt(s[1]);
			
			graph.get(from).add(to);
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			if(dist[i]==K) sb.append(i+"\n");
		}
		
		if(sb.length()==0) System.out.println(-1);
		else System.out.println(sb);
		
	}
	static void dijkstra(int start) {
		
		boolean[] visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			
			int[] now = pq.poll();
			
			if(!visited[now[0]]) {
				visited[now[0]] = true;
				
				for(int next : graph.get(now[0])) {
					
					if(!visited[next] && dist[next]> dist[now[0]]+1) {
						dist[next] = dist[now[0]]+1;
						pq.add(new int[] {next,dist[next]});
					}
					
				}
			}
		}
		
		
	}
}