import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && map[i][j]>0){
                    if(bfs(i,j,map[i][j])) cnt++;
//                    System.out.println("i j "+i+" "+j+" cnt: "+cnt);
                }
            }
        }

        System.out.println(cnt);
    }
    static boolean bfs(int x, int y, int height) {
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{x, y});
        visit[x][y] = true;

        boolean isTop = true; // 여기가 꼭대기 인지 확인.

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;

                if(map[nx][ny]>height) isTop = false;
                else if (!visit[nx][ny] && map[nx][ny] == height){
                    pq.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
        return isTop;
    }
}