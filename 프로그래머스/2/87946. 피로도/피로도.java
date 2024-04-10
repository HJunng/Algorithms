import java.util.*;

class Solution {
    static int maxDG = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        visited = new boolean[dungeons.length];
        dfs(k,0,dungeons);
        
        
        return maxDG;
    }
    private void dfs(int k, int cnt, int[][] dg){
        maxDG = Math.max(maxDG, cnt);
        
        for(int i=0;i<dg.length;i++){
            // 방문 하기
            if(k>= dg[i][0] && !visited[i]){
                visited[i] = true;
                dfs(k-dg[i][1], cnt+1, dg);
                visited[i] = false;
            }
        }
        
    }
}