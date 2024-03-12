class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int lcm = arr[0];
        // 배열의 모든 요소에 대해 LCM을 계산
        for(int i = 1; i < arr.length; i++) {
            lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
        }
        
        return lcm;
    }
    int gcd(int a, int b){
        if(a%b==0) return b;
        else return gcd(b,a%b);
    }
}