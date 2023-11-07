import java.io.*;
import java.util.*;

public class Main {
	static int days=0;
	static int unripe=0;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int M = Integer.parseInt(s[0]); // 가로 
		int N = Integer.parseInt(s[1]); // 세로 
		
		int[][] box = new int[N][M]; // 토마토가 들어있는 상자
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				box[i][j] = Integer.parseInt(s[j]);
				if(box[i][j]==0) unripe++;
			}
		}
		
		System.out.println(bfs(box,N,M));
	}
	static int bfs(int[][] box, int N, int M) {
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		boolean[][] visited = new boolean[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j]==1) q.add(new int[] {i,j,0});
			}
		}
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			days = Math.max(days, now[2]);
			
			visited[now[0]][now[1]] = true;
			
			for(int i=0;i<4;i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				// 다음 위치가 범위를 벗어나지 않고,
				// 방문하지 않았으며, 토마토가 익지 않았다면 
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && box[nx][ny]==0) {
					visited[nx][ny]=true;
					box[nx][ny]=1;
					unripe--;
					q.add(new int[] {nx,ny,now[2]+1});
				}
			}
		}
		
		if(unripe>0) return -1; // 안익은 토마토가 1개라도 남았으면 -1리턴.
		else return days;
	}
}