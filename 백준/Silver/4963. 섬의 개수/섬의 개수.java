import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static Map<Integer,ArrayList<Integer>> graph;
	static int[][] map;
	static int h,w;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s;
		while(true) {
			
			s = br.readLine().split(" ");
			
			w = Integer.parseInt(s[0]); // 너비 
			h = Integer.parseInt(s[1]); // 높이 
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			
			for(int i=0;i<h;i++) {
				s = br.readLine().split(" ");
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			visited = new boolean[h][w];
			
			int cnt=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j] && map[i][j]==1) {
						visited[i][j]=true;
						cnt++;
						bfs(i,j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	static void bfs(int startX, int startY) {
		int[] dx = {1,1,1,0,0,-1,-1,-1};
		int[] dy = {1,0,-1,1,-1,1,0,-1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startX,startY});
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			
			for(int i=0;i<8;i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx>=0 && nx<h && ny>=0 && ny<w && !visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
}