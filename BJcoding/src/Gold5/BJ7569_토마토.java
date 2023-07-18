package Gold5;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class BJ7569_토마토 {
	static int m,n,h;
	static int unripe=0;//덜 익은 토마토 개수
	static int[][][] tomato;//토마토 상태 저장
	static int[] dx= {1,-1,0,0,0,0};
	static int[] dy= {0,0,1,-1,0,0};
	static int[] dz= {0,0,0,0,1,-1};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int[] s = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		 
		 m=s[0];//가로
		 n=s[1];//세로
		 h=s[2];//높이
		 
		 tomato=new int[m][n][h];
		 
		 for(int i=0;i<h;i++) {//처음 상태
			 for(int j=0;j<n;j++) {
				 s = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				 for(int k=0;k<m;k++) {
					 tomato[k][j][i]=s[k];
					 if(tomato[k][j][i]==0) unripe++;
				 }
			 }
		 }
		 
		 System.out.println("unripe: "+unripe);
		 
		 if(unripe==0) {//저장될 때부터 모두 익어있는 경우
			 System.out.println(0);
			 System.exit(0);
		 }
		 int days=0; //모두 익는데 며칠 걸리는지
		 int beforeUnripe=0;//이전에 덜익은 토마토 개수
		 Set<int[]> set = new HashSet<>();//덜익은 토마토 좌표 담기
		 
		 //덜익은 토마토가 없거나
		 //이전의 안익은 토마토 개수와 현재의 안익은 토마토 개수가 같으면 변화가 없으므로 종료.(더이상 해도 안바뀜.)
		 while(unripe>0 && beforeUnripe!=unripe) {
			 days++;
			 beforeUnripe=unripe;//현재 덜익은 토마토 개수 저장
			 
			 for(int i=0;i<m;i++) {//모든 칸을 돌면서 인접한 덜익은 토마토 익게 만듦.
				 for(int j=0;j<n;j++) {
					 for(int k=0;k<h;k++) {
						 if(tomato[i][j][k]!=1) continue; //익은 토마토 주위만 검사.
						 
						 for(int dir=0;dir<6;dir++) {
							 if(i+dx[dir]>=0 && j+dy[dir]>=0 && k+dz[dir]>=0 
									 && i+dx[dir]<m && j+dy[dir]<n && k+dz[dir]<h 
									 && tomato[i+dx[dir]][j+dy[dir]][k+dz[dir]]==0){
								 
								 set.add(new int[] {i+dx[dir],j+dy[dir],k+dz[dir]});//덜익은 토마토 좌표 넣기.
							 }
						 }
					 }
				 }
			 }
			 for(int[] a: set) {
				 if(tomato[a[0]][a[1]][a[2]]==0) {
					 unripe--;
					 tomato[a[0]][a[1]][a[2]]=1;//안익은 토마토 익힘.
				 }
			 }
			 System.out.println("unripe: "+unripe);
		 }
		 if(unripe==0) System.out.println(days);
		 else System.out.println(-1);
		 
		 
	}

}
