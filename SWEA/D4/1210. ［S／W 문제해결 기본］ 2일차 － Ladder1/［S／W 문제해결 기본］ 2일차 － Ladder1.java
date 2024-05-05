import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static String[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=10;t++){
            br.readLine();
            map = new String[100][100];

            for(int i=0;i<100;i++){
                map[i] = br.readLine().split(" ");
            }

            int startY=0;
            for(int i=0;i<100;i++){
                if(map[99][i].equals("2")){
                    startY = i; break;
                }
            }

            sb.append("#"+t+" "+findStart(99,startY)+"\n");
        }
        System.out.println(sb);
    }
    private static int findStart(int x, int y){
        if(x==0) return y;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        map[x][y]="0";

        int nextX=x;
        int nextY=y;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny<0 || nx>=100 || ny>=100) continue;
            if(map[nx][ny].equals("1")) {
                nextX = nx;
                nextY = ny;
            }
        }

        return findStart(nextX, nextY);
    }
}
