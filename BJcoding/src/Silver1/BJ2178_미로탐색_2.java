package Silver1;

import java.io.*;
import java.util.*;

public class BJ2178_미로탐색_2 {
	static int[][] maze;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	static int n, m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		maze = new int[n][m];// 미로 등록

		for (int i = 0; i < n; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < m; j++)
				maze[i][j] = Integer.parseInt(s[j]);
		}

		bfs();

		System.out.println(maze[n - 1][m - 1] - 1); // 2부터 시작해서 1빼줘야 함.
	}

	static void bfs() {

		Queue<int[]> q = new LinkedList<>();// x,y,cnt
		q.add(new int[] { 0, 0, 2 });// (0,0)방문처리를 위해 2부터 시작
		maze[0][0] = 2;// bfs 방문처리는 queue에서 뺄 때가 아니라 넣을때!!!
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int dir=0;dir<4;dir++) { 
				if(now[0]+dx[dir]>=0 && now[0]+dx[dir]<n && now[1]+dy[dir]>=0 && now[1]+dy[dir]<m &&
						 maze[now[0]+dx[dir]][now[1]+dy[dir]]==1) {
					maze[now[0]+dx[dir]][now[1]+dy[dir]]=now[2]+1;
					q.add(new int[] {now[0]+dx[dir],now[1]+dy[dir],now[2]+1}); 
				} 
			}
			 
		}

	}
}
