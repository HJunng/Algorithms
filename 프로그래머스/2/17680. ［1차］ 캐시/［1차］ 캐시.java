import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toLowerCase();
            
            // 캐시가 city를 가지고 있는 우
            if(cache.contains(city)){
                answer += 1;
                for(String c : cache){
                    if(c.equals(city)){
                        cache.remove(city);
                        break;
                    }
                }
                cache.add(city);
            }
            // 캐시가 city를 가지고 있지 않은데, 캐시가 다 차지 않은 경우
            else if(cache.size()<cacheSize){
                cache.add(city);
                answer += 5;
            }
            else if(cache.size()==0) answer += 5;
            // 캐시가 city를 가지고 있지 않고, 캐시가 다 찬 경우
            else{
                answer += 5;
                cache.poll();
                cache.add(city);
            }
        }
        
        return answer;
    }
}