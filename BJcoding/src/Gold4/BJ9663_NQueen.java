package Gold4;

import java.util.Scanner;
public class BJ9663_NQueen {	//90min.
	public static boolean visit[];	//해당 열에 방문 했는지.
	public static int visitBox[];	//각 행의 몇번째 열에 queen이 있는지 저장.
	public static int result=0;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		visit = new boolean[n];	//false로 초기화.
		visitBox = new int[n];
		
		dfs(n,0);
		System.out.println(result);
	}
	private static void dfs(int n, int depth) {	
		if(depth==n) {//n개의 퀸을 놨다면
			result++;
			/* 각 행마다 몇번째에 queen이 존재하는지 출력 
			for(int i:visitBox)
				System.out.print(i+" ");
			System.out.println();
			*/
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visit[i] && possible(depth,i)) {// i열에 queen을 놓은적이 없고, 대각선에도 queen이 없다면
				visitBox[depth] =i;	//depth=행, i=열
				visit[i]=true;		//depth행 i열에 queen을 놓음.
				dfs(n,depth+1);		//다음 행 시작
				visit[i]=false;
			}
		}
	}
	private static boolean possible(int x, int y) {
		for(int i=0;i<x;i++) {
			int a = Math.abs(i-x);
			int b = Math.abs(visitBox[i]-y);
			
			if(a==b)	//대각선에 queen이 존재하면.
				return false;
		}	
		return true;
	}
}