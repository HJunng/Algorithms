package GoormthonChallenge;

import java.io.*;
public class Day9_폭탄구현하기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);//땅 크기 n*n
		int k = Integer.parseInt(s[1]);//폭탄 개수
		
		char[][] ground = new char[n][n];//땅의 상태
		int[][] bomb = new int[n][n];//땅의 폭탄 값
		
		for(int i=0;i<n;i++){//땅 상태 저장
			s=br.readLine().split(" ");
			for(int j=0;j<n;j++){
				ground[i][j]=s[j].charAt(0);
			}
		}
		
		int[] dx = {1,-1,0,0};//상하좌우
		int[] dy = {0,0,1,-1};
		
		int max=0;
		for(int i=0;i<k;i++){
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0])-1;
			int y=Integer.parseInt(s[1])-1;
			
			if(ground[x][y]=='0') bomb[x][y]++;
			if(ground[x][y]=='@') bomb[x][y]+=2;
			if(bomb[x][y]>max) max=bomb[x][y];
			
			for(int dir=0;dir<4;dir++){
				int nx=x+dx[dir];//주위 좌표
				int ny=y+dy[dir];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && ground[nx][ny]!='#'){
					if(ground[nx][ny]=='0') bomb[nx][ny]++;
					if(ground[nx][ny]=='@') bomb[nx][ny]+=2;
					
					if(bomb[nx][ny]>max) max=bomb[nx][ny];
				}
			}
		}
		System.out.println(max);
	}
}
