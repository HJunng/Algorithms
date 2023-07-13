package Silver2;

import java.io.*;
import java.util.*;

public class BJ1260_dfs와bfs_2 {
	static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);//정점
		int m = Integer.parseInt(s[1]);//간선
		int v = Integer.parseInt(s[2]);//시작번호
		
		for(int i=1;i<=n;i++) map.put(i,new ArrayList<>());
		
		for(int i=0;i<m;i++) {
			s = br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			
			map.get(a).add(b);//간선추가
			map.get(b).add(a);
		}
		
		//오름차순 정렬
		for(int i=1;i<=n;i++) Collections.sort(map.get(i));
		
		visited = new boolean[n+1];
		dfs(v,0);
		System.out.println();
		
		Arrays.fill(visited, false);
		bfs(v);
		
	}
	static void dfs(int start, int depth) {
		
		if(depth==map.size()) return;
		
		System.out.print(start+" ");
		visited[start]=true;
		
		for(int i:map.get(start)) {
			if(!visited[i]) dfs(i,depth+1);
		}
	}
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			for(int i:map.get(now)) {
				if(!visited[i]) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
	}
}
