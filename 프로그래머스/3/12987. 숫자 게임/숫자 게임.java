import java.util.*;

class Solution {
    List<Integer> bList;
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        bList = new ArrayList<>();
        for(int i : B){
            bList.add(i);
        }
        
        Collections.sort(bList);
        
        for(int a : A){
            int b = binarySearch(a);
            
            if(b>a) answer++;
        }
        
        return answer;
    }
    int binarySearch(int n){
        
        int left = 0;
        int right = bList.size()-1;
        int idx = 0;
        
        while(left<=right){
            
            int half = (left+right)/2;
            
            // A 팀 점수보다 큰 점수 중에 가장 작은 거.
            if(bList.get(half)>n){
                idx = half;
                right = half-1;
            } else {
                left = half + 1;
            }
        }
        
        int result = bList.get(idx);
        bList.remove(idx);
        return result;
    }
}