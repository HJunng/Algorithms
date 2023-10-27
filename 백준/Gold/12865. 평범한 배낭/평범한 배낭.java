import java.io.*;
public class Main {
	public static int arr[][];
	public static int dp[][];	//가치의 최댓값.
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]); //물품의 수
		int K = Integer.parseInt(str[1]); //버틸 수 있는 무게
		
		if(N<=0 || K<=0) {	//길이나 최대 무게가 0이하이면 종료.
			System.out.println(0);
			return;
		}
		
		arr = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			str=br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]); //무게
			arr[i][1] = Integer.parseInt(str[1]); //가치
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {	//dp i열 j행.
				if(j-arr[i][0]>=0)	//넣을 수 있는 무게이면.
					dp[i][j] = Math.max(dp[i-1][j], arr[i][1]+dp[i-1][j-arr[i][0]]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
	}
}