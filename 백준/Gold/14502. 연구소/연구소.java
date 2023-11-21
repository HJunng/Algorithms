import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N,M;
	static ArrayList<int[]> blanks = new ArrayList<>();
	static int maxBlanks=0;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]); // 세로 길이
		M = Integer.parseInt(s[1]); // 가로 길이
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j]==0) blanks.add(new int[] {i,j});
			}
		}
		
		setPartition();
		
		System.out.println(maxBlanks);
	}
	static void setPartition() {
		for(int[] a : blanks) {
			map[a[0]][a[1]]=1; // 벽 세우기 1
			
			for(int[] b : blanks) {
				if(map[b[0]][b[1]]==0) {
					map[b[0]][b[1]]=1; // 벽 세우기 2 
					
					for(int[] c : blanks) {
						if(map[c[0]][c[1]]==0) {
							map[c[0]][c[1]]=1; // 벽 세우기 3
							
							maxBlanks = Math.max(maxBlanks, cntBlanks());
							
							map[c[0]][c[1]]=0;
						}
					}
					map[b[0]][b[1]]=0;
				}
			}
			map[a[0]][a[1]]=0;
		}
	}
	static int cntBlanks() {
		Queue<int[]> q = new LinkedList<>();
		
		int[][] tempMap = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tempMap[i][j] = map[i][j];
				if(tempMap[i][j]==2) q.add(new int[] {i,j});
			}
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && tempMap[nx][ny]==0) {
					tempMap[nx][ny]=2;
					q.add(new int[] {nx,ny});
				}
			}
		}
		
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tempMap[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
}