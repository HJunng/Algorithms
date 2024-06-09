import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 사다리 수
        int m = Integer.parseInt(s[1]); // 뱀 수

        Map<Integer, Integer> move = new HashMap<>();
        for(int i=0;i<n+m;i++){
            s = br.readLine().split(" ");

            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            move.put(start,end);
        }

        int[] dp = new int[101];
        Arrays.fill(dp,200); // 최대값은 99번을 넘지 않을 것 같음.
        dp[1]=0; // 시작

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int now = q.poll();

            if(now==100){
                System.out.println(dp[100]);
                return;
            }

            for(int i=1;i<=6;i++){
                if(now+i>100) break;

                int next = now+i;
                if(move.containsKey(next)){ // 사다리나 뱀에 걸리면 이동.
                    next = move.get(next);
                }

                if(dp[next]>dp[now]+1){ // 이전에 방문횟수보다 작을 때만 방문.
                    dp[next] = dp[now]+1;
                    q.add(next);
                }
            }
        }
    }
}