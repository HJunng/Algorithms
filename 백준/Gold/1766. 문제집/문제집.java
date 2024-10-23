import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] degree;
    static Map<Integer, List<Integer>> next;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 점 개수
        int m = Integer.parseInt(s[1]);

        // 초기화
        degree = new int[n+1];
        next = new HashMap<>();
        for(int i=1;i<=n;i++) next.put(i, new ArrayList<>());

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]); // 먼저
            int b = Integer.parseInt(s[1]);

            degree[b]++; // 차수 증가
            next.get(a).add(b); // a -> b 연결 추가
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        // 차수가 0인 것 넣기
        for(int i=1;i<=n;i++){
            if(degree[i]==0) pq.add(i);
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            System.out.print(now + " ");

            // now를 방문했으니, 연결된 것들 차수 -1
            for(int i : next.get(now)){
                degree[i]--;
                // 그 중에 차수가 0이 되었으면 q에 넣어서 방문하기.
                if(degree[i]==0) pq.add(i);
            }
        }
    }
}