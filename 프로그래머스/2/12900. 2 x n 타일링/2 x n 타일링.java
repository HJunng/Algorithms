class Solution {
    static int mod = 1000000007;
    public int solution(int n) {
        int answer = 0;
        
        int[] cnt = new int[n+1];
        
        cnt[1]=1;
        if(n>=2) cnt[2]=2;
        for(int i=3;i<=n;i++){
            cnt[i]=(cnt[i-1]+cnt[i-2])%mod;
        }
        
        return cnt[n];
    }
}