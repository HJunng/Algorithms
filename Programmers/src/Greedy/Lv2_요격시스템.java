package Greedy;

import java.util.*;
public class Lv2_요격시스템 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[][] targets) {
        
        //끝나는 시간 오름차순으로 정렬
        Arrays.sort(targets,(a,b)->a[1]-b[1]);
        
        int answer=0;//요격 미사일 사용 개수
        double now=-1;//이전 요격 미사일 위치
        
        for(int i=0;i<targets.length;i++){
            if(targets[i][0]>now){//현재 미사일 시작이 이전 요격 위치보다 뒤에 있을 경우 -> 이전 요격 미사일로 현재 폭격미사일을 맞출 수 없는 경우
                now=targets[i][1]-0.5;//(현재 미사일 끝나는 지점)에 요격 미사일 위치
                answer++;//요격 미사일 1개 추가
            }
        }
        
        return answer;
    }
}
