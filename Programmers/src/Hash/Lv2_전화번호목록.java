package Hash;

import java.util.*;

public class Lv2_전화번호목록 {

	public static void main(String[] args) {
		
		
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        String check[] = phone_book;
        
        //길이로 정렬을 하지 않고 수행하면 {"119","11"} 같은 경우 탐지 못함.
        Arrays.sort(check, (String s1, String s2)-> s1.length()-s2.length());
        
        Map<String, Integer> map = new HashMap<>();
        map.put(check[0],0);
        
        for(int i=1;i<check.length;i++){
            
            for(int j=1;j<=check[i].length();j++){
                
                String str = check[i].substring(0,j);
                if(map.containsKey(str)){
                    answer=false;
                    break;
                }
            }
            if(answer) map.put(check[i],0);
            else break;
        }
        
        return answer;
    }
}
