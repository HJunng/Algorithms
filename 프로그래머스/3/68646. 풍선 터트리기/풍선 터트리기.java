import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0; // 맨 왼쪽, 오른쪽은 무조건 남을 수 있음.
        
        if(a.length<=2){
            return a.length;
        }
        answer = 2;
        TreeSet<Integer> left = new TreeSet<>();
        TreeSet<Integer> right = new TreeSet<>();
        
        left.add(a[0]);
        
        for(int i=2;i<a.length;i++){
            right.add(a[i]);
        }
        
        
        for(int i=1;i<a.length-1;i++){ // i번째 수 : 남을 수 있나?
            int leftMin = left.first();
            int rightMin = right.first();
            
            // System.out.println(leftMin +" "+a[i]+" "+rightMin);
            
            if(a[i]<leftMin || a[i]<rightMin) answer++;
            
            left.add(a[i]);
            if(i+1<a.length) right.remove(a[i+1]);
        }
        
        return answer;
    }
}