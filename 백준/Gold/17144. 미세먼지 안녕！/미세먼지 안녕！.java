import java.io.*;
import java.util.*;

public class Main {
    static int r,c;

    static int[][] board;
    static Queue<int[]> munji;
    static int[] cleaner;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        int t = Integer.parseInt(s[2]); //t초 후의 미세먼지 양

        board = new int[r][c];
        munji = new LinkedList<>();
        cleaner = new int[2]; // clear 좌표
        Arrays.fill(cleaner,-1); //초기화

        for(int i=0;i<r;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<c;j++){
                board[i][j] = Integer.parseInt(s[j]);

                if(board[i][j]>0) munji.add(new int[]{i,j,board[i][j]}); // 먼지 위치 queue에 저장.

                // cleaner 위치 저장
                if(board[i][j]==-1 && cleaner[0]==-1){
                    cleaner[0] = i;
                    cleaner[1] = i+1;
                }
            }
        }

        for(int i=0;i<t;i++){
            // 1. 미세먼지 확산
            munjiSpread();

            // 2. 공기청정기 바람
            operateCleaner();
        }

        int result = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]>0){
                    result += board[i][j];
                }
            }
        }
        System.out.println(result);

    }
    static void munjiSpread(){

        int[][] spreadPlus = new int[r][c]; // 확산될 먼지 양.
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        // 미세먼지 확산
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // 미세먼지가 확산될 수 있는 칸이면
                if(board[i][j]/5>0){
                    int spreadSum = 0;
                    int amount = board[i][j] / 5;

                    for(int d=0;d<4;d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];

                        // 범위를 벗어나지 않고, 공기청정기 자리가 아니면 확산 가능.
                        if(nx>=0 && nx<r && ny>=0 && ny<c && board[nx][ny]!=-1){
                            spreadPlus[nx][ny] += amount;
                            spreadSum += amount;
                        }
                    }
                    board[i][j] -= spreadSum;
                }
            }
        }

        // 미세먼지 확산 반영
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                board[i][j] += spreadPlus[i][j];
            }
        }
    }

    static void operateCleaner(){

        // 위쪽 공기청정기 -> 반시계방향
        for (int i = cleaner[0] - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }
        for (int j = 0; j < c - 1; j++) {
            board[0][j] = board[0][j + 1];
        }
        for (int i = 0; i < cleaner[0]; i++) {
            board[i][c - 1] = board[i + 1][c - 1];
        }
        for (int j = c - 1; j > 1; j--) {
            board[cleaner[0]][j] = board[cleaner[0]][j - 1];
        }
        board[cleaner[0]][1] = 0; // 클리너에서 밀려나온 부분

        // 아래쪽 공기청정기 -> 시계방향
        for (int i = cleaner[1] + 1; i < r - 1; i++) {
            board[i][0] = board[i + 1][0];
        }
        for (int j = 0; j < c - 1; j++) {
            board[r - 1][j] = board[r - 1][j + 1];
        }
        for (int i = r - 1; i > cleaner[1]; i--) {
            board[i][c - 1] = board[i - 1][c - 1];
        }
        for (int j = c - 1; j > 1; j--) {
            board[cleaner[1]][j] = board[cleaner[1]][j - 1];
        }
        board[cleaner[1]][1] = 0;
    }
}
