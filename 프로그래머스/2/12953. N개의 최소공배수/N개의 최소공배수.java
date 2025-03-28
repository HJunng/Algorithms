import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        
        answer = arr[0];
        for(int i=1;i<arr.length;i++) {
            int temp = gcd(answer, arr[i]);
            answer = answer * (arr[i]/temp);
        }
        
        return answer;
    }
    int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}