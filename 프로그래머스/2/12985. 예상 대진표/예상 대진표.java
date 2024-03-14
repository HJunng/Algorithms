class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 2로 나눈 몫으로 해당 라운드의 몇 번째 경기인지 파악하기 때문에
        // a, b를 1~n -> 0~(n-1) 로 바꿔준다.
        a--; b--;
        
        while(a!=b){
            a/=2;
            b/=2;
            answer++;
        }

        return answer;
    }
}