package sweaAlgorithm;

import java.io.*;
import java.util.*;

public class No1_기념품수집 {

	static int[] dx= {0,1,0,-1};
	static int[] dy= {1, 0, -1, 0};
	static String visited[];
	static String[][] A;
	static int[][] B;
	static int R, C;
	static int v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[]= br.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);
		for(int k=0;k<T;k++) {
			str = br.readLine().split(" ");
			R = Integer.parseInt(str[0]);
			C = Integer.parseInt(str[1]);
			
			visited = new String[R*C];	//산 기념품
			A = new String[R][C];
			B = new int[R][C];
			for(int i=0;i<R;i++) {	//살 수 있는 기념품 개수 배열
				for(int j=0;j<C;j++) {
					B[i][j] = 1;
				}
			}
			
			for(int i=0;i<R;i++) {	//기념품 배열 
				str=br.readLine().split("");
				for(int j=0;j<C;j++) {
					A[i][j] = str[j];
				}
			}
			v=0;
			BFS(0,0);
			
			int max=0;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(B[i][j]>max) max=B[i][j];
				}
			}
			System.out.println("#"+(k+1)+" "+max);
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					System.out.print(B[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	private static void BFS(int a, int b) {	//이건 dfs로 푸는 듯...........
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {a,b});
		visited[v]=A[a][b];	//첫번째 노드만 가기
		v++;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			
			for(int i=0;i<4;i++) {	//상하좌우 탐색
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				if(x>=0 && y>=0 && x<R && y<C) {
					if(isPossible(x,y)) {
						visited[v]=A[x][y];
						//System.out.println("v= "+visited[v]);
						v++;
						B[x][y] = B[now[0]][now[1]]+1;	//탐색하면서 최대값도 같이 계산.
						queue.add(new int[] {x,y});
					}
				}
			}
		}
	}
	private static boolean isPossible(int x, int y) {
		String s = A[x][y];
		for(int i=0;i<R*C;i++) {
			if(visited[i]==null)break;
			if((visited[i]).charAt(0)==s.charAt(0)) {	//배열 비교 하지말고 제일 앞의 글자 charAt으로 비교하기!!
				return false;
			}
		}
		return true;
	}
}
