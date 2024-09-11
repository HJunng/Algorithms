import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Dice{
        int back, left, bottom, right, front, top;

        int getTop() { return this.top; }
        void setBottom(int mapNum) {this.bottom = mapNum; }
        int getBottom() { return this.bottom; }

        void moveEast(){
            // 동쪽으로 이동했을 때의 방향으로 변환
            int temp = top;
            top = left;
            left = bottom;
            bottom = right;
            right = temp;
        }
        void moveWest(){
            int temp = top;
            top = right;
            right = bottom;
            bottom = left;
            left = temp;
        }
        void moveSouth(){
            int temp = top;
            top = back;
            back = bottom;
            bottom = front;
            front = temp;
        }
        void moveNorth(){
            int temp = top;
            top = front;
            front = bottom;
            bottom = back;
            back = temp;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]); // 세로, 가로
        int m = Integer.parseInt(s[1]);

        int x = Integer.parseInt(s[2]); // 주사위 처음 위치
        int y = Integer.parseInt(s[3]);

        int k = Integer.parseInt(s[4]); // 명령 개수

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        Dice dice = new Dice();
        for(int i=0;i<k;i++){

            int dir = Integer.parseInt(s[i])-1;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 벗어나면 명령 무시.
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

            // 이동
            switch(dir){
                case 0 : dice.moveEast(); break;
                case 1 : dice.moveWest(); break;
                case 2 : dice.moveNorth(); break;
                case 3 : dice.moveSouth(); break;
                default: break;
            }

            // 이동한 칸의 숫자가 0일때, 0이 아닐 때
            if(map[nx][ny]==0) {
                map[nx][ny] = dice.getBottom();
            } else {
                dice.setBottom(map[nx][ny]);
                map[nx][ny] = 0;
            }

            // 주사위 윗면 출력하기
            System.out.println(dice.getTop());
            
            x = nx; y = ny; // 이동
        }
    }
}