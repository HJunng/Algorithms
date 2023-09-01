package GoormthonChallenge;

import java.util.*;
import java.io.*;

public class Day14_작은노드 {
	static Map<Integer,ArrayList<Integer>> graph;
	static boolean visited[];
	static int cnt=0;
	static int lastNode=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);//노드 개수
		int m = Integer.parseInt(s[1]);//간선 개수
		int k = Integer.parseInt(s[2]);//시작 노드 번호
		
		graph = new HashMap<>();//그래프 담을 공간
		for(int i=1;i<=n;i++) graph.put(i,new ArrayList<>()); //graph 초기화 : 공간 할당
		
		for(int i=0;i<m;i++){
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			graph.get(a).add(b);//간선 추가
			graph.get(b).add(a);
		}
		
		for(int i=1;i<=n;i++) Collections.sort(graph.get(i));
		
		visited = new boolean[n+1];//방문처리
		dfs(k);
		
		System.out.println(cnt+" "+lastNode);
	}
	static void dfs(int now){
		
		visited[now]=true;
		cnt++;
		lastNode=now;
		
		for(int next: graph.get(now)){
			if(!visited[next]){
				dfs(next);break;
			}
		}
	}

}
