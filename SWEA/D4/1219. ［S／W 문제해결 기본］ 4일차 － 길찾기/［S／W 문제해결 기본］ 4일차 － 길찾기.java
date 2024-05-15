import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> map;
    static Set<Integer> visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            s = br.readLine().split(" ");
            int n = Integer.parseInt(s[1]);
            map = new HashMap<>();
            visit = new HashSet<>();

            s = br.readLine().split(" ");
            for(int i=0;i<2*n;i+=2){
                int from = Integer.parseInt(s[i]);
                int to = Integer.parseInt(s[i+1]);

                if(map.get(from)==null) map.put(from, new ArrayList<>());
                map.get(from).add(to);
            }
            sb.append("#"+t+" "+bfs(0)+"\n");
        }
        System.out.println(sb);
    }
    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            if(now==99){
                return 1;
            }
            if(map.get(now)==null) continue;

            for(int next : map.get(now)){
                if(!visit.contains(next)){
                    q.add(next);
                    visit.add(next);
                }
            }
        }
        return 0;
    }
}
