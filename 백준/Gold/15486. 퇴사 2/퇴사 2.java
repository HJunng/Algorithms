import java.io.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] consult = new int[N][2];
		
		String[] s;
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			consult[i][0]=Integer.parseInt(s[0]); // 상담 기간 
			consult[i][1]=Integer.parseInt(s[1]); // 받는 금액 
		}
		
		dp = new int[N+1];
		
		for(int i=N-1;i>=0;i--) findDP(i,N,consult);
		
		System.out.println(dp[0]);
	}
	static int findDP(int now, int N, int[][] consult) {
		if(now>=N) return 0;
		if(dp[now]>0) return dp[now];
		
		// 1. 현재 상담을 선택하고, 상담기간 만큼동안 상담 안받기
		// 2. 현재 상담 안받고, 다음상담으로 넘기기.
		
		if(now+consult[now][0]<=consult.length) { // 현재 상담을 받을 수 있는 경우 
			dp[now] = Math.max(consult[now][1] + findDP(now+consult[now][0],N,consult),
					findDP(now+1,N,consult));
		}else {
			dp[now] = findDP(now+1,N,consult);
		}
		
		
		return dp[now];
	}
}