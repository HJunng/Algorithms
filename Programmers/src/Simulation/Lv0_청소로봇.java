package Simulation;

import java.util.*;

public class Lv0_청소로봇 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(5, "RRRDDDUUUUUUL");
		solution(7, "DDDRRRDDLL");
		solution(5, "RRRRRDDDDDU");
		solution(6, "RRRRDDDRDDLLUU");
	}
	public static int[] solution(int n, String moves) {
		
		int[] answer= {};
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		//char[] dir = {'U','R','D','L'};
		
		int x=0, y=0;
		Map<Character, Integer> dir = new HashMap<>() {{
			put('U',0); put('R',1); put('D',2); put('L',3);
		}};
		
		
		for(int i=0;i<moves.length();i++) {
			int nx = x+dx[dir.get(moves.charAt(i))];
			int ny = y+dy[dir.get(moves.charAt(i))];
			
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				x=nx; y=ny;
			}
			
//			for(int k=0;k<4;k++) {
//				if(moves.charAt(i)==dir[k]) {
//					x+=dx[k];
//					y+=dy[k];
//				}
//			}
		}
		answer = new int[] {x,y};
		
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}
