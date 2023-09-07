package GoormthonChallenge;

import java.io.*;
import java.util.*;
public class Day19_대체경로 {

	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]); //도시의 수
		int m = Integer.parseInt(input[1]); //도로의 수
		int s = Integer.parseInt(input[2]); //출발 도시
		int e = Integer.parseInt(input[3]); //도착 도시
		
		Map<Integer,Set<Integer>> country = new HashMap<>();
		for(int i=1;i<=n;i++) country.put(i,new HashSet<>()); //각 도시별 연결된 도로 초기화
		
		
		for(int i=0;i<m;i++){
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]); //연결된 도시
			int b = Integer.parseInt(input[1]);
			
			country.get(a).add(b); //a와 연결된 도시b 추가
			country.get(b).add(a); //b와 연결된 도시a 추가
		}
		
		for(int i=1;i<=n;i++){
			
			if(i==s || i==e){ // 시작도시 or 도착도시가 공사중이면 -> 무조건 e에 도착할 수 없음.
				System.out.println(-1); continue;
			}
			visited = new boolean[n+1];
			System.out.println(bfs(s,e,i,country));
		}
	}
	static int bfs(int start, int end, int fix, Map<Integer,Set<Integer>> country){
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{start,1}); //시작위치 , 방문한 도시 개수
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			
			if(now[0]==end){
				return now[1];
			}
			
			for(int next : country.get(now[0])){
				if(!visited[next] && next!=fix){ //방문한 적없고, 공사중인 도시가 아니면
					visited[next]=true;
					q.add(new int[]{next,now[1]+1}); //지금까지 방문한 도시 개수 + 다음 도시
				}
			}
		}
		return -1; //e를 방문할 수 없다면 -1 return.
	}

}
