import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 할인하는 날짜까지 원하는항목의 할인 개수 합.
        // 첫째날에는 아무것도 원하는 항목중에 할인하는게 없으니까 wantCnt[0][*] = 0;
        // 둘째날에는 apple이 할인하기 때문에 wantCnt[1][1]=1 이고 나머지는 다 0.
        int[][] wantCnt = new int[discount.length+1][want.length];
        
        for(int i=0;i<discount.length;i++){
            // 원하는 과일 개수만큼 돌면서 확인.
            for(int j=0;j<want.length;j++){
                wantCnt[i+1][j] = i==0? 0 : wantCnt[i][j];
                if(want[j].equals(discount[i])){
                    wantCnt[i+1][j]++;
                }
            }
        }
        
        for(int i=0;i+10<=discount.length;i++){
            boolean correct = true;
            for(int j=0;j<want.length;j++){
                if(wantCnt[i+10][j]-wantCnt[i][j] != number[j]){
                    correct = false; break;
                }
            }
            
            if(correct) {
                answer++;
                System.out.println(i);
            }
        }
        
        return answer;
    }
}