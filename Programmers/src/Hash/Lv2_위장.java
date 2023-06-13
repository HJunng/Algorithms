package Hash;

import java.util.*;

public class Lv2_위장 {

	public static void main(String[] args) {
		
		
	}
	public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        if(map.size()==1)
            answer=clothes.length;
        else{
            int mul=1;
            for(String s : map.keySet()){
                mul *= map.get(s)+1; //안 입는 것도 고려하여 +1
            }
            answer = mul-1;
        }
        
        return answer;
    }
}
