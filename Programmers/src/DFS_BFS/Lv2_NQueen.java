package DFS_BFS;

import java.io.*;
import java.util.*;
public class Lv2_NQueen {
	static boolean[][] board;
	static boolean[] colVisit;
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int n) {
        int answer = 0;
        
        board = new boolean[n][n];//보드판에 queen이 어디있는지 저장.
        colVisit = new boolean[n];//해당 열에 queen이 있는지 확인.
        dfs(0,n);
        
        return cnt;
    }
    // row행에서의 탐색
    void dfs(int row, int n){
        
        if(row==n){//n개의 queen을 다 놓았으면 cnt+1해주고 종료.
            cnt++;return;
        }
        //0~i-1열까지 중에 queen 놓을 수 있는 자리 찾음.
        for(int i=0;i<n;i++){
            if(colVisit[i]) continue;//이미 i열에 queen이 있으면 패스.
            
            boolean b=false;//초기화
            //왼쪽 위 대각선에 queen 있는지 확인
            for(int j=1;row-j>=0 && i-j>=0;j++){
                if(board[row-j][i-j]){
                    b=true;break;
                }
            }
            if(b) continue;
            //오른쪽 위 대각선에 queen 있는지 확인
            for(int j=1;row-j>=0 && i+j<n;j++){
                if(board[row-j][i+j]){
                    b=true;break;
                }
            }
            if(b) continue;
            
            //대각선에 queen이 없는 경우 dfs 계속 탐색.
            colVisit[i]=true;//해당 열 방문처리
            board[row][i]=true;//queen 배치
            dfs(row+1,n);//다음 행 dfs 탐색.
            board[row][i]=false;//방문처리 해제.
            colVisit[i]=false;
        }
    }
}
