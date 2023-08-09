package Simulation;

import java.util.Arrays;

public class Lv0_로봇의이동 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution("GGGRGGG");
		solution("GGRGGG");
		solution("GGGGGGGRGGGRGGRGGGLGGG");
		solution("GGLLLGLGGG");
		
	}
	public static int[] solution(String moves) {
		int[] answer= {};
		
		int[] dx= {0,1,0,-1};//3시,6시,9시,12시 방향
		int[] dy= {1,0,-1,0};
		int d=0;
		
		int x=0,y=0;
		for(int i=0;i<moves.length();i++) {
			if(moves.charAt(i)=='G') {
				x+=dx[d];y+=dy[d];
			}else if(moves.charAt(i)=='R') {
				d=(d+1)%4;
			}else if(moves.charAt(i)=='L') {
				d=(d+3)%4;
			}
		}
		answer = new int[] {x,y};
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
