import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Map<Integer, Set<Integer>> map;
    static Set<Integer> visit;
    static int[] max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            s = br.readLine().split(" ");

            map = new HashMap<>();
            visit = new HashSet<>();
            max = new int[2];

            int n = Integer.parseInt(s[0]);
            int start = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            for(int i=0;i<n;i+=2){
                int from = Integer.parseInt(s[i]);
                int to = Integer.parseInt(s[i+1]);

                map.put(from, map.getOrDefault(from, new HashSet<>()));
                map.get(from).add(to);
            }

            bfs(start);

            sb.append("#"+t+" "+max[1]+"\n");
        }
        System.out.println(sb);
    }
    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,start});
        visit.add(start);
        max[1]=start;

        while(!q.isEmpty()){
            int[] now = q.poll();
            if(map.get(now[1])==null) continue;

            for(int next : map.get(now[1])){
                if(!visit.contains(next)){
                    q.add(new int[]{now[0]+1,next});
                    visit.add(next);

                    if(now[0]+1>max[0]){
                        max[0] = now[0]+1;
                        max[1] = next;
                    } else if(now[0]+1==max[0]){
                        max[1] = Math.max(max[1], next);
                    }
                }
            }
        }
    }
}
