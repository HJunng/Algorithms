class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int statIdx = 0;
        
        for(long i=1;i<=n;){
            System.out.println(i);
            
            if(statIdx<stations.length && i>= stations[statIdx]-w && i<= stations[statIdx]+w){
                i = stations[statIdx]+w+1;
                statIdx++;
            } 
            else{
                answer++; // 기지국 생성
                i += 2*w+1;
            }
        }

        return answer;
    }
}