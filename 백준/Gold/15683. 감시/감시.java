import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visit; // 몇 번째 cctv가 방문했는지 넣기.
    static List<CCTV> cctvList;
    static int minVisit;

    static class CCTV{
        int x,y,type,num;
        // type : 1~5번 cctv, num : 몇 번째 cctv인지
        public CCTV(int x,int y,int type,int num){
            this.x = x; this.y = y; this.type = type; this.num = num;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]); // 세로
        M = Integer.parseInt(s[1]); // 가로

        map = new int[N][M];
        cctvList = new ArrayList<>();

        int cctvCnt=1;
        for(int i=0;i<N;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(s[j]);
                // cctv 위치, 번호 를 리스트에 넣기.
                if(map[i][j]>=1 && map[i][j]<=5)
                    cctvList.add(new CCTV(i,j,map[i][j], cctvCnt++));
            }
        }

        visit = new int[N][M];
        minVisit = N*M;
        dfs(0,cctvList.size());

        System.out.println(minVisit);
    }
    static void dfs(int depth, int endDepth){ // O(8) -> 최대 8개의 cctv
        if(depth==endDepth){
            minVisit = Math.min(minVisit,unVisitCnt());
            return;
        }

        // 현재 cctv
        CCTV cctv = cctvList.get(depth);

        switch (cctv.type){
            case 1:
                for(int i=0;i<4;i++){
                    visitMap(cctv.x, cctv.y, i, cctv.num);
                    dfs(depth+1, endDepth);
                    unVisitMap(cctv.x, cctv.y, i, cctv.num);
                }
                break;
            case 2 :
                // 상하
                visitMap(cctv.x, cctv.y, 0, cctv.num);
                visitMap(cctv.x, cctv.y, 1, cctv.num);
                dfs(depth+1, endDepth);
                unVisitMap(cctv.x, cctv.y, 1, cctv.num);
                unVisitMap(cctv.x, cctv.y, 0, cctv.num);

                // 좌우
                visitMap(cctv.x, cctv.y, 2, cctv.num);
                visitMap(cctv.x, cctv.y, 3, cctv.num);
                dfs(depth+1, endDepth);
                unVisitMap(cctv.x, cctv.y, 3, cctv.num);
                unVisitMap(cctv.x, cctv.y, 2, cctv.num);
                break;

            case 3 :
                for(int i=0;i<2;i++){
                    for(int j=2;j<4;j++){
                        visitMap(cctv.x, cctv.y, i, cctv.num);
                        visitMap(cctv.x, cctv.y, j, cctv.num);
                        dfs(depth+1, endDepth);
                        unVisitMap(cctv.x, cctv.y, i, cctv.num);
                        unVisitMap(cctv.x, cctv.y, j, cctv.num);
                    }
                }
                break;
            case 4 :
                for(int i=0;i<2;i++){
                    for(int j=i+1;j<3;j++){
                        for(int k=j+1;k<4;k++){
                            visitMap(cctv.x, cctv.y, i, cctv.num);
                            visitMap(cctv.x, cctv.y, j, cctv.num);
                            visitMap(cctv.x, cctv.y, k, cctv.num);
                            dfs(depth+1, endDepth);
                            unVisitMap(cctv.x, cctv.y, i, cctv.num);
                            unVisitMap(cctv.x, cctv.y, j, cctv.num);
                            unVisitMap(cctv.x, cctv.y, k, cctv.num);
                        }
                    }
                }
                break;
            case 5 :
                visitMap(cctv.x, cctv.y, 0, cctv.num);
                visitMap(cctv.x, cctv.y, 1, cctv.num);
                visitMap(cctv.x, cctv.y, 2, cctv.num);
                visitMap(cctv.x, cctv.y, 3, cctv.num);
                dfs(depth+1, endDepth);
                unVisitMap(cctv.x, cctv.y, 3, cctv.num);
                unVisitMap(cctv.x, cctv.y, 2, cctv.num);
                unVisitMap(cctv.x, cctv.y, 1, cctv.num);
                unVisitMap(cctv.x, cctv.y, 0, cctv.num);
                break;
            default: break;
        }
    }
    static void visitMap(int x, int y, int dir, int cctvNum){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int nx = x;
        int ny = y;
        for(int i=1;i<=8;i++){
            nx += dx[dir];
            ny += dy[dir];

            if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==6) break;
            if(map[nx][ny]>=1 && map[nx][ny]<=5) continue; // 다른 cctv는 통과
            if(visit[nx][ny]>=1 && visit[nx][ny]<=8) continue; // 다른 cctv가 먼저 방문한 곳이면 pass

            visit[nx][ny] = cctvNum;
        }
    }
    static void unVisitMap(int x, int y, int dir, int cctvNum){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int nx = x;
        int ny = y;
        for(int i=1;i<=8;i++){
            nx += dx[dir];
            ny += dy[dir];

            if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==6) break;
            if(map[nx][ny]>=1 && map[nx][ny]<=5) continue; // 다른 cctv는 통과
            if (visit[nx][ny]==cctvNum) visit[nx][ny] = 0;
        }
    }
    static int unVisitCnt(){
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0 && visit[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    static void printVisit(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(visit[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}