import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int board[][] = new int[n][m];

        ArrayList<int[]> queen = new ArrayList<>();
        ArrayList<int[]> knight = new ArrayList<>();
        // 폰은 따로 이동하지 않는다고 생각함 -> 어차피 우리편 잡을 수 없음.

        int cnt = n*m;

        for(int i=0;i<3;i++){ // queen, knight, pawn 위치 저장
            s = br.readLine().split(" ");

            for(int j=0;j<s.length/2;j++){
                int x = Integer.parseInt(s[1+2*j])-1;
                int y = Integer.parseInt(s[2+2*j])-1;

                board[x][y] = 1; // 상대편 말 있는 곳 -> 안전하지 않다
                cnt--; // 안전하지 않은 곳

                if(i==0) queen.add(new int[]{x,y});
                else if(i==1) knight.add(new int[]{x,y});
            }
        }

        int[] dxQueen = {1,1,1,0,0,-1,-1,-1};
        int[] dyQueen = {1,0,-1,1,-1,1,0,-1};

        int[] dxKnight = {2,2,1,1,-1,-1,-2,-2};
        int[] dyKnight = {1,-1,2,-2,2,-2,1,-1};

        for(int[] q : queen){
            for(int dir=0;dir<8;dir++){
                int nx = q[0]+dxQueen[dir];
                int ny = q[1]+dyQueen[dir];
                while(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]!=1){ // 퀸은 장애물 있으면 안됨.
                    if(board[nx][ny]==0) cnt--; // queen은 장애물이 있지 않는 한 2인 곳도 갈 수 있기 때문에.
                    board[nx][ny] = 2; // 안전하지 않은 위치
                    nx += dxQueen[dir]; // 위치 이동
                    ny += dyQueen[dir];
                }
            }
        }

        for(int[] k : knight){
            for (int dir=0;dir<8;dir++){
                int nx = k[0]+dxKnight[dir];
                int ny = k[1]+dyKnight[dir];

                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0) {
                    board[nx][ny] = 2;
                    cnt--;
                }
            }
        }

//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }

        System.out.println(cnt);
    }
}