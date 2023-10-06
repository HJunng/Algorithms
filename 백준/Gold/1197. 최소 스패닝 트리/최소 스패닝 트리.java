import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int node1;
		int node2;
		int cost;
		public Edge(int node1, int node2, int cost) {
			this.node1=node1;
			this.node2=node2;
			this.cost=cost;
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int V = Integer.parseInt(s[0]); // 정점의 개수 
		int E = Integer.parseInt(s[1]); //간선의 개수 
		
		Map<Integer,ArrayList<int[]>> map = new HashMap<>();
		for(int i=1;i<=V;i++) map.put(i, new ArrayList<>());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
		for(int i=0;i<E;i++) {
			s = br.readLine().split(" ");
			
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);
			
			pq.add(new Edge(n1,n2,cost));
		}
		
		System.out.println(findMinSpanning(pq,V));
		
	}
	static int findMinSpanning(PriorityQueue<Edge> pq, int V) {
		int minCost=0;
		
		int[] parent = new int[V+1]; // 각 노드의 부모 노드 저장. 
		for(int i=1;i<=V;i++) parent[i]=i; //각 부모노드를 자신으로 초기화.
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			int parent1 = parent[now.node1];
			int parent2 = parent[now.node2];
			
			if(parent1==parent2) { //0이 아닌데 두 노드의 parent가 같으면,
				continue;			//간선 추가했을 때 사이클 만들어짐.
			}else {
				renewParent(parent1,parent2,parent);
				minCost+=now.cost;
			}
		}
		
		return minCost;
	}
	static void renewParent(int p1, int p2, int[] parent) {
		int min = Math.min(p1, p2);
		int notMin = Math.max(p1, p2);
		
		for(int i=1;i<parent.length;i++) {
			if(parent[i]==notMin) parent[i]=min;
		}
	}
}