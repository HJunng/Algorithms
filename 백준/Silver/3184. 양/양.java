import java.io.*;

public class Main {
    static private int r,c;
    static private int sheepCnt, wolfCnt;
    static private char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        map = new char[r][c];
        for(int i=0;i<r;i++){
            map[i] = br.readLine().toCharArray();
        }

        int allSheep = 0;
        int allWolf = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]!='#'){
                    sheepCnt = wolfCnt = 0;
                    dfs(i,j);

                    if(sheepCnt > wolfCnt)
                        allSheep += sheepCnt;
                    else
                        allWolf += wolfCnt;
                }
            }
        }

        System.out.println(allSheep+" "+allWolf);
    }
    private static void dfs(int x, int y){

        if(map[x][y]=='o') sheepCnt++;
        else if(map[x][y]=='v') wolfCnt++;

        map[x][y] = '#'; // 방문처리

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int dir=0;dir<4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0 || nx>=r || ny<0 || ny>=c) continue;

            if(map[nx][ny]!='#') dfs(nx,ny);
        }
    }
}
