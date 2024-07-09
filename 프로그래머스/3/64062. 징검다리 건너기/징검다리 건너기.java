import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0;
        int right = 200000000;
        
        while(left<=right){
            int half = (left+right)/2;
            
            // 현재 인원이 모두 건널 수 있는 경우
            if(isPoss(stones, half, k)){ 
                answer = half;
                left = half+1;
            } else {
                right = half-1;
            }
        }
        return answer;
    }
    boolean isPoss(int[] stones, int persons, int k){
        
        int cnt = 0; // 연속된 0 cnt
        for(int i=0;i<stones.length;i++){
            if(stones[i]<persons) cnt++;
            else cnt=0;
            
            if(cnt>=k) return false;
        }
        
        return true;
    }
}