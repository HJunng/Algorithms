package Silver3;

import java.util.Scanner;
public class BJ15649_N과M1_2 {	//20min.
	public static int arr[];
	public static boolean visit[];	//중복 없어야 하므로 visit 필요.
	public static int result[];
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m= s.nextInt();
		
		arr = new int[n+1];
		visit = new boolean[n+1];
		result = new int[m];
		
		dp(m,0);
	}
	private static void dp(int m, int depth) {
		if(m==depth) {
			for(int i=0;i<m;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<arr.length;i++) {
			if(!visit[i]) {
				result[depth]=i;
				visit[i]=true;
				dp(m,depth+1);
				visit[i]=false;
			}
		}
	}
}