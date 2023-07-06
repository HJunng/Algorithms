package Hash;

import java.util.*;
public class Lv2_롤케이크자르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> m1 = new HashMap<>();//1번째 사람 과일 종류 개수
        Map<Integer,Integer> m2 = new HashMap<>();//2번째 사람 과일 종류 개수
        
        for(int i=0;i<topping.length;i++)
            m2.put(topping[i],m2.getOrDefault(topping[i],0)+1);
        
        for(int i=0;i<topping.length;i++){
        
            m1.put(topping[i],m1.getOrDefault(topping[i],0)+1);
            m2.put(topping[i],m2.get(topping[i])-1);
            if(m2.get(topping[i])==0) m2.remove(topping[i]);
            
            if(m1.size() == m2.size()) answer++;
        }
        
        return answer;
    }
}
