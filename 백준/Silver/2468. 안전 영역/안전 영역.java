import java.io.*;

public class Main {
	static int[][] map; // 지역의 높이 정보 
	static int N; // 지역의 가로, 세로 길이 
	static int max=1; // 안전한 영역의 최대 개수 
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int maxHeight=0;
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(s[j]);
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		for(int i=1;i<=maxHeight;i++) {
			visited = new boolean[N][N];
			max = Math.max(max, divideRain(i));
		}
		
		System.out.println(max);
	}
	static int divideRain(int rain) {
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>rain && !visited[i][j]) {
					cnt++;
					dfs(i,j,rain);
				}
			}
		}
		
		return cnt;
	}
	static void dfs(int x, int y, int rain) {
		
		visited[x][y]=true;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]>rain && !visited[nx][ny]) {
				dfs(nx,ny,rain);
			}
		}
	}
}