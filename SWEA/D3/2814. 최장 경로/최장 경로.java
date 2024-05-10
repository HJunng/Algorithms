import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static boolean visited[];
    static Map<Integer, List<Integer>> map;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            map = new HashMap<>();
            for(int i=1;i<=n;i++){
                map.put(i, new ArrayList<>());
            }

            for(int i=0;i<m;i++){
                s = br.readLine().split(" ");

                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                map.get(a).add(b);
                map.get(b).add(a);
            }

            int result = 1;
            for(int i=1;i<=n;i++){
                visited = new boolean[n+1];
                visited[i]=true;
                max=1;
                dfs(i,1);
                result = Math.max(result, max);
                if(result==n) break;
            }

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int now, int cnt){
        max = Math.max(max, cnt);

        for(int next : map.get(now)){
            if(!visited[next]){
                visited[next]=true;
                dfs(next,cnt+1);
                visited[next]=false;
            }
        }
    }
}
