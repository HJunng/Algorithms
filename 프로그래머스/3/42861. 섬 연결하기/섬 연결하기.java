import java.util.*;
class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[2]-o2[2];
            }
        });
        
        parent = new int[n];
        
        for(int i=0;i<n;i++)
            parent[i]=i; 
        
        for(int[] edge:costs){
            
            int fromParent = findParent(edge[0]);
            int toParent = findParent(edge[1]);
            
            
            if(fromParent==toParent) continue;
            
            answer+=edge[2];
            
            
            parent[toParent] = fromParent;
        }
        
        return answer;
    }
    
    private int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node] = findParent(parent[node]);
    }
}