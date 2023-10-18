import java.util.*;

public class Main {
	static int[]dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		int[] worth = new int[n];
		dp = new int[k+1];
		
		for(int i=0;i<n;i++) {
			worth[i]=s.nextInt();
			if(worth[i]<dp.length) dp[worth[i]]=1; // 동전 1개쓰는게 최소.
		}
		
		Arrays.sort(worth);
		
		int answer = findMinCnt(k,worth);
		if(answer==Integer.MAX_VALUE) answer=-1;
		
		System.out.println(answer);
	}
	static int findMinCnt(int k, int[] worth) {
		if(dp[k]>0) return dp[k];
		
		int minCnt=Integer.MAX_VALUE;
		
		for(int i=worth.length-1;i>=0;i--) {
			if(k-worth[i]<0) continue;
			
			int befCnt=findMinCnt(k-worth[i],worth);
			if(befCnt==Integer.MAX_VALUE) continue;
			
			minCnt = Math.min(minCnt, befCnt+1);
		}
		
		dp[k] = minCnt;
		return dp[k];
	}
}