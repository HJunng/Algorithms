import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] num, sum;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간 합 구하는 횟수

        // N개의 수 입력받기
        num = new long[N];
        sum = new long[N];
        for(int i=0;i<N;i++){
            num[i] = Long.parseLong(br.readLine());
            sum[i] = (i==0)? num[i]:sum[i-1]+num[i];
        }

        // 수 변경 or 구간합
        for(int i=0;i<M+K;i++){ // O(20000)
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // 수 변경 : b-1번째 수를 c로 바꾸기
            if(a==1){
                change(b-1,c);
            }
            // 구간 합 구하기 : b-1번째 수부터 c-1번째 수까지 구간 합
            // 1. 구간 합 매번 구하기 O(1,000,000)  -> 7% 시간초과
            // 2. k번째 수까지의 합 배열 구해놓고, 수 변경될 때 갱신하기. -> 7% 시간초과
            else {
                if(b-1==0) System.out.println(sum[(int)c-1]);
                else System.out.println(sum[(int)c-1]-sum[b-2]);
            }
        }
    }
    static void change(int b, long c){
        long temp = num[b];
        num[b] = c;
        for(int j=b;j<N;j++){
            sum[j] = sum[j]-temp+c;
        }
    }
}