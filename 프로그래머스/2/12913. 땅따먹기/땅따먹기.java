import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i=1;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                int temp = 0;
                for(int k=0;k<land[i].length;k++){
                    if(j==k) continue;
                    temp = Math.max(temp,land[i-1][k]);
                }
                land[i][j] += temp;
            }
        }
        

        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}