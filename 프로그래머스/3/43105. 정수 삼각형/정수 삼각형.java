import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                int left = (j==0)? 0 : triangle[i-1][j-1];
                int right = (j==triangle[i].length-1)? 0 : triangle[i-1][j];
                
                triangle[i][j] += Math.max(left, right);
            }
        }
        
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}