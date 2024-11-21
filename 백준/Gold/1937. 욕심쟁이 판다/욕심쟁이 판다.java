import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        String[] s;

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                list.add(new int[]{arr[i][j], i, j});
            }
        }

        Collections.sort(list, (a,b)->a[0]-b[0]);

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int max = 1;
        for(int[] num : list) {
            int x = num[1];
            int y = num[2];

            int closeMax = 0;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isInRange(nx,ny) && arr[x][y]>arr[nx][ny]) {
                    closeMax = Math.max(closeMax,dp[nx][ny]);
                }
            }
            dp[x][y] = closeMax+1;
            max = Math.max(max,dp[x][y]);
        }

        System.out.println(max);
    }
    static boolean isInRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}