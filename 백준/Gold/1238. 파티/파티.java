import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[][] minCost;
    static long MAX = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2])-1;

        minCost = new long[n][n];
        for(int i=0;i<n;i++) // 처음에는 모든 거리 MAX값으로 초기화
            Arrays.fill(minCost[i], MAX);

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int from = Integer.parseInt(s[0])-1;
            int to = Integer.parseInt(s[1])-1;
            int cost = Integer.parseInt(s[2]);

            minCost[from][to] = cost; // a->b 가는 비용 = c
        }

        for(int i=0;i<n;i++)
            minCost[i][i] = 0;

        // 플로이드 - 워셜
        // 점화식 : Dab = min(Dab, Dac + Dcb)
        for(int mid=0;mid<n;mid++){ // 중간에 거치는 노드
            for(int start=0;start<n;start++) { // start->mid
                for (int end = 0; end < n; end++) {   // mid -> end
                    if(minCost[start][mid]==MAX || minCost[mid][end]==MAX) continue; // 더하는 값 중하나라도 MAX값이 있으면 더하면 -되므로 넘어가기.

                    minCost[start][end] = Math.min(minCost[start][end], minCost[start][mid] + minCost[mid][end]);
                }
            }
        }

        long maxCost = 0;
        for(int i=0;i<n;i++){
            maxCost = Math.max(maxCost, minCost[i][x]+minCost[x][i]);
        }

        System.out.println(maxCost);
    }
}