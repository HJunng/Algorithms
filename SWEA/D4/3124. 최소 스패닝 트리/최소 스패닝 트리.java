import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static int[] parent;
    static int[] childCnt;
    static PriorityQueue<Connect> pq;
    static class Connect{
        int n1,n2, cost;
        public Connect(int n1, int n2, int cost){
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;

        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            s = br.readLine().split(" ");

            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);

            parent = new int[v+1];
            for(int i=1;i<=v;i++){
                parent[i] = i;
            }

            childCnt = new int[v+1];
            pq = new PriorityQueue<>((a,b)->a.cost-b.cost);

            for(int i=0;i<e;i++){
                s = br.readLine().split(" ");

                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);

                pq.add(new Connect(a,b,c));
            }

            int cnt = v-1;
            long sum=0;
            while(!pq.isEmpty() && cnt>0){
                Connect c = pq.poll();

                if(find(c.n1) == find(c.n2)) continue;

                union(c.n1, c.n2);
                sum += c.cost;
                cnt--;
            }

            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb);
    }
    static int find(int x){
        if(parent[x]==x) return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return;

        if(childCnt[a]>childCnt[b]){ // 자식이 a가 더 많으면, b쪽의 자식들 a로 옮기기.
            childCnt[a] += childCnt[b];
            parent[b]=a;
        } else {
            childCnt[b]+=childCnt[a];
            parent[a]=b;
        }
    }
}
