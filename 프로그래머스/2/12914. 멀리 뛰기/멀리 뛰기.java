class Solution {
    public long solution(int n) {
        int mod = 1234567;
        
        long[] cnt = new long[n+2];
        cnt[0] = 1; // 1가지 방법.
        
        for(int i=0;i<n;i++){
            cnt[i+1] = (cnt[i+1] + cnt[i])%mod;
            cnt[i+2] = (cnt[i+2] + cnt[i])%mod;
        }
        
        return cnt[n];
    }
}