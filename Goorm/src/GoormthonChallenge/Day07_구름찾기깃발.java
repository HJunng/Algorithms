package GoormthonChallenge;

import java.io.*;

public class Day07_구름찾기깃발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[][] goorm = new int[n][n];
		for(int i=0;i<n;i++){
			input = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				goorm[i][j]=Integer.parseInt(input[j]);
			}
		}
		
		int[] dx={1,1,1,0,0,-1,-1,-1};//8방향
		int[] dy={1,0,-1,1,-1,1,0,-1};
		
		int answer=0;
		for(int x=0;x<n;x++){
			for(int y=0;y<n;y++){
				if(goorm[x][y]==0){
					int cnt=0;
					for(int dir=0;dir<8;dir++){
						int nx=x+dx[dir];
						int ny=y+dy[dir];
						
						if(nx>=0 && nx<n && ny>=0 && ny<n){
							cnt+=goorm[nx][ny];
						}
					}
					if(cnt==k) answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
