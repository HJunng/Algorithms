package Gold4;

import java.io.*;
import java.util.*;

public class BJ14500_테트로미노 {
	static int n,m;
	static int[][] paper;
	static int max=0;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<s.length;j++)
				paper[i][j]=Integer.parseInt(s[j]);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visited[i][j]=true;
				dfs(i,j,1,paper[i][j]);
				visited[i][j]=false;
			}
		}
		findTable();
		
		System.out.println(max);
	}
	//****  **  ***  **   
	//      **    *   **  이 네가지 모양만 적용.
	static void dfs(int i,int j,int depth, int sum) {
		
		if(depth==4) {
			if(sum>max) max=sum;
			return;
		}
		//상하좌우 탐색
		for(int direction=0;direction<4;direction++) {
			
			int x=i+dx[direction];
			int y=j+dy[direction];
			
			if(x>=0 && x<n && y>=0 && y<m && !visited[x][y]) {
				visited[x][y]=true;
				dfs(x,y,depth+1,sum+paper[x][y]);
				visited[x][y]=false;
			}
		}
	}
	// ***
	//  *  모양 탐색
	static void findTable() {
		int sum=0;
		// ***
		//  *  6칸을 기준으로 제일 위 왼쪽이 (i,j)
		// ㅜ 모양
		for(int i=0;i+1<n;i++) {
			for(int j=0;j+2<m;j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1];
				if(sum>max) max=sum;
			}
		}
		// ㅏ 모양
		for(int i=0;i+2<n;i++) {
			for(int j=0;j+1<m;j++) {
				sum=paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+1][j+1];
				if(sum>max) max=sum;
			}
		}
		// ㅗ 모양
		for(int i=0;i+1<n;i++) {
			for(int j=0;j+2<m;j++) {
				sum=paper[i][j+1]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2];
				if(sum>max) max=sum;
			}
		}
		// ㅓ 모양
		for(int i=0;i+2<n;i++) {
			for(int j=0;j+1<m;j++) {
				sum=paper[i+1][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1];
				if(sum>max) max=sum;
			}
		}
	}
}