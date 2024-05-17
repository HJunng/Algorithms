import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            int[] dp = new int[n];
            int max = 1;

            s = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                num[i] = Integer.parseInt(s[i]);
                dp[i]=1;
                for(int j=0;j<i;j++){
                    if(num[j]<num[i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                max = Math.max(max,dp[i]);
            }

            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}
