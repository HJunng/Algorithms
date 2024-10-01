import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] ladder;
    static int n, h;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]); // 세로선 개수
        int m = Integer.parseInt(s[1]); // 정해진 가로선 개수
        h = Integer.parseInt(s[2]); // 가로선 점선 개수

        ladder = new int[h][n];

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0])-1;
            int b = Integer.parseInt(s[1])-1;

            // 사다리 연결(a,b)->(a,b+1)로 연결됨.
            ladder[a][b]=1; // 1이면 오른쪽
            ladder[a][b+1]=2; // 2면 왼쪽
        }

        if(isCorrectWay()) System.out.println(0);
        else if(dfs(0,1)) System.out.println(1);
        else if(dfs(0,2)) System.out.println(2);
        else if(dfs(0,3)) System.out.println(3);
        else System.out.println(-1);
    }
    static boolean dfs(int depth, int maxDep){
        // 사다리 depth개를 사용해서 올바른 길이 되었는지 확인.
        if(depth==maxDep){
            if(isCorrectWay()) return true;
            return false;
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<n-1;j++){
                if(canInstallLadder(i,j)){
                    ladder[i][j]=1;
                    ladder[i][j+1]=2;
                    if(dfs(depth+1,maxDep)) {
                        return true;
                    }
                    ladder[i][j+1]=0;
                    ladder[i][j]=0;
                }
            }
        }
        return false;
    }
    static boolean canInstallLadder(int x, int y){
        if(ladder[x][y]==0 && ladder[x][y+1]==0){
            return true;
        }
        else return false;
    }
    // i->i로 잘 도착하는지 확인.
    static boolean isCorrectWay(){
        for(int i=0;i<n;i++){
            int now = i;
            for(int j=0;j<h;j++){
                if(ladder[j][now]==0) continue;
                else if(ladder[j][now]==1) now+=1;
                else now-=1;
            }
            if(now!=i) return false;
        }
        return true;
    }
}
