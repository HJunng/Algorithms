import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static final int n = 16;
    static int[][] map;
    static int[] start,end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            br.readLine();

            map = new int[n][n];
            start = new int[2];
            end = new int[2];

            for(int i=0;i<n;i++){
                s = br.readLine();
                for(int j=0;j<n;j++){
                    if(s.charAt(j)=='1'){
                        map[i][j] = -1;
                    } else {
                        map[i][j] = 0;
                        if (s.charAt(j) == '2') {
                            start[0] = i;
                            start[1] = j;
                        } else if (s.charAt(j) == '3') {
                            end[0] = i;
                            end[1] = j;
                        }
                    }
                }
            }
            sb.append("#"+t+" "+bfs(start[0], start[1])+"\n");
        }
        System.out.println(sb);
    }
    static int bfs(int x, int y){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        map[x][y] = 1;

        while (!q.isEmpty()){
            int[] now = q.poll();

            if(now[0]==end[0] && now[1]==end[1]){
                return 1;
            }

            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && (map[nx][ny]==0 || map[nx][ny]>map[now[0]][now[1]]+1)){
                    map[nx][ny] = map[now[0]][now[1]]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return 0;
    }
}
