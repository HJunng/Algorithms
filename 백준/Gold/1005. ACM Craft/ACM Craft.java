import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> map;
    static long[] time, dp;
    static int[] beforeCnt;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] s;
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            s = br.readLine().split(" ");

            n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            time = new long[n+1];
            s = br.readLine().split(" ");
            for(int i=1;i<=n;i++){
                time[i] = Integer.parseInt(s[i-1]);
            }

            map = new HashMap<>();
            beforeCnt = new int[n+1];
            for(int i=1;i<=n;i++)
                map.put(i,new ArrayList<>());

            for(int i=0;i<k;i++){
                s = br.readLine().split(" ");

                int before = Integer.parseInt(s[0]);
                int after = Integer.parseInt(s[1]);

                map.get(before).add(after);
                beforeCnt[after]++;
            }

            int start = Integer.parseInt(br.readLine());
            dp = new long[n+1];
            sb.append(findDP(start)+"\n");
        }
        System.out.println(sb);
    }
    static long findDP(int x){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            dp[i] = time[i]; // 기본 소요시간 : 나를 짓는데 걸리는 시간

            if(beforeCnt[i]==0) // 이전에 지어야 하는 건물 없는 것부터.
                q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : map.get(now)){
                dp[next] = Math.max(dp[next], dp[now]+time[next]);
                beforeCnt[next]--;

                if(beforeCnt[next]==0) q.add(next);
            }
        }

        return dp[x];
    }
}