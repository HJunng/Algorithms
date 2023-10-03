class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                int befMax=0;
                if(j==0){
                    befMax=triangle[i-1][j];
                }else if(j==triangle[i].length-1){
                    befMax=triangle[i-1][j-1];
                }else{
                    befMax = Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
                triangle[i][j]+=befMax;
                
                if(i==triangle.length-1)
                    answer=Math.max(answer,triangle[i][j]);
            }
        }
        
        
        return answer;
    }
}