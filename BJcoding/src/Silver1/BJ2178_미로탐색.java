package Silver1;

import java.io.*;
import java.util.*;
public class BJ2178_미로탐색 {
	static int[][] maze;
	static int[][] visited;
	static int N;
	static int M;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		maze = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split("");
			for(int j=0;j<M;j++)
				maze[i][j]=Integer.parseInt(s[j]);
		}
		
		bfs(0,0);
		
		System.out.println(visited[N-1][M-1]);
	}

	private static void bfs(int i, int j) {
		
		
		visited[i][j] = maze[i][j];
		q.add(new int[] {i,j});
		
		while(q.size()>0) {
			int[] now = q.poll();
			
			//오른쪽
			if(now[1]+1<M && maze[now[0]][now[1]+1]==1 && (visited[now[0]][now[1]+1]==0 || visited[now[0]][now[1]+1]>visited[now[0]][now[1]]+1)) {
				q.add(new int[] {now[0],now[1]+1});
				visited[now[0]][now[1]+1]=visited[now[0]][now[1]]+1;
			}
			//아래
			if(now[0]+1<N && maze[now[0]+1][now[1]]==1 && (visited[now[0]+1][now[1]]==0 || visited[now[0]+1][now[1]]>visited[now[0]][now[1]]+1)) {
				q.add(new int[] {now[0]+1,now[1]});
				visited[now[0]+1][now[1]] = visited[now[0]][now[1]]+1;
			}
			//왼쪽
			if(now[1]-1>=0 && maze[now[0]][now[1]-1]==1 && (visited[now[0]][now[1]-1]==0 || visited[now[0]][now[1]-1]>visited[now[0]][now[1]]+1)) {
				q.add(new int[] {now[0],now[1]-1});
				visited[now[0]][now[1]-1] = visited[now[0]][now[1]]+1;
			}
			//위
			if(now[0]-1>=0 && maze[now[0]-1][now[1]]==1 && (visited[now[0]-1][now[1]]==0 || visited[now[0]-1][now[1]]>visited[now[0]][now[1]]+1)) {
				q.add(new int[] {now[0]-1,now[1]});
				visited[now[0]-1][now[1]] = visited[now[0]][now[1]]+1;
			}
		}
	}

}
