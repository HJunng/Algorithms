package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA4615 {
	static int[][] board;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int x,y,col,xx,yy,cntW,cntB;
		int[] dx= { 1, 1,1, 0,0,-1,-1,-1};
		int[] dy= {-1, 0,1,-1,1,-1, 0, 1};
		for(int t=1;t<=tc;t++) {
			
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]); //보드 길이
			int M = Integer.parseInt(s[1]); //돌 놓는 횟수
			
			board = new int[N+1][N+1];
			
			//처음 시작상태
			board[N/2][N/2]=2;//백돌
			board[N/2+1][N/2+1]=2;
			board[N/2][N/2+1]=1;//흑돌
			board[N/2+1][N/2]=1;
			
			for(int i=0;i<M;i++) {
				s = br.readLine().split(" ");
				
				x=Integer.parseInt(s[0]);
				y=Integer.parseInt(s[1]);
				col=Integer.parseInt(s[2]);
				//돌 놓기
				board[x][y] = col;
				
				//뒤집을 돌 확인
				for(int j=0;j<8;j++) {
					//주위에 다른 색 돌이 있는지 확인
					if(x+dx[j]<N && y+dy[j]<N && 
							board[x+dx[j]][y+dy[j]]!=0 && board[x+dx[j]][y+dy[j]]!=col) {
						xx=x+dx[j];
						yy=y+dy[j];
						System.out.println("xy "+xx+" "+yy);
						
						boolean b = false;
						//같은 색 돌이 나올때까지 검사
						while(xx>0 && yy>0 && xx<N && yy<N 
								&& board[xx][yy]!=0) {
							if(board[xx][yy]==col) {
								b=true;
							}
							
							//무작정 바꾸면 2100 -> 2200됨.. 조심!
							//board[xx][yy]=col;
							xx+=dx[j];
							yy+=dy[j];
						}
						//돌 색 바꿈
						if(b) {
							xx=x+dx[j];
							yy=y+dy[j];
							//System.out.println(xx+" "+yy);
							
							while(board[xx][yy]!=col) {
								board[xx][yy]=col;
								
								xx+=dx[j];
								yy+=dy[j];
							}
						}
					}
				}
				for(int a=1;a<=N;a++) {
					for(int b=1;b<=N;b++) {
						System.out.print(board[a][b]);
					}
					System.out.println();
				}
			}
			cntW=0;
			cntB=0;
			for(int a=1;a<=N;a++) {
				for(int b=1;b<=N;b++) {
					if(board[a][b]==1)
						cntB++;
					else
						cntW++;
				}
			}
			System.out.println("#"+t+" "+cntB+" "+cntW);
		}
	}
}