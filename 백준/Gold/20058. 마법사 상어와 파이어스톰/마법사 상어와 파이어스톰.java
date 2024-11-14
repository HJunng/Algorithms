import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, Q;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count;
    static int iceCount;
    static int totalIce;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]); // 격자 칸 : 2^N
        Q = Integer.parseInt(s[1]); // 마법 횟수

        map = new int[(int)Math.pow(2,N)][(int)Math.pow(2,N)];
        for(int i=0;i<(int)Math.pow(2,N);i++){
            s = br.readLine().split(" ");
            for(int j=0;j<(int)Math.pow(2,N);j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");
        for(String step : s) {
            int L = Integer.parseInt(step); // 마법 시전 단계 L
            // 회전
            rotate(L);

            // 얼음 줄이기
            reduceIce();
        }

//        for(int i=0;i<(int)Math.pow(2,N);i++){
//            for(int j=0;j<(int)Math.pow(2,N);j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        totalIce = 0;
        int maxIce = countMaxIceBlock();
        System.out.println(totalIce);
        System.out.println(maxIce);
    }
    static void rotate(int L) {
        int piece = (int) (Math.pow(2,N-L)); // 정사각형 개수
        int len = (int) Math.pow(2,L); // 정사각형 한 변의 길이

//        System.out.println(piece);
        for(int i=0;i<piece;i++){
            for(int j=0;j<piece;j++) {
                rotate90(L, new int[]{i*len, j*len});
            }
        }
    }
    static void rotate90(int L, int[] start) {
        // start : 왼쪽 위
        // end : 오른쪽 아래

        int len = (int)Math.pow(2,L);
        int[][] temp = new int[len][len];

        // 90도 돌린 걸 temp에 저장
        // `map`을 시계 방향으로 90도 회전해서 `temp`에 저장
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[j][len - 1 - i] = map[start[0] + i][start[1] + j];
            }
        }

        // `temp`를 다시 `map`에 덮어쓰기
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[start[0] + i][start[1] + j] = temp[i][j];
            }
        }
    }
    static void reduceIce(){

        int len = (int)Math.pow(2,N);

        int[][] temp = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){

                int iceCount = 0;
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(inRange(nx,ny) && map[nx][ny]>0)
                        iceCount++;
                }

                if(map[i][j]>0 && iceCount<3) {
                    temp[i][j] = map[i][j]-1;
                } else {
                    temp[i][j] = map[i][j];
                }
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                map[i][j] = temp[i][j];
            }
        }
    }
    static int countMaxIceBlock() {
        int len = (int)Math.pow(2,N);
        visit = new boolean[len][len];

        int maxCount = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                count = 0;
                iceCount = 0;
                if(map[i][j]>0 && !visit[i][j]) {
                    dfs(i,j);
                }
                maxCount = Math.max(maxCount,count);
                totalIce += iceCount;
            }
        }
        return maxCount;
    }
    static void dfs(int x, int y){
        visit[x][y] = true;
        count ++;
        iceCount += map[x][y];

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx,ny) && map[nx][ny]>0 && !visit[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
    static boolean inRange(int x, int y){
        int max = (int)Math.pow(2,N);

        if(x>=0 && x<max && y>=0 && y<max) return true;
        else return false;
    }
}