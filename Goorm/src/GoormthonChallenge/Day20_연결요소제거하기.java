package GoormthonChallenge;

import java.util.*;
import java.io.*;
public class Day20_연결요소제거하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); //배열의 크기
		int K = Integer.parseInt(input[1]); //연결 요소를 지울 기준
		int Q = Integer.parseInt(input[2]); //구름이가 문자을 적을 횟수
		
		char[][] arr = new char[N][N];
		
		for(int i=0;i<N;i++){
			input = br.readLine().split("");
			for(int j=0;j<N;j++){
				arr[i][j]=input[j].charAt(0);
			}
		}
		
		for(int i=0;i<Q;i++){
			input = br.readLine().split(" ");
			
			int y = Integer.parseInt(input[0])-1;//행
			int x = Integer.parseInt(input[1])-1;//열
			
			arr[y][x]=input[2].charAt(0); //(y,x)에 알파벳을 넣음.
			
			arr = bfs(y,x,arr,K,N);
			
		}
		
		printArr(N,arr);
	}
	static void printArr(int N, char[][] arr){
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static char[][] bfs(int y, int x, char[][] arr, int K, int N){
		boolean[][] visited = new boolean[N][N];
		int[] dx = {1,-1,0,0};
		int[] dy={0,0,1,-1};
		
		char[][] temp = new char[N][N];
		for(int i=0;i<N;i++) temp[i]=arr[i].clone();
		
		char alpha = temp[y][x];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y,x});
		int cnt=1;
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			visited[now[0]][now[1]]=true;
			temp[now[0]][now[1]]='.';
			
			
			for(int i=0;i<4;i++){
				int nextY = now[0]+dy[i];
				int nextX = now[1]+dx[i];
				
				if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && !visited[nextY][nextX] && temp[nextY][nextX]==alpha){
					visited[nextY][nextX]=true;
					cnt++;
					q.add(new int[]{nextY,nextX});
				}
			}
		}
		if(cnt>=K) return temp;
		else return arr;
	}

}
