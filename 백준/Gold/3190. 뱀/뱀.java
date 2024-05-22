import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int[][] map; // 사과 : 1
    static int N;
    static String[][] turn; // 방향 전환 횟수
    static int turnIdx;
    static Deque<int[]> snake;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0;i<K;i++){
            s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;

            map[x][y] = 1;
        }

        int turnCnt = Integer.parseInt(br.readLine());
        turn = new String[turnCnt][2];
        for(int i=0;i<turnCnt;i++){
            turn[i] = br.readLine().split(" ");
        }

        turnIdx = 0;
        snake = new LinkedList<>();
        snake.add(new int[]{0,0}); // 뱀의 머리부터 차근차근 넣기.
        System.out.println(move(0,0,0,0));
    }
    static int move(int x, int y, int dir, int curTime){
        int[] dx = {0,1,0,-1}; // 오-아-왼-위
        int[] dy = {1,0,-1,0};

        // curTime에 도착했는데, 회전해야하면 회전함.
        if(curTime == Integer.parseInt(turn[turnIdx][0])){
            if(turn[turnIdx][1].equals("D")){ // 오른쪽 회전
                dir = (dir+1)%4;
            } else { // 왼쪽 회전
                dir = (dir+3)%4;
            }
            if(turnIdx+1<turn.length) turnIdx++;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]==-1) return curTime+1;

        if(map[nx][ny]==1) { // 사과
            map[nx][ny] = -1;
            snake.addFirst(new int[]{nx,ny});
            // 사과를 먹으면 길이가 늘어남으로, 꼬리 안 자름.
        } else {
            map[nx][ny] = -1;
            snake.addFirst(new int[]{nx,ny});
            int[] tail = snake.pollLast();
            map[tail[0]][tail[1]]=0; //꼬리 자르기
        }

        return move(nx,ny,dir,curTime+1);
    }
}