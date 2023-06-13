package Silver2;

import java.io.*;
import java.util.*;
public class BJ24479_알고리즘수업_깊이우선탐색1 {
	//static boolean visited[];
	static HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
	static int orders[]; //visited도 포함해서 확인 가능.
	static int count=1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]); //정점의 수
		int M = Integer.parseInt(str[1]); //간선의 수
		int R = Integer.parseInt(str[2]); //시작 정점
		
		orders = new int[N+1];
		
		for(int i=0;i<N;i++) { //이거 필수!!!!
			graph.put(i+1, new ArrayList<>());
		}
		
		
		// HashMap<Intger,ArrayList<>> 로 간선 만들기.
		for(int i=0;i<M;i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i=1;i<graph.size();i++) {
			Collections.sort(graph.get(i));
		}
		
		dfs(R);
		
		for(int i=1;i<=N;i++)
			sb.append(orders[i]).append("\n");
		
		System.out.println(sb);
	}
	public static void dfs(int now) {
		
		orders[now]=count; //현재 방문하고 있는 정점에 순서 저장.
		count++;
		
		for(int i=0;i<graph.get(now).size();i++) {
			int newVertex =graph.get(now).get(i);
			//아직 방문하지 않았고, 현재 정점과 이어져있으면
			if(orders[newVertex]==0)
				dfs(newVertex);
		}
	}
}
