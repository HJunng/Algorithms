package Silver2;

import java.io.*;

public class BJ1012_유기농배추 {
	static boolean[][] loc;
	static boolean[][] visited;
	static int M;
	static int N;

	public static void main(String[] args) throws Exception{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++) {
			
			String[] s = br.readLine().split(" ");
			
			M = Integer.parseInt(s[0]); //가로길이
			N = Integer.parseInt(s[1]); //세로길이
			int K = Integer.parseInt(s[2]); //배추 개수
			
			loc = new boolean[M][N]; //배추 위치
			visited = new boolean[M][N];//방문 여부
			
			for(int i=0;i<K;i++) {
				s = br.readLine().split(" ");
				
				loc[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=true;
			}
			int cnt=0; //벌레 개수
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(loc[i][j] && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static void dfs(int i, int j) {
		
		visited[i][j]=true;
		
		//상
		if(i-1>=0 && loc[i-1][j] && !visited[i-1][j])
			dfs(i-1,j);
		//하
		if(i+1<M && loc[i+1][j] && !visited[i+1][j])
			dfs(i+1,j);
		//좌
		if(j-1>=0 && loc[i][j-1] && !visited[i][j-1])
			dfs(i,j-1);
		//우
		if(j+1<N && loc[i][j+1] && !visited[i][j+1])
			dfs(i,j+1);
	}
}
