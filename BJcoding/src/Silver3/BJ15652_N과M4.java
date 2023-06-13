package Silver3;

import java.util.Scanner;
public class BJ15652_N과M4 {		//5min.
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		arr = new int[m];
		
		dfs(n,m,0,1);
		System.out.println(sb);
	}
	private static void dfs(int n, int m, int depth, int before) {
		if(m==depth) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=before; i<=n;i++) {
			arr[depth] = i;
			dfs(n,m,depth+1,i);
		}
	}
}