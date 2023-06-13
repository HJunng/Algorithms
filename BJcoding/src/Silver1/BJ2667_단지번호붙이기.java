package Silver1;

import java.io.*;
import java.util.*;
public class BJ2667_단지번호붙이기 {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		String[] s;
		for(int i=0;i<N;i++) {
			s = br.readLine().split("");
			
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(s[j]);
		}
		//단지 내 집수 넣기
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//집이 있고, 방문한 적이 없으면 dfs 확인.
				if(map[i][j]==1 && !visited[i][j]) {
					cnt=0;
					dfs(i,j);
					answer.add(cnt);
				}
			}
		}
		
		Collections.sort(answer); //오름차순 정렬
		//총 단지 수
		System.out.println(answer.size());
		
		for(int i:answer)
			System.out.println(i);
	}

	private static void dfs(int i, int j) {
		
		visited[i][j]=true;
		cnt++;
		
		//오른쪽
		//오른쪽으로 갈 수 있고, 오른쪽에 집이 있고, 방문한 적이 없다면
		if(j+1<N && map[i][j+1]==1 && !visited[i][j+1])
			dfs(i,j+1);
		//왼쪽
		if(j-1>=0 && map[i][j-1]==1 && !visited[i][j-1])
			dfs(i,j-1);
		//아래
		if(i+1<N && map[i+1][j]==1 && !visited[i+1][j])
			dfs(i+1,j);
		//위
		if(i-1>=0 && map[i-1][j]==1 && !visited[i-1][j])
			dfs(i-1,j);
	}
}