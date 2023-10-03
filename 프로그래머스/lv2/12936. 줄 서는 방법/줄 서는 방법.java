import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long[] fac = new long[n];
        fac[0]=1;
        fac[1]=1;
        for(int i=2;i<n;i++) fac[i]=fac[i-1]*i;
        
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++) nums.add(i);
        
        k-=1;
        for(int i=0;i<n;i++){
            //System.out.println(nums.get((int)(k/fac[n-i-1])));
            answer[i]=nums.get((int)(k/fac[n-i-1]));
            nums.remove((int)(k/fac[n-i-1]));
            k%=fac[n-i-1];
        }
        
        
        return answer;
    }
}