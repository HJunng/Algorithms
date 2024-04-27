import java.io.*;
import java.util.*;

public class Main {
    static int[][][] map;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m][2]; // [i][j]위치에서 [0]:부신적 없는 경우, [1]:부신적있는경우
        for(int i=0;i<n;i++){
            s = br.readLine().split("");
            for(int j=0;j<m;j++){
                map[i][j][0] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(bfs(0,0));
    }
    static int bfs(int x, int y){

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,0}); // 현재 위치(x,y), 벽을 부신 횟수
        map[x][y][0]=2;// 벽과 구분하기 위해서 시작점을 2라고 둔다. (x,y)까지 최소거리 2.

        while(!q.isEmpty()){
            int[] now = q.poll();
            int broken=now[2];

            if(now[0]==n-1 && now[1]==m-1){
                return map[n-1][m-1][broken]-1;
            }

            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];

                // 범위를 벗어나지 않는지 확인.
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                // 벽을 부시지 않고 가는 경우.
                // 벽이 아니고 && (이전에 방문한 적이 없거나 || 이전에 방문했을 때보다 더 적은 횟수로 갈 수 있는 경우)
                if(map[nx][ny][0]==0 && (map[nx][ny][broken]==0 || map[nx][ny][broken]>map[now[0]][now[1]][broken]+1)){
                    map[nx][ny][broken] = map[now[0]][now[1]][broken]+1;
                    q.add(new int[]{nx,ny,broken});
                }

                // 벽을 부시고 가는 경우 (벽 부실 횟수 남아야함)
                if(broken==0 && map[nx][ny][0]==1 &&
                        ( map[nx][ny][1]==0 || map[nx][ny][1]>map[now[0]][now[1]][0]+1)){
                    map[nx][ny][1] = map[now[0]][now[1]][0]+1;
                    q.add(new int[]{nx,ny,1});
                }
            }
        }


        return -1;
    }
}