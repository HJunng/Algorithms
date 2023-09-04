package DFS_BFS;

import java.util.*;
public class Lv2_광물캐기 {
    int minFitague=Integer.MAX_VALUE;//최소 피로도

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public int solution(int[] picks, String[] minerals) {
        
        int pickCnt = Arrays.stream(picks).sum();//곡괭이 개수
        //5개 광물씩 잘랐을 때 몇 묶음의 광물이 있는지 와 비교해서 더 작은 걸로 선택
        int n = Math.min(pickCnt,(minerals.length)/5);
        
        //5개의 광물 당 -> 다이아 몇개, 철 몇 개, 돌 몇개 가지고 있는지
        int[][] mins = new int[n][3];
        for(int i=0;i<minerals.length && i<5*n;i++){
            if(minerals[i].equals("diamond")) mins[i/5][0]++;
            else if(minerals[i].equals("iron")) mins[i/5][1]++;
            else mins[i/5][2]++;
        }
        
        dfs(mins,picks,0,0);
        
        return minFitague;
    }
    //mins:광물 5개씩 묶음 별 각 광물 개수 / picks:곡괭이 개수 / depth:몇번째 묶음 / 현재 피로도 
    void dfs(int[][] mins, int[] picks, int depth, int fitague){
        
        if(depth==mins.length){//광물 끝까지 다 조사하면 끝냄.
            if(fitague<minFitague) minFitague=fitague;
            return;
        }
        
        //곡괭이는 다이아(0) -> 철(1) -> 돌(2) 순
        for(int i=0;i<picks.length;i++){
            if(picks[i]==0) continue;// i곡괭이가 없으면 다음 곡괭이로 넘어감.
            
            picks[i]--;
            dfs(mins,picks,depth+1,fitague+cntFitague(mins[depth],i));
            picks[i]++;
        }
    }
    
    //5개 광물 묶음을 pick곡갱이로 캘 때 피로도
    int cntFitague(int[] min5, int pick){
        int fitague=0;
        
        //0:다이아, 1:철, 2:돌
        for(int i=0;i<min5.length;i++){
            if(pick-i<=0) fitague+=min5[i]*1;//곡괭이가 광물보다 세거나 같을때
            else if(pick-i==1) fitague+=min5[i]*5;//곡괭이가 광물보다 1 약할때
            else fitague+=min5[i]*25;//곡괭이가 광물보다 2 약할 때 -> 돌 곡괭이로 다이아 캐려고 할 때
        }
        
        return fitague;
    }
}
