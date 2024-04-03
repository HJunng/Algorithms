import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static String[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new String[5][5];
        for(int i=0;i<5;i++){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<5;j++) board[i][j] = s[j];
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(i,j,"");
            }
        }

        System.out.println(set.size());
    }
    private static void dfs(int x, int y, String str){

        if(str.length()==6){
            set.add(Integer.parseInt(str));
            return;
        }

        str += board[x][y];

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<5 && ny>=0 && ny<5)
                dfs(nx,ny,str);
        }
    }
}