import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        String[] s;
        while(TC-->0){
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            s = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                coins[i] = Integer.parseInt(s[i]);
            }
            int sum = Integer.parseInt(br.readLine());

            int[] dp = new int[sum+1]; // 1~sum까지 채울 것임
//            dp[0] = 1; // 0을 만들 수 있는 1가지 방법.

//            for(int i=1;i<=sum;i++){
//                for(int coin : coins){
//                    // coin은 오름차순으로 정렬되어있어, 더 큰 coin은 어차피 0을 넘김.
//                    if(i-coin>0) dp[i] += dp[i-coin];
//                    else if(i-coin==0) dp[i]++;
//                }
//            }

            for(int coin : coins){
                for(int i=1;i<=sum;i++){
                    if(i-coin>0) dp[i] += dp[i-coin];
                    else if(i-coin==0) dp[i]++;
                }
            }
//            System.out.println(Arrays.toString(dp));
            System.out.println(dp[sum]);
        }
    }
}