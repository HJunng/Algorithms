import java.io.*;
import java.util.*;

public class Main {
    static int[][][] map;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int w,h;

    static class Point{
        int x, y, dir,mirrorCnt;
        public Point(int x, int y, int dir, int mirrorCnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrorCnt = mirrorCnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        w = Integer.parseInt(s[0]);
        h = Integer.parseInt(s[1]);

        map = new int[h][w][4];
        Arrays.fill(start,-1);

        for(int i=0;i<h;i++){
            String str = br.readLine();
            for(int j=0;j<w;j++){
                char c = str.charAt(j);

                if(c=='*') Arrays.fill(map[i][j],-1);
                else if(c=='C') {
                    if(start[0]==-1){
                        start[0]=i; start[1]=j;
                    } else {
                        end[0]=i; end[1]=j;
                    }
                }
            }
        }

        System.out.println(bfs(start[0],start[1]));
    }
    static int bfs(int startX, int startY){
        int result = Integer.MAX_VALUE;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<Point> pq = new LinkedList<>();

        // 처음 좌표를 방향을 정해서 넣어야 하니까 4방향으로 확인해서 한칸 가서 넣어주기.
        for(int i=0;i<4;i++){
            int nx = startX+dx[i];
            int ny = startY+dy[i];

            if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
            if(map[nx][ny][i]==-1) continue;

            map[nx][ny][i]=1; // 방문처리 및 최소거리 갱신
            pq.add(new Point(nx,ny,i,1));
        }

        while(!pq.isEmpty()){
            Point now = pq.poll();
//            System.out.println(now.x+" "+now.y+" "+now.dir+" "+now.mirrorCnt);

            if(now.x==end[0] && now.y==end[1]){
                result = Math.min(result,now.mirrorCnt-1);
            }

            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                // 기존이랑 방향다르면 mirrorCnt+1
                int nMirrorCnt = (now.dir==i)? now.mirrorCnt : now.mirrorCnt+1;

                if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
                if(map[nx][ny][i]==0 || map[nx][ny][i]>nMirrorCnt){
                    map[nx][ny][i]=nMirrorCnt;
                    pq.add(new Point(nx,ny,i,nMirrorCnt));
                }
            }
        }

        return result;
    }
}