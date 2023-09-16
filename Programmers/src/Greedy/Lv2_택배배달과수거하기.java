package Greedy;

public class Lv2_택배배달과수거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int idxDel=n-1;
        int idxPick = n-1;
        while((idxDel>0 || idxPick>0)){
            
            int startDeliver=-1; //배달 시작 위치
            int endDeliver=-1; //배달 도착 위치
            int cntDel=0;
            for(int i=idxDel;i>=0;i--){
                if(deliveries[i]>0 && i>startDeliver) startDeliver=i;
                
                if(deliveries[i]+cntDel<=cap){
                    cntDel+=deliveries[i];
                    deliveries[i]=0;
                    endDeliver=i;
                }else{
                    deliveries[i]-=cap-cntDel;
                    cntDel=cap;
                    endDeliver=i;
                    break;
                }
            }
            
            int startPick=-1;
            int endPick=-1;
            int cntPick=0;
            for(int i=idxPick;i>=0;i--){
                if(pickups[i]>0 && i>startPick) startPick=i;
                
                if(pickups[i]+cntPick<=cap){
                    cntPick+=pickups[i];
                    pickups[i]=0;
                    endPick=i;
                }else{
                    pickups[i]-=cap-cntPick;
                    cntPick=cap;
                    endPick=i;
                    break;
                }
            }
            
            answer+=startDeliver>startPick?(startDeliver+1)*2:(startPick+1)*2;
            idxDel=endDeliver;
            idxPick=endPick;
            
        }
        
        if(deliveries[0]>0 || pickups[0]>0)
            answer+=deliveries[0]>pickups[0]?((deliveries[0]-1)/cap+1)*2:((pickups[0]-1)/cap+1)*2;
        
        return answer;
    }
}
