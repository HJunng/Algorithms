package Silver3;

import java.util.Scanner;
public class BJ15651_N과M3 {		//5min.
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		arr = new int[m];
		
		dfs(n,m,0);
		
		System.out.println(sb);
	}
	private static void dfs(int n, int m, int depth) {
		if(depth==m) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {//중복 허용이므로 visit 확인 하지 않아도 됨.ㄴ
			arr[depth]=i+1;
			dfs(n,m,depth+1);
		}
	}
}