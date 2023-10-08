import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			int K = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int[] file = new int[K+1];
			int[] sum = new int[K+1];
			int[][] dp = new int[K+1][K+1];
			
			for(int i=1;i<=K;i++) {
				file[i] = Integer.parseInt(s[i-1]);
				sum[i] = sum[i-1]+file[i];
			}
			
			for(int i=1;i<=K;i++) {
				for(int from=1;from+i<=K;from++) {
					int to = from + i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int divide = from;divide<to;divide++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1]);
					}
				}
			}
			System.out.println(dp[1][K]);
			
		}
	}

}