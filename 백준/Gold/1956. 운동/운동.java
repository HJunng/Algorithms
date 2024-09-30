import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        v = Integer.parseInt(s[0]); // 마을
        e = Integer.parseInt(s[1]); // 다리

        int[][] map = new int[v+1][v+1];
        for(int i=1;i<=v;i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        
        for(int i=0;i<e;i++){
            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            map[a][b] = c;
        }

        for(int i=1;i<=v;i++){ // 출발 a
            for(int j=1;j<=v;j++){ // 도착 b
                if(i==j) {
                    map[i][j] = 0; continue;
                }

                for(int k=1;k<=v;k++){ // 중간지점
                    if(k==i || k==j) continue;

                    if(map[i][k]==Integer.MAX_VALUE || map[k][j]==Integer.MAX_VALUE) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(i==j) continue;

                if(map[i][j]==Integer.MAX_VALUE || map[j][i]==Integer.MAX_VALUE) continue;
                minCost = Math.min(minCost, map[i][j]+map[j][i]);
            }
        }
        if(minCost == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minCost);
    }
}