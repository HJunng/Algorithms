import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int[][] map;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for(int i=0;i<n;i++){
                s = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            int roomNum = 1;
            int roomCnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int cnt = dfs(i,j,1);

                    if(cnt>roomCnt){
                        roomCnt = cnt;
                        roomNum = map[i][j];
                    } else if(cnt==roomCnt){
                        roomNum = Math.min(roomNum, map[i][j]);
                    }
                }
            }

            sb.append("#"+t+" "+roomNum+" "+roomCnt+"\n");
        }
        System.out.println(sb);
    }
    static int dfs(int x, int y, int cnt){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int now = map[x][y];

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==now+1){
                cnt = dfs(nx,ny,cnt+1);
            }
        }
        return cnt;
    }
}
