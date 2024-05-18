class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] includeFirst = new int[money.length];
        int[] includeLast = new int[money.length];
        
        includeFirst[0] += money[0];
        
        for(int i=1;i<money.length;i++){
            if(i==1){
                includeFirst[1] = Math.max(includeFirst[0],money[1]);
                includeLast[1] = Math.max(includeLast[0],money[1]);
            } else {
                includeFirst[i] = Math.max(includeFirst[i-2]+money[i], includeFirst[i-1]);
                includeLast[i] = Math.max(includeLast[i-2]+money[i], includeLast[i-1]);
            }
        }
        
        int n = money.length;
        return Math.max(includeFirst[n-2], includeLast[n-1]);
    }
}