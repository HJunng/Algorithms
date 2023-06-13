package Silver3;

import java.util.*;
public class BJ15649_N과M1 {		//30min. 답.
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();	//정적타입으로 해줘야함.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		arr = new int[m];
		visit = new boolean[n];
		dfs(n, m, 0);
		
		System.out.println(sb);
	}
	private static void dfs(int n, int m, int depth) {//깊이 우선 탐색.
		if(depth==m) {//탐색해야 하는 깊이까지 탐색완료하면 배열 저장된 값 출력.
			for(int val:arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visit[i]) {//배열에 넣어져있는 앞의 수 건너뜀.
				visit[i]=true;
				arr[depth] = i+1;
				dfs(n,m,depth+1);//재귀로 다음 조합 수 확인.
				visit[i]=false;
			}
		}
	}
}