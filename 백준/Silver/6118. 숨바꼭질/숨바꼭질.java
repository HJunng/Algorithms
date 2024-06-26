import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> con;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 헛간 개수(node)
        int m = Integer.parseInt(s[1]); // 연결 개수(edge)

        con = new HashMap<>();
        for(int i=1;i<=n;i++){
            con.put(i, new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            con.get(a).add(b); // 양방향 길 연결
            con.get(b).add(a);
        }

        boolean[] visit = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        visit[1]=true;

        int endNumber = 1;
        int endDist = 0;
        int distCnt = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();

            // 이전 최대거리보다 멀면
            if(now[1]>endDist){
                distCnt = 1;
                endDist = now[1];
                endNumber = now[0];
            } else if(now[1]==endDist){
                distCnt++;
                endNumber = Math.min(endNumber, now[0]);
            }

            for(int next : con.get(now[0])){
                if(!visit[next]){
                    visit[next] = true;
                    q.add(new int[]{next,now[1]+1});
                }
            }
        }

        System.out.println(endNumber+" "+endDist+" "+distCnt);
    }
}