import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n=1
        // 1

        // n=2
        // 10

        // n=3
        // 100, 101

        // n=4
        // 1000, 1001, 1010
        if(n==1 || n==2) {
            System.out.println(1);
            return;
        }

        long[][] dp = new long[n+1][2];
        dp[1][1] = 1; // n=1인데, 뒷자리수가 1인거 개수.
        dp[2][0] = 1; // n=2인데, 뒷자리수가 0인 거 개수.

        for(int i=3;i<=n;i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0]+dp[n][1]);
    }
}