package Silver3;

import java.util.Scanner;
public class BJ15650_N과M2 {	//23min.
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	public static boolean visit[];
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		arr = new int[m];
		visit = new boolean[n];
		
		dfs(n,m,0,-1);
		
		System.out.println(sb);
	}
	private static void dfs(int n, int m, int depth,int before) {
		if(m==depth) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=before+1;i<n;i++) {	//이전에 탐색했던 노드부터 탐색 시작.
			arr[depth]=i+1;
			dfs(n,m,depth+1,i); //이전까지 탐색했던 노드 위치 같이 보냄.
		}
	}
}
