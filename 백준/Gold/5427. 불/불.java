import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int w,h;
    static char[][] map;

    static int time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            String[] s = br.readLine().split(" ");

            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);

            map = new char[h][w];
            int[] start = new int[2];

            for(int i=0;i<h;i++){ // map 저장
                String line = br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j]=='@'){ // 시작 위치 저장
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }

            time = 0; // 현재 시간 (불이 얼마나 번졌는지를 확인하기 위해 사용)
            int result = bfs(start);

            if(result == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(result);
        }
    }
    private static int bfs(int[] start){

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();

        q.add(new int[]{start[0],start[1],0}); // 현재 위치 행, 열, 걸린시간
        map[start[0]][start[1]] = '!'; //방문 처리

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(map[i][j]=='*') fire.add(new int[]{i,j}); // 불의 행, 열
            }
        }

        while(!q.isEmpty()){

            // 불이 번짐
            int size = fire.size();
            for(int i=0;i<size;i++){
                int[] f = fire.poll();
                for(int dir=0;dir<4;dir++){
                    int nx = f[0] + dx[dir];
                    int ny = f[1] + dy[dir];
                    // 범위를 벗어나지 않고, 벽이 아니고, 이미 불이 붙은자리가 아닐 때
                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]!='#' && map[nx][ny]!='*'){
                        map[nx][ny]='*';
                        fire.add(new int[]{nx,ny});
                    }
                }
            }

            // 상근이 이동
            size = q.size();
            for(int i=0;i<size;i++){
                int[] now = q.poll();

                // map의 벽에 다다르면 (현재까지의 시간 +1) 해서 나가는게 가장 빠른길
                if(now[0]==0 || now[0]==h-1 || now[1]==0 || now[1]==w-1)
                    return now[2]+1;

                // 상하좌우 이동
                for(int dir=0;dir<4;dir++){
                    int nx = now[0]+dx[dir];
                    int ny = now[1]+dy[dir];
                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]=='.'){
                        map[nx][ny]='!';
                        q.add(new int[]{nx,ny,now[2]+1});
                    }
                }
            }
        }

        // 탈출 못함.
        return -1;
    }
    private static void fireMove(){

        // 불이 있는 위치 따로 저장
        ArrayList<int[]> fireLoc = new ArrayList<>();

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(map[i][j]=='*'){
                    fireLoc.add(new int[]{i,j});
                }
            }
        }

        // 불 번짐 (상하좌우)
        for(int[] loc : fireLoc){
            for(int i=0;i<4;i++){
                int nx = loc[0]+dx[i];
                int ny = loc[1]+dy[i];

                if(nx<0 && nx>=h || ny<0 || ny>=w) continue;

                if(map[nx][ny]=='.' || map[nx][ny]=='!') // 범위를 벗어나지 않고, 벽 아님
                    map[nx][ny] = '*';
            }
        }
    }
}