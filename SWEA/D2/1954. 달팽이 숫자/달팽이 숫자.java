import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=tc;t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            int x=0,y=0,dir=0;
            for(int i=1;i<=N*N;i++){
                map[x][y] = i;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 범위 나가거나, 이미 채워진 칸이면 방향 전환해야 함.
                if(!inRange(nx,ny,N) || map[nx][ny]>0){
                    dir = (dir+1)%4;

                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx; y = ny;
            }

            sb.append("#"+t+"\n");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    sb.append(map[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static boolean inRange(int x, int y, int N){
        if(x>=0 && y>=0 && x<N && y<N) return true;
        else return false;
    }
}