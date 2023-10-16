import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        Map<Integer,ArrayList<Integer>> coms = new HashMap<>();
        for(int i=0;i<n;i++) coms.put(i,new ArrayList<>());
        
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(i==j) continue;
                
                if(computers[i][j]==1){
                    coms.get(i).add(j);
                }
            }
        }
        
        visited = new boolean[n];
        
        int answer=0; // 네트워크 개수
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                dfs(i,n,coms);
            }
        }
        
        
        return answer;
    }
    void dfs(int now, int length, Map<Integer,ArrayList<Integer>> coms){
        visited[now]=true;
        
        for(int next : coms.get(now)){
            if(!visited[next]){
                dfs(next,length,coms);
            }
        }
    }
}