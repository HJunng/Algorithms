import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 인형 총 개수
        int k = Integer.parseInt(s[1]); // k개 이상의 라이언 인형

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        s = br.readLine().split(" ");

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(s[i-1]);
            sum[i] = sum[i-1] + ((arr[i]==1)? 1:0);

            if(sum[i]-sum[left]>=k){
                for(int j=left+1;j<=i && sum[i]-sum[left]>=k;j++){
                    left = j;
                }
                minLen = Math.min(minLen, i-left+1);
            }
        }
        if(minLen == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minLen);
    }
}