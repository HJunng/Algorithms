import java.io.*;

public class Main {
	static int cnt=0;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(s[j]);
			}
		}
		long[][] dp = new long[N][N]; // (i,j)에서 (N-1,N-1)로 갈 수 있는 경로의 개수.
		dp[N-1][N-1] = 1; //도착지점으로 가는 경로 개수. -> end에서 end로 도착할 수 있는 방법은 1개.
		for(int i=N-1;i>=0;i--) {
			for(int j=N-1;j>=0;j--) {
				dp[i][j] = findDP(i,j,board,dp);
			}
		}
		
		System.out.println(dp[0][0]);
	}
	static long findDP(int x, int y, int[][] b, long[][] dp) {
		if(b[x][y]==0) return dp[x][y];
		
		int move = b[x][y]; // 움직일 거
		int nx = x+move; // 아래 
		int ny = y+move; // 오른쪽 
		
		// 갈수 있으면 그 다음 위치의 경로 개수 추가.
		if(nx<dp.length) dp[x][y]+=dp[nx][y];
		if(ny<dp.length) dp[x][y]+=dp[x][ny];
		
		//if(dp[x][y]>0) System.out.println(x+" "+y+" : "+dp[x][y]);
		return dp[x][y];
	}
}