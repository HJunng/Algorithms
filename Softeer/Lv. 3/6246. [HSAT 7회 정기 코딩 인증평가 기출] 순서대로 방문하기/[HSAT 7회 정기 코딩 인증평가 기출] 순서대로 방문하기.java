import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static List<int[]> orders;
    static boolean[][] canGo;
    static boolean[][] visit;
    static int answer;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] end;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        canGo = new boolean[n][n];
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                if(s[j].equals("0")) { // 벽이 아니면 true로 저장 -> 갈 수 있음.
                    canGo[i][j] = true;
                }
            }
        }

        int[] start = new int[2];
        end = new int[2];
        
        orders = new ArrayList<>();
        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;

            if(i==0) {
                start[0] = x; start[1] = y;
            } else if(i==m-1) {
                end[0] = x; end[1] = y;
            }

            orders.add(new int[]{x,y});
        }
        visit = new boolean[n][n];
        answer = 0;
        visit[start[0]][start[1]] = true;
        dfs(start, 0);

        System.out.println(answer);
    }
    static void dfs(int[] now, int order){
        // 도착지점이면 순서대로 방문했는지 확인 -> 탐색 종료.
        if(now[0]==end[0] && now[1]==end[1]) { 
            if(order == m-1) {
                answer++;
            }
            return;
        }

        // 상하좌우 탐방.
        for(int i=0;i<4;i++){
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];

            if(isInRange(nx,ny) && canGo[nx][ny] && !visit[nx][ny]) {
                if(nx == orders.get(order+1)[0] && ny == orders.get(order+1)[1]) {
                    visit[nx][ny] = true;
                    dfs(new int[]{nx,ny}, order+1);
                    visit[nx][ny] = false;
                } else {
                    visit[nx][ny] = true;
                    dfs(new int[]{nx,ny}, order);
                    visit[nx][ny] = false;
                }
            }
        }
    }
    static boolean isInRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
}
