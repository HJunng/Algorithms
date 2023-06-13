package D2;

import java.io.*;

public class SWEA1961_숫자배열회전 {
	static int[][] num;
	static int N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;
		
		for(int t=1;t<=tc;t++) {
			sb.append("#"+t+"\n");
			
			N = Integer.parseInt(br.readLine());
			
			num = new int[N][N];
			for(int i=0;i<N;i++) {
				s = br.readLine().split(" ");
				
				for(int j=0;j<N;j++) {
					num[i][j]=Integer.parseInt(s[j]);
				}
			}
			//rotate한 거 출력
			for(int i=0;i<N;i++) {
				//90도 회전
				for(int j=0;j<N;j++) {
					sb.append(rotate(90,i,j));
				}
				sb.append(" ");
				//180도 회전
				for(int j=0;j<N;j++) {
					sb.append(rotate(180,i,j));
				}
				sb.append(" ");
				//270도 회전
				for(int j=0;j<N;j++) {
					sb.append(rotate(270,i,j));
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	public static int rotate(int angle, int i, int j) {
		
		if(angle==90) {
			//시작 정점
			int startI=N-1;
			int startJ=0;
			//90도 회전한 (i,j) 숫자
			return num[startI-j][startJ+i];
			
		}else if(angle==180) {
			int startI=N-1;
			int startJ=N-1;
			
			return num[startI-i][startJ-j];
		}else {
			int startI=0;
			int startJ=N-1;
			
			return num[startI+j][startJ-i];
		}
	}
}
