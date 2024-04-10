import java.io.*;
import java.util.*;

public class Main {
    static int[][] sqare;
    static int m,n;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]); // 작은 직사각형 좌표 개수

        sqare = new int[m][n];

        for(int i=0;i<k;i++){
            s = br.readLine().split(" ");

            int bottomLeftX = Integer.parseInt(s[0]);
            int bottomLeftY = Integer.parseInt(s[1]);
            int topRightX = Integer.parseInt(s[2]);
            int topRightY = Integer.parseInt(s[3]);

            for(int y = bottomLeftY; y<topRightY;y++){
                for(int x = bottomLeftX; x<topRightX; x++){
                    sqare[y][x] = -1; // 작은 직사각형
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(sqare[i][j]==0){
                    cnt = 0;
                    dfs(i,j);
                    result.add(cnt);
                }
            }
        }
        Collections.sort(result);
        
        System.out.println(result.size());
        for(int c : result) System.out.print(c+" ");
    }
    private static void dfs(int i, int j){

        sqare[i][j] = 1; // 방문처리
        cnt++;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int dir=0;dir<4;dir++){
            int ni = i+dx[dir];
            int nj = j+dy[dir];

            if(ni>=0 && ni<m && nj>=0 && nj<n && sqare[ni][nj]==0){
                dfs(ni,nj);
            }
        }
    }
}
