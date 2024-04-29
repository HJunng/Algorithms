import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] candy = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            s = br.readLine().split(" ");
            for(int j=1;j<=m;j++){
                candy[i][j] = Integer.parseInt(s[j-1]);
                dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1])) + candy[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }
}