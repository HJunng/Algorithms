import java.io.*;
import java.util.*;

public class Solution {

	static char[][] map;
	static int R,C;
	static boolean isStop;
	static boolean[][][][] visited;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visited = new boolean[R][C][4][16];
			
			for (int i=0; i<R; i++) {
				String s = br.readLine();
				for (int j=0; j<C; j++) {
					map[i][j] = s.charAt(j);
				}
			} //입력 끝
			
			isStop=false;
			bfs();
			if (isStop==false) System.out.println("#"+tc+" "+"NO");
			else System.out.println("#"+tc+" "+"YES");
		}
	}
	
	static void bfs() {
		Queue<Pos> queue = new ArrayDeque<> ();
		if (map[0][0] >= '0' && map[0][0] <= '9') {
			queue.offer(new Pos(0,0,3,map[0][0]-'0'));
		}
		else queue.offer(new Pos(0,0,3,0));
		
		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			int y = cur.y;
			int x = cur.x;
			int d = cur.d;
			int mem = cur.mem;
			if (map[y][x]=='@') {
				isStop = true;
				return;
			}

			if (map[y][x] >= '0' && map[y][x] <= '9') {
				mem = map[y][x]-'0';
			}
			
			if (visited[y][x][d][mem] == true) continue; //return으로 다른 방향은 못보고 바로끝내버려서 틀림
			visited[y][x][d][mem] = true;
			
			if (map[y][x]=='?') {
				for (int rand=0; rand<4; rand++) {
					int ny = y+dy[rand];
					int nx = x+dx[rand];
					if (ny<0) ny=R-1;
					else if (ny>=R) ny=0;
					else if (nx<0) nx=C-1;
					else if (nx>=C) nx=0;
					queue.offer(new Pos(ny, nx, rand, mem));
				}
			}
			else {
				
				if (map[y][x]=='^') d=0;
				else if (map[y][x]=='v') d=1;
				else if (map[y][x]=='<') d=2;
				else if (map[y][x]=='>') d=3;

				else if (map[y][x]=='_') {
					if (mem==0) d=3;
					else d=2;
				}
				else if (map[y][x]=='|') {
					if (mem==0) d=1;
					else d=0;
				}
				else if (map[y][x]=='@') {
					isStop = true;
					return;
				}
				else if (map[y][x]=='+') {
					if (mem==15) mem=0;
					else mem++;
				}
				else if (map[y][x]=='-') {
					if (mem==0) mem=15;
					else mem--;
				}
				
				int ny = y+dy[d];
				int nx = x+dx[d];
				if (ny<0) ny=R-1;
				else if (ny>=R) ny=0;
				else if (nx<0) nx=C-1;
				else if (nx>=C) nx=0;
				queue.offer(new Pos(ny, nx, d, mem));
			}
		}
	}

	static class Pos {
		int y, x, d, mem; //?방향마다 mem값이 바뀔 수 있으므로 전역으로 하면 안되고 들고다녀야 함
		Pos(int y, int x, int d, int mem) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.mem = mem;
		}
	}
}