import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> sumSet = new HashSet<>();
        
        int n = elements.length;
        
        for(int i=0;i<n;i++){
            // i부터 시작되는 모든 부분 수열을 구하고 -> sum값을 저장.
            int sum = elements[i];
            sumSet.add(sum);
            
            for(int j=1;j<n;j++){
                sum += elements[(i+j)%n];
                sumSet.add(sum);
            }
        }
        
        return sumSet.size();
    }
}