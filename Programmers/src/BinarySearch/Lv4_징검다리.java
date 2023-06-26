package BinarySearch;

import java.util.Arrays;
public class Lv4_징검다리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int left=0;//출발지점
        int right=distance;//도착지점
        
        Arrays.sort(rocks);// 돌 사이 거리를 알기 위해 정렬.
        
        while(left<=right){
            
            int half=(left+right)/2;
            
            
            int removeRock=0; //돌 사이 거리 최소가 half라고 할 때 남는 돌 개수
            
            int befRock=0;//이전 돌 위치
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-befRock>=half) befRock=rocks[i];
                else removeRock++; //최소거리보다 작으면 돌 삭제 개수 추가
            }
            if(distance-befRock<half) removeRock++; // 마지막 돌과 도착 지점도 해줘야함.!!
            
            
            //System.out.println(left+" "+right+" "+half+" : "+rockNum+" "+answer);
            
            if(removeRock>n){//바위를 더 많이 제거했을 때
                right=half-1;
            }else{
                answer=half;
                left=half+1;
            }
        }
        
        return answer;
    }
}
