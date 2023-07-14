package Silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BJ2667_단지번호붙이기_2 {
	static int[][] arr;
	static int[] dx= {1,-1,0,0};//상하좌우 이동
	static int[] dy= {0,0,-1,1};
	static int cnt,n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		String[] s;
		for(int i=0;i<n;i++) {
			s = br.readLine().split("");
			for(int j=0;j<n;j++)
				arr[i][j]=Integer.parseInt(s[j]);
		}
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {//1을 만날때 dfs검사
					cnt=0;
					dfs(i,j);
					answer.add(cnt);
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i=0;i<answer.size();i++) System.out.println(answer.get(i));
	}
	static void dfs(int x, int y) {
		
		cnt++;
		arr[x][y]=2;//방문처리
		
		for(int i=0;i<4;i++) {
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n
					&& arr[x+dx[i]][y+dy[i]]==1) {
				dfs(x+dx[i],y+dy[i]);
			}
		}
	}
}
