package GoormthonChallenge;

import java.io.*;
import java.util.*;

public class Dayy10_GameJam {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] goorm = new int[2];//goorm 좌표
		goorm[0]=Integer.parseInt(s[0])-1;//배열 좌표를 (0,0)부터 시작하도록 만들것이기 때문에 좌표에서 -1해준다.
		goorm[1]=Integer.parseInt(s[1])-1;
		
		s = br.readLine().split(" ");
		int[] player = new int[2];//player 좌표
		player[0]=Integer.parseInt(s[0])-1;
		player[1]=Integer.parseInt(s[1])-1;
			
		String[][] board = new String[n][n];//보드판 저장.
		for(int i=0;i<n;i++){
			s=br.readLine().split(" ");
			for(int j=0;j<n;j++){
				board[i][j]=s[j];
			}
		}
		int scoreG = score(goorm,board,n);
		int scoreP = score(player,board,n);
		
		if(scoreG>scoreP) System.out.println("goorm "+scoreG);
		else System.out.println("player "+scoreP);
		
	}
	// p: 시작위치, b: 보드판
	static public int score(int[] p, String[][] b, int n){
		
		//영어로된 방향을 dx,dy 방향으로 바꿔주는 지표
		Map<Character,Integer> direction = new HashMap<>(){{
			put('U',0); put('D',1); put('R',2); put('L',3);
		}};
		
		int[] dx={-1,1,0,0};// U D R L 순
		int[] dy={0,0,1,-1};
		
		boolean[][] visited = new boolean[n][n];//방문 확인
		
		int score=0;//점수
		int move=0;//움직일 거리
		int dir=0;//dx dy 방향
		while(!visited[p[0]][p[1]]){//방문한 적이 없을 때 진행
			
			visited[p[0]][p[1]]=true;//방문 처리
			score+=1;
			
			if(move==0){
				String now = b[p[0]][p[1]];
				move= Integer.parseInt(now.substring(0,now.length()-1));//맨 뒤 문자 빼고 자르기
				dir=direction.get(now.charAt(now.length()-1));//1번째 문자인 문자 받아오기
			}
			p[0]+=dx[dir];
			p[1]+=dy[dir];
			move--;
			
			p[0]=(p[0]>=0)?p[0]%n:p[0]+n;// 범위 벗어나면 반대쪽 첫번째로 이동
			p[1]=(p[1]>=0)?p[1]%n:p[1]+n;
		}
		
		return score;
	}
}
