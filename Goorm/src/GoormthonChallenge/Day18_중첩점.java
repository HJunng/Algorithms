package GoormthonChallenge;

import java.io.*;
public class Day18_중첩점 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);//정사각형 길이
		int m = Integer.parseInt(s[1]);//반직선 개수
		
		long[][][] square = new long[n][n][2];// n*n 정사각형 0: 가로선, 1: 세로선
		for(int i=0;i<m;i++){//정사각형에 있는 선 그리기
			s = br.readLine().split(" ");
			
			int y=Integer.parseInt(s[0])-1;
			int x=Integer.parseInt(s[1])-1;
			
			square = drawLine(y,x,s[2],n,square);
		}
		long answer=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				answer+=square[j][i][0]*square[j][i][1];//(j,i)칸에서 가로선, 세로선 몇 번 만나는지 세기.
			}
		}
		System.out.println(answer);
		
	}
	static long[][][] drawLine(int y, int x, String dir, int n, long[][][] square){
		
		int[] dx={1,-1,0,0};
		int[] dy={0,0,1,-1};
		
		int d=-1;
		if(dir.equals("U")) d=3;
		else if(dir.equals("D")) d=2;
		else if(dir.equals("L")) d=1;
		else d=0;
		
		while(x>=0 && x<n && y>=0 && y<n){//정사각형 범위 안에 있을 때까지 라인 그리기
			if(d==0 || d==1){//가로선
				square[y][x][0]+=1;//(y,x)칸에 가로선 추가
			}else{
				square[y][x][1]+=1;
			}
			x+=dx[d];
			y+=dy[d];
		}
		
		return square;
	}

}
