package sweaAlgorithm;

import java.io.*;
import java.util.*;

public class No1_기념품수집dfs {
	static Stack<String> stack;	//stack 사용해서 방문 기록.
	static String[][] A;
	static int R, C;
	static int max;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[]= br.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);
		for(int k=1;k<=T;k++) {
			str = br.readLine().split(" ");
			R = Integer.parseInt(str[0]);
			C = Integer.parseInt(str[1]);
			
			A = new String[R][C];
			for(int i=0;i<R;i++) {	//기념품 배열 
				str=br.readLine().split("");
				for(int j=0;j<C;j++) {
					A[i][j] = str[j];
				}
			}
			max=0;
			stack = new Stack<>();
			DFS(0,0);
			System.out.println("#"+k+" "+max);
		}
	}

	private static void DFS(int a, int b) {		//재귀함수
		stack.push(A[a][b]);//방문한 노드 값 넣기
		
		//1. 수행 동작
		int temp=0;
		if(b<C-1 && stack.search(A[a][b+1])<0) {	//b의 위치가 끝이 아니고 b+1의 값이 stack에 존재 하지 않으면 탐색.오른쪽탐색
			temp++;
			DFS(a, b+1);
		}
		if(a<R-1 && stack.search(A[a+1][b])<0) {	//a의 위치가 끝이 아니고 a+1의 값이 stack에 존재 하지 않으면 탐색. 왼쪽탐색
			temp++;
			DFS(a+1,b);			
		}
		if(b>0 && stack.search(A[a][b-1])<0) {		//왼쪽탐색.
			temp++;
			DFS(a,b-1);	
		}
		if(a>0 && stack.search(A[a-1][b])<0) {		//위쪽탐색.
			temp++;
			DFS(a-1,b);	
		}
		//2. 탈출 조건
		if(temp==0) {	//상하좌우 갈 곳이 없으면 
			if(stack.size()>max) {
				max=stack.size();
				//System.out.println(stack.toString());
			}
		}
		stack.pop();
	}
}
