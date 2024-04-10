import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static class Connect{
        int com1,com2,cost;
        public Connect(int com1, int com2, int cost){
            this.com1 = com1;
            this.com2 = com2;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 선의 수

        // cost 오름차순으로 정렬.
        PriorityQueue<Connect> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);

        for(int i=0;i<m;i++){
            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            pq.add(new Connect(a,b,c));
        }

        parent = new int[n+1];
        for(int i=1;i<=n;i++) parent[i] = i;

        int sum = 0;
        while(!pq.isEmpty()){
            Connect now = pq.poll();

            // 이미 연결되어 있는 컴퓨터이면 패스
            if(parent[now.com1] == parent[now.com2]) continue;

            sum += now.cost;
            moveParent(parent[now.com1], parent[now.com2]);
        }
        System.out.println(sum);
    }
    // a, b 컴퓨터의 부모를 합치기 -> 더 작은 수로
    private static void moveParent(int a, int b){
        int small = Math.min(a,b);
        int big = Math.max(a,b);

        for(int i=1;i<=n;i++){
            if(parent[i]==big)
                parent[i] = small;
        }
    }
}
