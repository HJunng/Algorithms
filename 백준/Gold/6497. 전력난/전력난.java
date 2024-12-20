import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static class Road{
        int x,y,dist;
        Road(int x,int y,int dist){
            this.x=x; this.y=y; this.dist=dist;
        }
    }
    static int[] parent;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] s = br.readLine().split(" ");

            int m = Integer.parseInt(s[0]); // 집의 수
            int n = Integer.parseInt(s[1]); // 길의 수

            if(m==0 && n==0) break;

            System.out.println(calSaveMoney(m,n));
        }
    }
    static long calSaveMoney(int m, int n) throws IOException {
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);

        long before = 0;
        String[] s;
        for(int i=0;i<n;i++) {
            s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            before += z;

            pq.add(new Road(x,y,z));
        }

        parent = new int[m];
        for(int i=0;i<m;i++) parent[i]=i;

        int roadCount = 0;
        long cost = 0;
        while(roadCount<m-1 && !pq.isEmpty()) {
            Road road = pq.poll();

            int parentA = find(road.x);
            int parentB = find(road.y);

            if(parentA==parentB) continue;
            else {
                union(parentA,parentB);
                roadCount++;
                cost += road.dist;
            }
        }

//        System.out.println(before+" "+cost);
        return before-cost;
    }
    static int find(int x){
        if(parent[x]==x) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x<y) parent[y]=x;
        else parent[x]=y;
    }
}