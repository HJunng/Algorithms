import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int[][] dist;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int sx=0, sy=0; // 시작지점.
        map = new int[n][m];

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j]==2){
                    sx=i; sy=j;
                }
            }
        }

        dist = new int[n][m];
        bfs(sx,sy);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dist[i][j]==0 && map[i][j]==1)
                    System.out.print("-1 ");
                else
                    System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void bfs(int startX, int startY){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{startX,startY});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(nx==startX && ny==startY) continue;
                if(map[nx][ny]==1 && (dist[nx][ny]==0 || dist[nx][ny]>dist[now[0]][now[1]]+1)){
                    pq.add(new int[]{nx,ny});
                    dist[nx][ny] = dist[now[0]][now[1]]+1;
                }
            }
        }
    }
}