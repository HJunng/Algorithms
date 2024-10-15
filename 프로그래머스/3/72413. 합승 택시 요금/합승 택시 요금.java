import java.util.*;

class Solution {
    int[][] minCost;
    int MAX = 200_000_001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer;
        
        minCost = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(minCost[i],MAX);
            minCost[i][i]=0;
        }
        
        for(int[] fare : fares){ // 요금 정보 map에 저장.
            minCost[fare[0]][fare[1]] = fare[2];
            minCost[fare[1]][fare[0]] = fare[2]; 
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    // if(minCost[i][k]==MAX || minCost[k][j]==MAX) continue;
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k]+minCost[k][j]);
                }
            }
        }
        
        answer = minCost[s][a]+minCost[s][b];
        
        for(int i=1;i<=n;i++){
            // if(s==i) continue;
            answer = Math.min(answer, minCost[s][i]+minCost[i][a]+minCost[i][b]);
        }
        
        
        return answer;
    }
}