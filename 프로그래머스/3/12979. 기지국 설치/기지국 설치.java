class Solution {
    public int solution(
        int n, // 아파트 길이
        int[] stations, // 기지국이 설치된 아파트 번호가 담긴 배열, 오름차순 정렬되어 있음.
        int w // 전파의 도달 거리
    ) {
        int answer = 0; // 기지국 설치 횟수
        int stationsIdx = 0;
        int position = 1;
        int range = 2 * w + 1;
        while(position <= n){
            
            // 기지국이 설치된 범위일 경우            
            if(stationsIdx < stations.length // 기지국 인덱스 범
               && stations[stationsIdx] - w <= position && position <= stations[stationsIdx] + w){
                position = stations[stationsIdx] + w + 1;
                stationsIdx ++;
            }   
            // 기지국이 설치되어 있지 않을 경우
            else{
                answer++;
                position += range;
            }
        }
        
        
        return answer;
    }
}