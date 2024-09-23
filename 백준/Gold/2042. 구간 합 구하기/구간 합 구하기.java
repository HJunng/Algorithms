import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[] num, sum;
    public static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수의 개수
        m = Integer.parseInt(st.nextToken()); // 변경 횟수
        k = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수

        num = new long[n];
        sum = new long[n+1];
        sum[0] = 0;
        for(int i=0; i<n; i++){
            num[i] = Long.parseLong(br.readLine());
            sum[i + 1] = sum[i] + num[i];
        }

        for(int i=0; i<m + k ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch(a){
                case 1:
                    long c = Long.parseLong(st.nextToken());
                    // b번째 수를 c로 바꾸기
                    changeNum(b - 1, c);
                    break;
                case 2:
                    // b번째 수 ~ c번째수의 합을 구하기
                    int idx = Integer.parseInt(st.nextToken());
                    System.out.println(sum[idx] - sum[b-1]);
                    break;
            }
        }
    }

    // b 번째 수를 c의 값으로 변경하는 메서드
    private static void changeNum(int b, long c) {
        long originNum = num[b];
        num[b] = c;
        for(int i = b + 1; i <= n; i++){
            sum[i] -= originNum;
            sum[i] += c;
        }
    }
}