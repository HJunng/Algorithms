import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static long[][] dp;
    static int MOD = 1000000009;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new long[100001][4];
        dp[1][1] = 1; // 0+1
        dp[2][2] = 1; // 0+2
        dp[3][1] = dp[2][2]; // 2+1
        dp[3][2] = dp[1][1]; // 1+2
        dp[3][3] = 1;        // 0+3

//        dp[i][1] = dp[i-1][2]+dp[i-1][3];

        int max = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            max = Math.max(max, n);
        }
        findDP(max);

        for(int i : list){
            System.out.println((dp[i][1]+dp[i][2]+dp[i][3])%MOD);
        }
    }
    static void findDP(int n){
        for(int i=4;i<=n;i++){
            dp[i][1] = (dp[i-1][2]%MOD+dp[i-1][3]%MOD)%MOD;
            dp[i][2] = (dp[i-2][1]%MOD+dp[i-2][3]%MOD)%MOD;
            dp[i][3] = (dp[i-3][1]%MOD+dp[i-3][2]%MOD)%MOD;
        }
    }
}