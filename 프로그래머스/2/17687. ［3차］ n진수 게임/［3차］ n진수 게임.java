class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num=0;
        String total=""; //n진법으로 튜브가 말해야하는 개수까지 말했을 때 전체 길이.
        while(total.length()<(t-1)*m+p){
            String conv = Integer.toString(num++,n); //num을 n진법으로 변환.
            
            total += conv;
        }
        
        for(int i=p-1; answer.length()<t; i+=m){
            answer += total.charAt(i);
        }
        
        return answer.toUpperCase();
    }
}