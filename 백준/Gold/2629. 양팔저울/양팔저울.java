import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] weight;
    static boolean[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        weight = new int[n];
        for(int i=0;i<n;i++) weight[i] = Integer.parseInt(s[i]);

        m = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        dp = new boolean[n+2][40001];
        dfs(1,0);

        for(int i=0;i<m;i++){
            int ball = Integer.parseInt(s[i]);

            if(dp[n+1][ball]) System.out.print("Y ");
            else System.out.print("N ");
        }
    }
    private static void dfs(int cnt, int idx){
        if(dp[cnt][idx]) return;

        dp[cnt][idx]=true;

        if(cnt==n+1) return;

        dfs(cnt+1,idx+weight[cnt-1]);
        dfs(cnt+1,idx);
        dfs(cnt+1,Math.abs(idx-weight[cnt-1]));

    }
}