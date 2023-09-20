class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i=l-1;i<r;i++){
            
            answer+=findNum(i);
            
        }
        
        return answer;
    }
    int findNum(long n){
        if(n%5==2) return 0;
        if(n==0) return 1;
        
        return findNum(n/5);
    }
}