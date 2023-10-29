import java.io.*;
import java.util.*;

public class Main {
	static class Position implements Comparable<Position>{
		int height;
		int x;
		int y;
		public Position(int height, int x, int y) {
			this.height = height;
			this.x = x;
			this.y = y;
		}
		public int compareTo(Position p) {
			return p.height-this.height;
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int M = Integer.parseInt(s[0]); // 세로
		int N = Integer.parseInt(s[1]); // 가로
		
		int[][] arr = new int[M][N];
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[][] dp = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		
		PriorityQueue<Position> pq = new PriorityQueue<>();
		pq.add(new Position(arr[0][0],0,0));
		dp[0][0]=1;
		visited[0][0]=true;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!pq.isEmpty()) {
			Position now = pq.poll();
			//System.out.println(now.x+" "+now.y+" "+dp[now.x][now.y]);
			
			for(int i=0;i<4;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				
				if(nx>=0 && nx<M && ny>=0 && ny<N && arr[now.x][now.y]>arr[nx][ny]) {
					dp[nx][ny]+=dp[now.x][now.y];
					if(!visited[nx][ny]) pq.add(new Position(arr[nx][ny],nx,ny));
					visited[nx][ny]=true;
				}
			}
		}
		
		System.out.println(dp[M-1][N-1]);
		
	}
}