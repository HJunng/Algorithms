package Silver2;

import java.io.*;

public class BJ1012_유기농배추_2 {
	static int[][] field;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;
		while(tc-->0) {
			s = br.readLine().split(" ");
			int m = Integer.parseInt(s[0]);//가로길이
			int n = Integer.parseInt(s[1]);//세로길이
			int k = Integer.parseInt(s[2]);//배추 개수
			
			field = new int[m][n];
			
			for(int i=0;i<k;i++) {
				s = br.readLine().split(" ");
				
				field[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
			}
			
			int cnt=0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(field[i][j]==1) {
						cnt++;
						dfs(i,j,m,n);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static void dfs(int x, int y, int m, int n) {
		
		field[x][y]=-1;//방문처리
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<m && ny>=0 && ny<n && field[nx][ny]==1) {
				dfs(nx,ny,m,n);
			}
		}
	}

}
