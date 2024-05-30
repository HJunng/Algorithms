import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s;

        int[][] map = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i+1][j+1] = Integer.parseInt(s[j]);
            }
        }

        int[][][] pipe = new int[n+1][n+1][3]; //0:가로, 1:세로, 2:대각선
        pipe[1][2][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=2;j<=n;j++){
                if(map[i][j]==0){ // 왼쪽, 위에서 오는 거는 이동할 위치만 비어있으면 됨.
                    pipe[i][j][0] += pipe[i][j-1][0]+pipe[i][j-1][2];
                    pipe[i][j][1] += pipe[i-1][j][1]+pipe[i-1][j][2];
                }
                if(map[i][j]==0 && map[i-1][j]==0 && map[i][j-1]==0){ // 대각선
                    pipe[i][j][2] += pipe[i-1][j-1][0]+pipe[i-1][j-1][1]+pipe[i-1][j-1][2];
                }
            }
        }

        System.out.println(pipe[n][n][0]+pipe[n][n][1]+pipe[n][n][2]);
    }
}