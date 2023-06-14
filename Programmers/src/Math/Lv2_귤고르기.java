package Math;

import java.util.*;
public class Lv2_귤고르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> tan = new HashMap<>();
        ArrayList<Integer> sizeTan = new ArrayList<>();
        
        for(int i:tangerine) //크기별로 몇개 있는지 넣기.
            tan.put(i,tan.getOrDefault(i,0)+1);
        
        for(int i:tan.keySet()) //어떤 사이즈가 있는지 넣기.
            sizeTan.add(i);
        
        //사이즈별 개수가 많은 순서로 정렬
        Collections.sort(sizeTan, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return tan.get(b)-tan.get(a);
            }
        });
        
        int now=0;
        while(k>0){
            //개수가 제일 많은 사이즈의 개수를 모두 빼기
            k-=tan.get(sizeTan.get(now));
            
            now++;
            answer++; //종류 개수 한개 추가
        }
        
        return answer;
    }
}
