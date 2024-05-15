import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int N;
    static int minCost;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s;

        minCost =Integer.MAX_VALUE;
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0,0);
        System.out.println(minCost);
    }
    static void dfs(int idx, int sum){
        if(idx==3){ // 꽃 3개를 다 심은 경우
            minCost = Math.min(minCost, sum);
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(isPossible(i,j)){
                    int cost = plant(i,j);
                    dfs(idx+1, sum+cost);
                    unplant(i,j);
                }
            }
        }
    }
    static boolean isPossible(int x, int y){
        // 범위를 벗어나거나, 이전의 꽃이랑 겹치면 -1리턴
        if(x<1 || y<1 || x>=N-1 || y>=N-1 ||
                visit[x][y] || visit[x-1][y] || visit[x][y-1] || visit[x+1][y] || visit[x][y+1]){
            return false;
        }
        return true;
    }
    static int plant(int x, int y){
        visit[x][y]=true; visit[x-1][y]=true; visit[x][y-1]=true;
        visit[x+1][y]=true; visit[x][y+1]=true;

        return map[x][y]+map[x-1][y]+map[x][y-1]+map[x+1][y]+map[x][y+1];
    }
    static void unplant(int x, int y){
        visit[x][y]=false; visit[x-1][y]=false; visit[x][y-1]=false;
        visit[x+1][y]=false; visit[x][y+1]=false;
    }
}