import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] jump = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0;i<n;i++){
            jump[i] = Integer.parseInt(s[i]);

            for(int j=1;j<=jump[i];j++){
                if(i+j>=n) break;

                if(dp[i]!=Integer.MAX_VALUE) dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        if(dp[n-1]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n-1]);
    }
}
