package Simulation;

import java.util.Arrays;

public class Lv0_청소로봇3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new int[][] {{0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}},10);
		solution(new int[][] {{0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0}},20);
		
	
	}
	public static int[] solution(int[][] board, int k) {
		int[] answer = {};
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int dir=0;
		int x=0,y=0;
		while(k-->0) {
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			
			if(nx<0 || nx>=board.length || ny<0 || ny>=board[0].length 
					|| board[nx][ny]==1) {
				dir=(dir+1)%4;
			}else {
				x=nx; y=ny;
			}
		}
		answer = new int[] {x,y};
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}
