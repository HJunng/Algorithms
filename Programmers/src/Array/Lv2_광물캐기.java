package Array;

import java.util.*;

public class Lv2_광물캐기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int cntPick = Arrays.stream(picks).sum();//곡괭이 개수
        //5개 광물씩 잘랐을 때 몇 묶음의 광물이 있는지 와 비교해서 더 작은 걸로 선택
        int n = Math.min(cntPick,(minerals.length-1)/5+1);
        
        //5개의 광물 당 -> 다이아 몇개, 철 몇 개, 돌 몇개 가지고 있는지
        int[][] mins = new int[n][3];
        for(int i=0;i<minerals.length && i<5*n;i++){
            if(minerals[i].equals("diamond")) mins[i/5][0]++;
            else if(minerals[i].equals("iron")) mins[i/5][1]++;
            else mins[i/5][2]++;
        }
        
        //다이아 많은 순, 철 많은 순으로 정렬한, 광물 묶음 순서
        ArrayList<Integer> orders = getOrders(mins);
        
        for(int order : orders){
            if(picks[0]>0){
                answer+=cntFitague(mins[order],0);
                picks[0]--;
            }else if(picks[1]>0){
                answer+=cntFitague(mins[order],1);
                picks[1]--;
            }else{
                answer+=cntFitague(mins[order],2);
                picks[2]--;
            }
        }
        
        return answer;
    }
    //다이아 많은순, 철 많은 순으로 -> 광물 묶음 순서 반환.
    ArrayList<Integer> getOrders(int[][] mins){
        
        ArrayList<Integer> orders = new ArrayList<>();
        for(int i=0;i<mins.length;i++) orders.add(i);
        
        //다이아 많은 순, 철 많은 순으로 정렬
        Collections.sort(orders, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(mins[a][0]!=mins[b][0]) return mins[b][0]-mins[a][0];
                else return mins[b][1]-mins[a][1];
            }
        });
        
        return orders;
    }
    //곡괭이에 따른 피로도 게산
    int cntFitague(int[] minCount, int pick){
        int fitague=0;
        
        for(int i=0;i<minCount.length;i++){
            if(pick-i<=0) fitague+=minCount[i]*1;
            else if(pick-i==1) fitague+=minCount[i]*5;
            else fitague+=minCount[i]*25;
        }
        return fitague;
    }
}
