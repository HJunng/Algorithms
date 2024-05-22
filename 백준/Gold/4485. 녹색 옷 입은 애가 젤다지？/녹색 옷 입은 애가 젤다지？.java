import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(true){
            index++;
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int[][] map = new int[N][N];
            for(int i=0;i<N;i++){
                s = br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            sb.append("Problem "+index+": "+bfs(map)+"\n");
        }
        System.out.println(sb);
    }
    static int bfs(int[][] map){
        int[][] min = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(min[i],125*10);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        min[0][0]=map[0][0];

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[0]==N-1 && now[1]==N-1) continue;

            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(min[now[0]][now[1]]+map[nx][ny] < min[nx][ny]){
                    q.add(new int[]{nx,ny});
                    min[nx][ny] = min[now[0]][now[1]] + map[nx][ny];
                }
            }
        }

        return min[N-1][N-1];
    }
}
