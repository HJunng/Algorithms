import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int n;
    static boolean[][] visited;
    static boolean[] visitCol;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            visitCol = new boolean[n];
            cnt=0;

            dfs(0);
            sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int row){
        if(row==n){
            cnt++; return;
        }

        for(int i=0;i<n;i++){
            if(!visitCol[i] && possibleQueen(row,i)){
                visitCol[i] = true;
                visited[row][i]=true;
                dfs(row+1);
                visited[row][i]=false;
                visitCol[i]=false;
            }
        }
    }
    static boolean possibleQueen(int x, int y){
        int[] dx = {1,1,-1,-1}; // 대각선 4방향 확인
        int[] dy = {1,-1,1,-1};

        boolean flag = true;

        int nx = x;
        int ny = y;
        while(nx>=0 && nx<n && ny>=0 && ny<n){
            if(visited[nx][ny]){
                flag = false; break;
            }
            nx+=dx[0]; ny+=dy[0];
        }

        nx=x; ny=y;
        while(flag && nx>=0 && nx<n && ny>=0 && ny<n){
            if(visited[nx][ny]){
                flag = false; break;
            }
            nx+=dx[1]; ny+=dy[1];
        }

        nx=x; ny=y;
        while(flag && nx>=0 && nx<n && ny>=0 && ny<n){
            if(visited[nx][ny]){
                flag = false; break;
            }
            nx+=dx[2]; ny+=dy[2];
        }

        nx=x; ny=y;
        while(flag && nx>=0 && nx<n && ny>=0 && ny<n){
            if(visited[nx][ny]){
                flag = false; break;
            }
            nx+=dx[3]; ny+=dy[3];
        }

        return flag;
    }
}
