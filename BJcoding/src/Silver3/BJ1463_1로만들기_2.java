package Silver3;

import java.util.*;

public class BJ1463_1로만들기_2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		
		System.out.println(dpFx(x));
	}
	private static int dpFx(int x) {
		int[] dp = new int[x+1];
		dp[0]=dp[1]=0;
		
		for(int i=2;i<=x;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]+1);
		}
		return dp[x];
	}
	//bfs풀이
	private static int bfs(int x) {
		
		boolean[] visited = new boolean[x+1];
		visited[x]=true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,0});
		
		int minCnt=0;
		while(!q.isEmpty()) {
			 int[] now = q.poll();
			 
			 if(now[0]==1) {
				 minCnt=now[1]; break;
			 }
			 
			 if(now[0]%3==0 && !visited[now[0]/3]) {
				 visited[now[0]/3]=true;
				 q.add(new int[] {now[0]/3,now[1]+1});
			 }
			 if(now[0]%2==0 && !visited[now[0]/2]) {
				 visited[now[0]/2]=true;
				 q.add(new int[] {now[0]/2,now[1]+1});
			 }
			 if(!visited[now[0]-1]) {
				 visited[now[0]-1]=true;
				 q.add(new int[] {now[0]-1,now[1]+1});
			 }
		}
		return minCnt;
	}
}
