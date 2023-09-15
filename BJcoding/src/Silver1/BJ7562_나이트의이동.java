package Silver1;

import java.io.*;
import java.util.*;

public class BJ7562_나이트의이동 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); //테스트케이스 개수 
		
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
			
			String[] s = br.readLine().split(" ");
			int[] start = new int[2];
			start[0]=Integer.parseInt(s[0]);//출발지점 x좌표 
			start[1]=Integer.parseInt(s[1]);//출발지점 y좌표 
			
			s = br.readLine().split(" ");
			int[]end = new int[2];
			end[0]=Integer.parseInt(s[0]);//도착지점 x좌표 
			end[1]=Integer.parseInt(s[1]);//출발지점 y좌표 
			
			System.out.println(bfs(start,end,n));
		}
		
	}
	static int bfs(int[] start, int[] end, int n) {
		int[] dx = {-2,-2,-1,-1,1,1,2,2};
		int[] dy = {-1,1,2,-2,2,-2,1,-1};
		boolean[][] visited = new boolean[n][n];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start[0],start[1],0});
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			visited[now[0]][now[1]]=true; //방문처리
			
			if(now[0]==end[0] && now[1]==end[1]) return now[2]; //도착지점에 도착하면 몇 번 걸렸는지 봔환.
			
			for(int i=0;i<8;i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
					visited[nx][ny]=true;//방문처리 
					q.add(new int[] {nx,ny,now[2]+1}); //다음 좌표 방문 
				}
			}
		}
		
		return -1;
	}
}
