package DP;

public class Lv2_멀리뛰기 {
	static int mod=1234567; //나눠줄 수.
    static long cnt[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public long solution(int n) {
        long answer = 0;
        
        cnt = new long[n+2]; //기준보다 1개 더 만들면 -> 1번테스트 런타임 에러
        cnt[1]=1;
        cnt[2]=2;
        
        for(int i=3;i<=n;i++){
            dp(i);
        }
        
        return cnt[n];
    }
    // 동적계획법
    static void dp(int n){
        
        cnt[n]= (cnt[n-1]%mod + cnt[n-2]%mod) %mod;
    }
}
