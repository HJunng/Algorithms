import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n,m;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dp;
    static int maxMove;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new char[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j);
            }
        }

        if(map[0][0]=='H'){
            System.out.println(0); return;
        }

        visit = new boolean[n][m];
        dp = new int[n][m];
        visit[0][0]=true;

        maxMove = 1;
        dfs(0,0,1);
        System.out.println(maxMove);
    }
    static void dfs(int x, int y, int cnt){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        dp[x][y] = cnt;

        if(maxMove==-1) return;
        if(cnt>maxMove){
            maxMove = cnt;
        }

        for(int i=0;i<4;i++){
            int nx = x + dx[i] * (map[x][y]-'0');
            int ny = y + dy[i] * (map[x][y]-'0');

            // 밖으로 나가거나, H에 빠지면 이동x. 종료.
            if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny]=='H') continue;

            // 이전에 더 적은 횟수로 방문한 거면, 결과값이 더 작을 수밖에 없으므로 조사x.
            if(cnt<dp[nx][ny]) continue;

            // 루프가 생기면 바로 종료.
            if(visit[nx][ny]){
                maxMove = -1; return;
            }

            visit[nx][ny]=true;
            dfs(nx,ny,cnt+1);
            visit[nx][ny]=false;
        }
    }
}