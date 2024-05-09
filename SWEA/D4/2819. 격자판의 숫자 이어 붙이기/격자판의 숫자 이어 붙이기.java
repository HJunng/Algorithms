import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static Set<String> set;
    static String[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());
        int n=4;

        for(int tc=1;tc<=T;tc++){
            map = new String[n][n];
            set = new HashSet<>();
            for(int i=0;i<n;i++){
                s = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    map[i][j] = s[j];
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dfs(i,j,map[i][j]);
                }
            }

            sb.append("#"+tc+" "+set.size()+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y, String str){
        if(str.length()==7){
            set.add(str);
            return;
        }
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<4 && ny>=0 && ny<4){
                dfs(nx,ny,str+map[nx][ny]);
            }
        }
    }
}
