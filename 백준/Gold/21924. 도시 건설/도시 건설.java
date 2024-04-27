import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Bridge{
        int a, b, cost;
        public Bridge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    static int[] parent;
    static int[] childCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 건물 개수
        int m = Integer.parseInt(s[1]); // 다리 개수

        parent = new int[n+1];
        for(int i=1;i<=n;i++) parent[i] = i;

        childCnt = new int[n+1]; // 처음에는 자식 1명도 없음.

        PriorityQueue<Bridge> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);

        long totalCost = 0;
        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            pq.add(new Bridge(a,b,cost));
            totalCost += cost;
        }

        int cnt = n-1; // 최소한으로 연결하려면 (도시-1)개의 다리 연결
        long minCost = 0;
        while(!pq.isEmpty() && cnt>0){
            Bridge b = pq.poll();

            boolean isConnected = union(b.a,b.b);

            // 이미 연결되어 있는 경우 -> 다리 추가 x
            if(isConnected) continue;

            minCost += b.cost;
            cnt--;
        }

        //  다 연결되지 못했을 경우
        if(cnt>0) System.out.println(-1);
        else System.out.println(totalCost - minCost);
    }

    static int find(int x){
        if(parent[x] == x) return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b){
            return true;
        } else if(childCnt[a] < childCnt[b]){
            parent[a] = b;
            childCnt[b] += childCnt[a];
            return false;
        } else {
            parent[b] = a;
            childCnt[a] += childCnt[b];
            return false;
        }
    }
}