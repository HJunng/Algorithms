import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int cnt;
	static int maxWidth;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 가로 크기
		m = Integer.parseInt(st.nextToken()); // 세로 크기

		map = new int[n][m];
		visited = new boolean[n][m];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		maxWidth = 0;

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					maxWidth = Math.max(maxWidth, bfs(i,j));
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(maxWidth);
	}
	static int bfs(int x, int y){
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};

		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		int size = 0;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			size++;

			for(int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if(inRange(nx,ny) && map[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[]{nx,ny});
				}
			}
		}
		return size;
	}
	static boolean inRange(int x, int y){
		return x>=0 && x<n && y>=0 && y<m;
	}
}