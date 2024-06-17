class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        // s를 n개의 자연수로 나눌 수 없으면 -1 리턴
        if(s/n==0) return new int[]{-1};
        
        for(int i=0;i<n;i++){
            answer[i] = s/(n-i);
            s -= answer[i];
        }
        
        return answer;
    }
}