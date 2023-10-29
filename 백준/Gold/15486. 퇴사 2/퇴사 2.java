import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		int[][] consult = new int[N][2];
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			consult[i][0] = Integer.parseInt(s[0]); // 상담기간 
			consult[i][1] = Integer.parseInt(s[1]); // 이익 
		}
		
		int[] dp = new int[N];
		for(int i=N-1;i>=0;i--) {
			int next = i+consult[i][0];
			if(next<=N) {
				int nextDp = next>=N? 0:dp[next];
				dp[i] = consult[i][1]+nextDp;
			}
			if(i!=N-1) dp[i] = Math.max(dp[i], dp[i+1]);
		}
		
		System.out.println(dp[0]);
	}
}