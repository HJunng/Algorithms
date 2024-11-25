class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 100_000;
        while(left<=right) {
            int mid = (left+right)/2;
            
            // limit 안에 문제를 모두 풀 수 있을 때 시간 줄이기.
            if(inLimit(diffs, times, limit, mid)) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return answer;
    }
    boolean inLimit(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        
        for(int i=0;i<diffs.length;i++){
            if(level >= diffs[i]) {
                totalTime += times[i];
            } else {
                totalTime += (times[i-1]+times[i])*(diffs[i]-level) + times[i];
            }
        }
        
        if(totalTime<=limit) return true;
        else return false;
    }
}