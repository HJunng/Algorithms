import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 건물 개수
        int m = Integer.parseInt(s[1]); // 도로 개수

        parent = new int[n+1];
        for(int i=0;i<=n;i++)
            parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)->b[2]-a[2]);

        int firstRoad = 0; // 입구-1번이 오르막인지.
        for(int i=0;i<=m;i++) {
            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]); // 0이면 오르막.

            if(i!=0) {
                pq.offer(new int[]{a,b,c});
                pq2.offer(new int[]{a,b,c});
            }
            else if(c==0) firstRoad++;
        }

        int bridgeCnt = n-1;
        int uphillCnt = firstRoad;
        while(bridgeCnt>0 && !pq.isEmpty()) {
            int[] now = pq.poll();

            int parentA = find(now[0]);
            int parentB = find(now[1]);

            if(parentA==parentB) continue;

            bridgeCnt--;
            if(now[2]==0) uphillCnt++;
            union(parentA, parentB);
        }

        int maxFatigue = uphillCnt*uphillCnt;

        // 2. 최소 피로도 구하기.
        for(int i=0;i<=n;i++)
            parent[i] = i;

        bridgeCnt = n-1;
        uphillCnt = firstRoad;
        while(bridgeCnt>0 && !pq2.isEmpty()) {
            int[] now = pq2.poll();

            int parentA = find(now[0]);
            int parentB = find(now[1]);

            if(parentA==parentB) continue;

            bridgeCnt--;
            if(now[2]==0) uphillCnt++;
            union(parentA, parentB);
        }

        int minFatigue = uphillCnt*uphillCnt;

//        System.out.println(maxFatigue+" "+minFatigue);
        System.out.println(maxFatigue - minFatigue);
    }
    private static int find(int x){
        if(parent[x]==x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x<y)parent[y] = x;
        else parent[x] = y;
    }
}