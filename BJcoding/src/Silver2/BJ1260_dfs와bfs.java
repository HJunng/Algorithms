package Silver2;

import java.io.*;
import java.util.*;
public class BJ1260_dfs와bfs {
	static int N;
	static int M;
	static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
	
	static ArrayList<Integer> dfsVisit = new ArrayList<>();
	static ArrayList<Integer> bfsVisit = new ArrayList<>();

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s[] = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		
		for(int i=0;i<N;i++)
			graph.put(i+1, new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			
			graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
			graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
		}
		for(int i=0;i<N;i++)
			Collections.sort(graph.get(i+1));
		
		dfs(V);
		bfs(V);
		
		for(int i:dfsVisit)
			sb.append(i+" ");
		sb.append("\n");
		for(int i : bfsVisit)
			sb.append(i+" ");
		
		System.out.println(sb);
	}
	private static void dfs(int start) {
		dfsVisit.add(start);
		
		for(int i:graph.get(start)) {
			if(!dfsVisit.contains(i))
				dfs(i);
		}
	}
	private static void bfs(int start) {
		
		bfsVisit.add(start);
		q.add(start);
		
		while(q.size()>0) {
			int now = q.poll();
			for(int i:graph.get(now)) {
				if(!bfsVisit.contains(i)) {
					q.add(i);
					bfsVisit.add(i);
				}
			}
		}
	}
}
