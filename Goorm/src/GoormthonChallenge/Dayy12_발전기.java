package GoormthonChallenge;

import java.io.*;
import java.util.*;
public class Dayy12_발전기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s;
		
		int[][] house = new int[n][n];//입력받은 마을
		for(int i=0;i<n;i++){
			s = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				house[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		int answer=0;//발전기 개수
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(house[i][j]==1){ //집이 있고 방문한 적이 없는 집이면
					bfs(i,j,house,n);//dfs 탐색, 상하좌우로 연결된 집이 없을 때까지
					answer++;//발전기 추가
				}
			}
		}
		
		System.out.println(answer);//발전기 개수 출력
	}
	// (x,y)와 인접한 모든 집 탐색
	static void bfs(int x, int y, int[][] house, int n){
		int[] dx={1,-1,0,0};//방향
		int[] dy={0,0,1,-1};
		
		Queue<int[]> q = new LinkedList<>(); //큐 Queue
		q.add(new int[]{x,y});//현재 위치 추가
		
		while(!q.isEmpty()){
			int[] now = q.poll();//방문한 집 위치
			
			house[now[0]][now[1]]=2;//방문처리
			
			for(int i=0;i<4;i++){//상하좌우
				int nx=now[0]+dx[i];//now에 인접한 다음 위치
				int ny=now[1]+dy[i];
				
				//(nx,ny)가 마을 범위를 벗어나지 않고, 방문한 적이 없는 집이면
				if(nx>=0 && nx<n && ny>=0 && ny<n && house[nx][ny]==1){
					house[nx][ny]=2;//방문처리
					q.add(new int[]{nx,ny});//다음 위치를 queue에 추가.
				}
			}
		}
	}
}
