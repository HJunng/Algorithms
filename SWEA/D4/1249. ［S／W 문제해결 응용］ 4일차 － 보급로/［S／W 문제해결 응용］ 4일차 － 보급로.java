import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;

        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visited = new boolean[n][n];
            for(int i=0;i<n;i++){
                s = br.readLine().split("");
                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            sb.append("#"+t+" "+bfs()+"\n");
        }
        System.out.println(sb);
    }
    static int bfs(){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        visited[0][0]=true;

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(now[1]==n-1 && now[2]==n-1){
                return now[0];
            }

            for(int i=0;i<4;i++){
                int nx = now[1]+dx[i];
                int ny = now[2]+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    pq.add(new int[]{now[0]+map[nx][ny], nx,ny});
                }
            }
        }

        return -1;
    }
}
