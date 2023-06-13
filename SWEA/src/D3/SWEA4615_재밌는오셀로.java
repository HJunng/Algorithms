package D3;

import java.io.*;
import java.util.*;
public class SWEA4615_재밌는오셀로 {
	static int[][] board;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
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
				
				//System.out.println(Integer.parseInt(s[0])+" "+Integer.parseInt(s[1])+" "+Integer.parseInt(s[2]));
				//뒤집을 것이 있는 지
				reverse(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			}
			int cntB=0;
			int cntW=0;
			for(int i=1;i<N;i++) {
				for(int j=1;j<N;j++) {
					if(board[i][j]==1)
						cntB++;
					else if(board[i][j]==2)
						cntW++;
				}
			}
			
			System.out.println("#"+t+" "+cntB+" "+cntW+"\n");
		}
	}

	private static void reverse(int i, int j, int color) {
		
		Queue<int[]> reColor = new LinkedList<>();
		board[i][j]=color;
		
		int start=0;
		//위
		if(board[i-1][j]!=0) {//바로 위에 돌이 있다면 검사함.
			//color돌 첫 위치 확인
			for(int x=1;x<i;x++) {
				if(board[x][j]==color) {
					start = x;
					break;
				}
			}
			//색깔 바꾸기
			for(int x=start+1;x<i;x++)
				board[x][j]=color;
		}
		//오른쪽 위
		if(board[i-1][j+1]!=0) {
			int x=i-1;
			int y=j+1;
			int startX=i;
			int startY=j;
			while(x-->0 && y++<board.length) {
				if(board[x][y]==color) {
					startX=x;
					startY=y;
				}
			}
			while(startX++<i && startY-->j)
				board[startX][startY]=color;
		}
		//오른쪽
		if(board[i][j+1]!=0) {
			
			for(int n=board.length-1;n>j;j--) {
				if(board[i][n]==color) {
					start = n;
					break;
				}
			}
			for(int n=start;n>j;n--)
				board[i][n]=color;
		}
		//오른쪽 아래
		if(board[i+1][j+1]!=0) {
			int x=i+1;
			int y=j+1;
			int startX=i;
			int startY=j;
			while(x<board.length && y<board.length) {
				if(board[x][y]==color) {
					startX=x;
					startY=y;
				}
				x++;y++;
			}
			while(startX-->i && startY-->j) {
				board[startX][startY]=color;
			}
		}
		//아래
		if(board[i+1][j]!=0) {
			
			for(int n=board.length-1;n>i;n--) {
				if(board[n][j]==color) {
					start=n;
					break;
				}
			}
			//색깔 바꾸기
			for(int n=i+1;n<=start;n++)
				board[n][j]=color;
		}
		//왼쪽 아래
		if(board[i+1][j-1]!=0) {
			int x=i+1;
			int y=j-1;
			int startX=i;
			int startY=j;
			while(x++<board.length && y-->0) {
				if(board[x][y]==color) {
					startX=x;
					startY=y;
				}
			}
			while(startX-->i && startY++<j)
				board[startX][startY]=color;
		}
		//왼쪽
		if(board[i][j-1]!=0) {
			for(int n=1;n<j;n++) {
				if(board[i][n]==color) {
					start=n;
					break;
				}
			}
			for(int n=start;n<j;n++)
				board[i][n]=color;
		}
		//왼쪽 위
		if(board[i-1][j-1]!=0) {
			int x=i-1;
			int y=j-1;
			int startX=i;
			int startY=j;
			while(x-->0 && y-->0) {
				if(board[x][y]==color) {
					startX=x;
					startY=y;
				}
			}
			while(startX++<i && startY++<j)
				board[startX][startY]=color;
		}
	}
}
