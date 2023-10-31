import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int end;
		int weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		int start = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[V+1]; // 방문처리 
		int[] result = new int[V+1]; 		  // 최단 경로 값 저장 배열 
		List<Node>[] list = new List[V+1];    // 연결 정보 저장 배열 
		
		// 연결 정보 저장할 배열, 최단 경로 값 저장 배열 초기화
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
			result[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			s = br.readLine().split(" ");
			int from = Integer.parseInt(s[0]);
			int to = Integer.parseInt(s[1]);
			int weight = Integer.parseInt(s[2]);
			
			list[from].add(new Node(to,weight)); // 출발 노드와 연결된 {도착노드, 가중치} 저장.
		}
		
		// 다익스트라
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
		result[start]=0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.end]) visited[now.end] = true; // 방문처리
			
			// 현재 정점과 연결된 간선들에 대해 판단
			for(int i=0;i<list[now.end].size();i++) {
				// 현재 정점에서 이어질 다음 정점
				Node next = list[now.end].get(i);
				
				// 다음 정점에 방문하지 않았고,
				// 현재 가중치 + 해당 정점으로 향하는 가중치 < 해당 정점으로의 최단 경로 라면
				if(!visited[next.end] && now.weight+next.weight < result[next.end]) {
					// 해당 정점으로의 최단 경로 값 update
					result[next.end] = now.weight + next.weight;
					// 다음 방문할 예정이므로 pq에 넣어주기
					pq.add(new Node(next.end,result[next.end]));
				}
			}
		}
		
		// 출력
		for(int i=1;i<=V;i++) {
			if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(result[i]);
		}		
	}
}