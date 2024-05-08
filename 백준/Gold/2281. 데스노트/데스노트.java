import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int[] names;
    static int n,m;
    static int[][] dp = new int[1001][1002];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]); // 사람 이름 개수
        m = Integer.parseInt(s[1]); // 가로 폭

        names = new int[n];
        for(int i=0;i<n;i++){
            names[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int len = names[0]+1;
        System.out.println(writeName(1,len));
    }
    static int writeName(int idx, int len){
        if(idx==n) return 0;
        
        int ans = dp[idx][len];
        if(ans!=-1) return ans;

        // 1. 다음 줄에 쓰는 경우
        int remain = m-len+1; // 남은 칸수
        ans = writeName(idx+1, names[idx]+1) + (int)Math.pow(remain,2);

        // 2. 현재 줄에 이어서 쓰는 경우
        if(len + names[idx]<=m){
            ans = Math.min(writeName(idx+1, len+names[idx]+1),ans);
        }
        
        dp[idx][len] = ans;
        return ans;
    }
}