import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    static int[] childCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        childCnt = new int[n+1];
        for(int i=1;i<=n;i++) childCnt[i]=1;

        parent = new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i; // 초기화

        // cost 순으로 정렬된 pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            pq.add(new int[]{a,b,cost});
        }

        // cost가 적은 다리를 하나씩 꺼내서, 연결 -> 2개의 마을로 나눠질 때까지.
        // 다리를 총 n-1개 연결하면, 모두 다 연결되니까, n-2개만 연결하면 2개의 마을로 나눠질 것이다.
        int costSum=0;
        int bridgeCnt=n-2;
        while(!pq.isEmpty() && bridgeCnt>0){
            int[] now = pq.poll();

            int parentA = find(now[0]);
            int parentB = find(now[1]);

            // 사이클이 만들어질 수 있는 건 x
            if(parentA==parentB) continue;

            // 다리 연결
            union(parentA,parentB);
            costSum+=now[2];
            bridgeCnt--;
        }

        System.out.println(costSum);
    }
    static int find(int x){
        if(parent[x]==x) return x;

        parent[x]=find(parent[x]);
        return parent[x];
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(childCnt[a]<childCnt[b]){
            childCnt[b] += childCnt[a];
            parent[a]=b;
        } else{
            childCnt[a]+=childCnt[b];
            parent[b]=a;
        }
    }
}