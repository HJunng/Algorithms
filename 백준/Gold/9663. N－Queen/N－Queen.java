import java.util.Scanner;
public class Main {
	public static boolean visit[];	//해당 열에 방문 했는지.
	public static int visitBox[];
	public static int result=0;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		visit = new boolean[n];	//false로 초기화.
		visitBox = new int[n];
		
		dfs(n,0,-2);
		System.out.println(result);
	}
	private static void dfs(int n, int depth, int before) {
		if(depth==n) {//n개의 퀸을 놨다면
			result++;
			/*
			for(int i:visitBox)
				System.out.print(i+" ");
			System.out.println();
			*/
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visit[i] && possible(depth,i)) {
				visitBox[depth] =i;
				visit[i]=true;
				dfs(n,depth+1,i);
				visit[i]=false;
			}
		}
	}
	private static boolean possible(int x, int y) {

		boolean out = true;
		for(int i=0;i<x;i++) {
			int a = Math.abs(i-x);
			int b = Math.abs(visitBox[i]-y);
			
			if(a==b)//대각선에 queen이 존재하면.
				return false;
		}	
		return out;
	}
}