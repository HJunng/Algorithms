import java.util.*;

public class Main {
	static int[] dp; // i 가치를 만들때의 최소 동전 개수.
	static int n; // 동전 종류의 개수 
	static int k; // 만들어야 하는 가치 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		n = s.nextInt(); // 동전의 종류 개수 
		k = s.nextInt(); // 만들어야 하는 가치
		
		dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int[] coin = new int[n];
		for(int i=0;i<n;i++) {
			coin[i] = s.nextInt();
			if(coin[i]<=k) dp[coin[i]]=1;
		}
		
		
		System.out.println(findDP(coin));
		
	}
	static int findDP(int[] coin) {
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			if(coin[i]<=k) {
				q.add(coin[i]);
				dp[coin[i]]=1;
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now==k) {
				return dp[k];
			}
			
			for(int i : coin) {
				int nextWorth = now+i;
				if(nextWorth<=k && dp[nextWorth]>dp[now]+1) {
					q.add(nextWorth);
					dp[nextWorth]=dp[now]+1;
				}
			}
		}
		
		return -1;
	}
}