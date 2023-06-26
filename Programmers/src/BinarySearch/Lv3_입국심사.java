package BinarySearch;

import java.util.*;
public class Lv3_입국심사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public long solution(int n, int[] times) {
        long answer = 0;
        
        long min=0;
        
        Arrays.sort(times); 
        ////n과 times 모두 int형이므로 계산할 때 long형으로 바꿔줘야함.
        long max = (long) n*times[times.length-1]; //최악의 경우 -> 시간이 가장 오래 걸릴 때.
        
        while(min<=max){
            
            long half = (max+min)/2; //모든 사람이 검사받는데 걸리는 시간.
            System.out.println("("+min+","+max+") "+answer);
            
            //총 몇 명 처리하는지도 long형으로 해야함.max일 때 인원이 엄청 많을 수 있음.
            long total=0; //시간이 half라면 총 몇 명 처리할 수 있는지.
            for(int i=0;i<times.length;i++)
                total+=half/times[i]; //시간이 answer 만큼 지났을 때 검사받은 사람 수
            
            if(total<n) //n명 다 처리 못함 -> 시간 더 필요
                min = half+1;
            else{ //n명 이상 처리->시간 조금 줄여보기
                answer=half; //n명을 처리할 수 있는 최소한의 시간이니 answer값 저장해두기.
                max = half-1;
            }
        }
        
        return answer;
    }
}
