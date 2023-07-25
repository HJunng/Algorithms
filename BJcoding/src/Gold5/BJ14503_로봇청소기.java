package Gold5;

import java.io.*;

public class BJ14503_로봇청소기 {
	static int[] dx = {-1,0,1,0};//위부터 시계 방향 90 회전
	static int[] dy = {0,1,0,-1};//북,동,남,서
	static int answer=0;
	static int n,m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		
		int x = Integer.parseInt(s[0]);//시작점
		int y = Integer.parseInt(s[1]);
		int dir = Integer.parseInt(s[2]);//방향
		
		int[][] room = new int[n][m]; //현재 방 상태
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<m;j++) room[i][j]=Integer.parseInt(s[j]);
		}
		
		dfs(room,x,y,dir);
		
		System.out.println(answer);
	}
	static void dfs(int[][] room,int x, int y, int dir) {
		
		//System.out.println(x+","+y);
		if(room[x][y]==0) {
			answer++;
			room[x][y]=-1;
		}
		//주변 4칸 중 청소되지 않은 빈칸이 있는 경우
		for(int i=1;i<=4;i++) {
			dir=(dir+3)%4;//90도 반시계 회전
			if(x+dx[dir]>=0 && x+dx[dir]<n && y+dy[dir]>=0 && y+dy[dir]<m 
					&& room[x+dx[dir]][y+dy[dir]]==0) {
				dfs(room,x+dx[dir],y+dy[dir],dir);return;
			}
		}
		
		//주변 4칸 중 청소되지 않은 빈칸이 있는 경우
		//후진할 수 있으면 후진
		if(x-dx[dir]>=0 && x-dx[dir]<n && y-dy[dir]>=0 && y-dy[dir]<m 
				&& room[x-dx[dir]][y-dy[dir]]!=1)
			dfs(room,x-dx[dir],y-dy[dir],dir);
	}
}
