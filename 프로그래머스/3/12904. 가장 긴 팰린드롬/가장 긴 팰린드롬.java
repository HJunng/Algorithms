class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for(int len = s.length();len>=1;len--){ // 팰린드롬 최장길이
            boolean isPal = true;
            for(int i=0;i+len<=s.length();i++){ // 팰린드롬 시작 위치
                isPal = true;
                for(int j=0;j<=len/2;j++){
                    if(s.charAt(i+j) != s.charAt(i+len-1-j)){
                        isPal = false;
                        break;
                    }
                }
                if(isPal){
                    answer = len;
                    break;
                }
            }
            if(isPal) break;
        }
        
        return answer;
    }
}