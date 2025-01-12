import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        char[][] mapRG = new char[N][N];

        for(int i=0;i<N;i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                mapRG[i][j] = (map[i][j]=='G')? 'R' : map[i][j];
            }
        }

        visit =  new boolean[N][N];
        int cntRGB = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visit[i][j]) {
                    cntRGB++;
                    bfs(i,j,map[i][j],map);
                }
            }
        }

        visit =  new boolean[N][N];
        int cntRB = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visit[i][j]) {
                    cntRB++;
                    bfs(i,j,mapRG[i][j],mapRG);
                }
            }
        }

        System.out.println(cntRGB+" "+cntRB);
    }
    static void bfs(int x, int y, char color, char[][] map) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N ||
                        visit[nx][ny] || map[nx][ny]!=color) continue;

                visit[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }
}