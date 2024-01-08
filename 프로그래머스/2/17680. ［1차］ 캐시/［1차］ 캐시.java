import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        //캐시사이즈가 0일때는 반복문 필요없이 (도시개수*5)하면 됨.
        if(cacheSize==0) return cities.length*5;
        
        Queue<String> q = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++){
            //대소문자 구분 없애기 위해 모두 소문자 사용.
            String city = cities[i].toLowerCase();
            
            //게시물 가져오는데 걸린 시간 추가
            if(q.contains(city)){
                //cache-hit
                answer+=1; 
                
                //최근 사용했던 순으로 넣어야 하기 때문에 기존 자리에서 지워줌.
                q.remove(city);
            }
            else
                answer+=5; //cache-miss
            
            //캐시 삭제 -> 최근 사용했던 순으로 도시 넣기
            if(q.size()>=cacheSize)
                q.poll();
            //캐시 추가
            q.add(city);
        }
        return answer;
    }
}