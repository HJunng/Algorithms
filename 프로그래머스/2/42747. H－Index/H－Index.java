import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(citations);
        
        int point = citations.length-1; // 현재까지 포함된 책 포인터.
        
        // h를 citations에서 가장 큰 숫자로 대입하고 1씩 줄여가면서 확인.
        for(int h=citations[citations.length-1];h>=0;h--){
            if(point>0 && h<=citations[point-1]) point-=1;

            if(h<=citations.length-point){
                answer = h; break;
            }
        }
        
        return answer;
    }
}