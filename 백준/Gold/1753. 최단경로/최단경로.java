import java.io.*;
import java.util.*;

public class Main {
	static class Node{ 
		int end; 	// 도착지 
		int weight; // 가중치 
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	static int V; // 정점의 개수 
	static int[] result; // 최단경로 
	static ArrayList<ArrayList<Node>> graph; // 연결된 간선 정보 저장.
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		V = Integer.parseInt(s[0]); // 정점의 개수 
		int E = Integer.parseInt(s[1]); // 간선의 개수 
		int start = Integer.parseInt(br.readLine()); // 시작 노드 
		
		result = new int[V+1]; 		  // 최단 경로 값 저장 배열 
		graph = new ArrayList<>(); // 연결 정보 저장 graph
		
		// 연결 정보 저장할 배열, 최단 경로 값 저장 배열 초기화
		for(int i=0;i<=V;i++) graph.add(new ArrayList<>());
		
		for(int i=0;i<E;i++) {
			s = br.readLine().split(" ");
			int from = Integer.parseInt(s[0]); // 출발 
			int to = Integer.parseInt(s[1]);   // 도착 
			int weight = Integer.parseInt(s[2]); // 가중치 
			
			graph.get(from).add(new Node(to,weight)); // 출발 노드와 연결된 {도착노드, 가중치} 저장.
		}
		
		dijkstra(start);
		
		
		// 출력
		for(int i=1;i<=V;i++) {
			if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(result[i]);
		}		
	}
	// 다익스트라
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V+1]; // 방문처리 배열 
		
		result = new int[V+1]; // 최단 경로.
		Arrays.fill(result, Integer.MAX_VALUE); // 모든 경로는 max값으로 초기화.
		result[start]=0; // 시작->시작으로 가는 최단 경로는 0이다.
		
		// 가중치가 작은 순으로 다음으로 방문할 위치 정렬.
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
		pq.add(new Node(start,0)); // 시작위치 넣기.
		
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			
			if(!visited[now.end]) { // 기존에 방문하지 않은 정점일 때, 아래 작업 수행.
				visited[now.end]=true; // 방문처리
				
				// 현재 정점에서 이어질 다음 정점 : next
				for(Node next : graph.get(now.end)) {
					// 다음 정점에 방문하지 않았고,
					// 현재 가중치 + 현재->다음위치까지의 가중치 < 다음 정점으로의 최단 경로
					if(!visited[next.end] && result[next.end]> now.weight + next.weight) {
						
						// 해당 정점으로의 최단 경로 값 update
						result[next.end] = now.weight + next.weight;
						// 다음 방문할 예정이므로 pq에 넣어주기
						pq.add(new Node(next.end, result[next.end]));
					}
				}
			}
		}
	}
}