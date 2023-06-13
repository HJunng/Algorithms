package Gold5;

import java.io.*;
public class BJ12865_평범한배낭 {	//60m. 답.
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
		//0번째에 0으로 초기화 되어있어서 i-1, j-1로 쓰기 좋음.
		
		for(int i=1;i<=N;i++) {
			str=br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]); //무게
			arr[i][1] = Integer.parseInt(str[1]); //가치
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {	//dp i열 j행.
				if(j-arr[i][0]>=0)	//넣을 수 있는 무게이면.
					dp[i][j] = Math.max(dp[i-1][j], arr[i][1]+dp[i-1][j-arr[i][0]]);
							//이전 값의 가치가 더 큰지, 내 가치 + 내꺼뺀 무게로 계산한 최대 가치.
				
				else	//현재 물건 넣지 않음.
					dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
	}
}