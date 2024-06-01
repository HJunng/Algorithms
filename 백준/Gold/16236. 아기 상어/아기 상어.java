import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Shark{
        int size,eatCnt;
        Shark(int size, int eatCnt){
            this.size = size; this.eatCnt = eatCnt;
        }
        void eat(){
            this.eatCnt+=1;
            if(this.eatCnt==this.size){ // 자신의 사이즈만큼 물고기를 먹으면, 사이즈 증가.
                this.size++;
                this.eatCnt=0;
            }
        }
    }
    static int[][] map;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s;

        map = new int[n][n];
        int[] sharkLoc = new int[2];
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(s[j]);

                if(map[i][j]==9){ // 상어는 따로 저장.
                    sharkLoc[0]=i;
                    sharkLoc[1]=j;
                    map[i][j]=0;
                }
            }
        }

        Shark shark = new Shark(2,0); // 처음엔 사이즈 2.
        int time = 0;
        while(true){
//            System.out.println(Arrays.toString(sharkLoc));
            int[] smallFish = findSmallFish(sharkLoc[0],sharkLoc[1],shark);

            // 잡아먹을 수 있는 물고기 없음.
            if(smallFish[0]==n) break;

            shark.eat(); // 먹음
            map[smallFish[0]][smallFish[1]]=0;
            time += smallFish[2]; // 이동 시간 더하기.

            // 상어위치 갱신
            sharkLoc[0]=smallFish[0];
            sharkLoc[1]=smallFish[1];
        }
        System.out.println(time);
    }
    static int[] findSmallFish(int x, int y, Shark shark){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};

        boolean[][] visit = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,0});
        visit[x][y]=true;

        int[] smallFish = {n,n,n*n+1}; // 나올 수 없는 위치, 거리

        while(!q.isEmpty()){
            int[] now = q.poll();
//            System.out.println(now[0]+" "+now[1]+" "+now[2]);

            // 기존의 찾은 최소거리보다 커지면 종료.
            if(now[2]>smallFish[2]) break;

            // 먹을 수 있는 물고기가 있는 경우. + (같은 거리이면, 위, 왼쪽 순으로 더 작은거)
            if(0<map[now[0]][now[1]] && map[now[0]][now[1]]<shark.size){
                if(now[0]<smallFish[0]){
                    smallFish[0]=now[0];
                    smallFish[1]=now[1];
                    smallFish[2]=now[2];
                }
                else if(now[0]==smallFish[0] && now[1]<smallFish[1]){
                    smallFish[0]=now[0];
                    smallFish[1]=now[1];
                    smallFish[2]=now[2];
                }
            }

            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || visit[nx][ny]) continue;
                if(map[nx][ny]<=shark.size){ // 물고기크기 <= 상어크기 : 지나갈 수 있음.
                    q.add(new int[]{nx,ny,now[2]+1});
                    visit[nx][ny]=true;
                }
            }
        }
        return smallFish;
    }
}