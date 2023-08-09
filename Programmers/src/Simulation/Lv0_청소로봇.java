package Simulation;

import java.util.*;

public class Lv0_청소로봇 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution("RRRDDDLU");
	}
	public static int[] solution(String moves) {
		
		int[] answer= {};
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		char[] dir = {'U','R','D','L'};
		
		int x=0, y=0;
		for(int i=0;i<moves.length();i++) {
			
			for(int k=0;k<4;k++) {
				if(moves.charAt(i)==dir[k]) {
					x+=dx[k];
					y+=dy[k];
				}
			}
		}
		answer = new int[] {x,y};
		
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}
