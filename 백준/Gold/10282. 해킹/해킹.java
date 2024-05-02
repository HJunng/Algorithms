import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<int[]>> connect;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        String[] str;
        StringBuilder sb = new StringBuilder();

        while(tc-->0){
            str = br.readLine().split(" ");

            int n = Integer.parseInt(str[0]); // 컴퓨터 개수
            int d = Integer.parseInt(str[1]); // 의존성 개수
            int c = Integer.parseInt(str[2]); // 해킹당한 컴퓨터 번호

            connect = new HashMap<>();
            for(int i=1;i<=n;i++){
                connect.put(i,new ArrayList<>());
            }

            for(int i=0;i<d;i++){
                str = br.readLine().split(" ");

                // b가 감염되면 s초 후 a컴퓨터 감염
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                int s = Integer.parseInt(str[2]);

                connect.get(b).add(new int[]{a,s});
            }

            int[] result = dijkstra(n,c);
            sb.append((n-result[0])+" "+result[1]+"\n");
        }
        System.out.println(sb);
    }
    private static int[] dijkstra(int remainCnt, int hackedCom){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{hackedCom,0});

        boolean[] visited = new boolean[remainCnt+1];

        int time=0;
        while(!pq.isEmpty() && remainCnt>0){
            int[] now = pq.poll();

            if(visited[now[0]]) continue;

            visited[now[0]] = true; // 방문처리
            time = now[1];
            remainCnt--;

            for(int[] next : connect.get(now[0])){
                pq.add(new int[]{next[0],now[1]+next[1]});
            }
        }

        return new int[]{remainCnt, time};
    }
}
