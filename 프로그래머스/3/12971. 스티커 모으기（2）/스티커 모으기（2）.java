class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int len = sticker.length;
        int[] dpFirst = new int[len];
        int[] dpLast = new int[len];
        
        dpFirst[0] = sticker[0];
        if(len>=2) dpFirst[1] = sticker[0];
        if(len>=2) dpLast[1] = sticker[1];
        
        for(int i=2;i<len-1;i++){
            dpFirst[i] = Math.max(dpFirst[i-2]+sticker[i], dpFirst[i-1]);
            dpLast[i] = Math.max(dpLast[i-2]+sticker[i], dpLast[i-1]);
            
        }
        
        if(len>=3) dpLast[len-1] = Math.max(dpLast[len-3]+sticker[len-1], dpLast[len-2]);
        if(len>=2) dpFirst[len-1] = dpFirst[len-2];
        
        answer = Math.max(dpFirst[len-1], dpLast[len-1]);

        return answer;
    }
}