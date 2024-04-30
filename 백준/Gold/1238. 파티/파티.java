import java.io.*;
import java.util.*;

public class Main {
    static int MAX = Integer.MAX_VALUE;
    static int[] toX; // x에 도달하는데 걸리는 최소 cost
    static int[] fromX; // x에서 원래 자리로 돌아가는데 걸리는 최소 cost

    static List<List<Road>> fromTo = new ArrayList<>();
    static List<List<Road>> toFrom = new ArrayList<>();

    static class Road {
        int to,cost;
        public Road(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2])-1;

        for(int i=0;i<n;i++){
            fromTo.add(new ArrayList<>());
            toFrom.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int from = Integer.parseInt(s[0])-1;
            int to = Integer.parseInt(s[1])-1;
            int c = Integer.parseInt(s[2]);

            fromTo.get(from).add(new Road(to,c));
            toFrom.get(to).add(new Road(from,c));
        }

        toX = new int[n];
        fromX = new int[n];
        Arrays.fill(toX, MAX);
        Arrays.fill(fromX, MAX);

        dijkstra(toFrom, toX, x); // ~에서 x까지 최소 비용 구하기.
        dijkstra(fromTo, fromX, x); // x에서 ~까지 최소 비용 구하기

        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(result, toX[i]+fromX[i]);
        }
        System.out.println(result);
    }
    static void dijkstra(List<List<Road>> costs, int[] minCost, int x){
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Road(x,0));
        minCost[x]=0;

        while(!pq.isEmpty()){
            Road now = pq.poll();

            for(Road next : costs.get(now.to)){
                // 거쳐가는게 더 작은지 확인.
                if(minCost[next.to] > minCost[now.to] + next.cost){
                    minCost[next.to] = minCost[now.to] + next.cost;
                    pq.add(new Road(next.to, minCost[next.to]));
                }
            }
        }
    }
}