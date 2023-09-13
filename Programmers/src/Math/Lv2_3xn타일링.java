package Math;

public class Lv2_3xn타일링 {
	static int MOD = 1000000007;
    static long[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public long solution(int n) {
        int answer = 0;
        
        if(n%2==1) return 0; //가로 길이가 홀수이면 무조건 1*2 직사각형을 꽉 채워 넣을 수 없으므로 0을 반환합니다.
        
        dp = new long[n/2+1];
        dp[1]=3;
        dp[2]=11;
        
        
        return f(n);
    }
    long f(int n){
        if(dp[n/2]>0) return dp[n/2];
        
        dp[n/2]=(f(n-2)*4%MOD-f(n-4)%MOD+MOD)%MOD;
        
        return dp[n/2];
    }
}
