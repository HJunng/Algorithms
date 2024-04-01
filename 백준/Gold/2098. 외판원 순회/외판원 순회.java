import java.io.*;
import java.util.Arrays;

public class Main {
    static int n,fullBit;
    static int INF = 987654321;
    static int[][] w;
    static int[][] dp;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        fullBit = (1<<n) -1; // 2^n(이진수) -1 = 1, 11, 111, 1111, ...

        w = new int[n][n];
        dp = new int[n][fullBit];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1); //초기화

        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                w[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(tsp(0,1)); // 0번 도시부터 시작 (check : 0001)
    }
    static int tsp(int x, int check){ // x:현재 위치한 도시, check : 현재까지 방문한 도시

        // 모든 도시 방문 완료
        if(check == fullBit){
            if(w[x][0]==0) return INF; // 경로가 없으면 INF로 탐색 무효화 (Math.min)
            else return w[x][0]; // 경로가 존재하면 w[x][0]
        }

        //이미 방문한 도시
        if(dp[x][check] != -1) return dp[x][check];

        // 해당 도시에 출석 표시
        dp[x][check] = INF;

        // 방문하지 않은 도시 탐색
        for(int i=0;i<n;i++){
            // next : i 도시 방문
            int next = check | (1<<i); // 1<<i : i번째 비트를 1로 설정하는 것 -> 방문한다
                                        // or 연산자는 비트 계산할 때, 1001 | 1000 => 1001 계산됨

            //경로가 없거나 i 도시를 이미 방문했을 경우는 넘김
            // check & (1<<i) !=0 : check의 i번째 비트가 1이면 이미 방문했다는 뜻
            if(w[x][i]==0 || (check & (1<<i)) != 0) continue;

            dp[x][check] = Math.min(dp[x][check], tsp(i,next)+w[x][i]);
        }

        return dp[x][check];
    }
}