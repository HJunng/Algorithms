package Math;

import java.util.*;
public class Lv2_할인행사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new String[] {"banana","apple","rice","pork","pot"},new int[] {3,2,2,2,1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
	}
	static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++)
            map.put(want[i],i);
        
        int[][] discntNum = new int[discount.length][want.length];
        for(int i=0;i<discount.length;i++){
            
            
            if(i==0 && map.containsKey(discount[i])){
                discntNum[i][map.get(discount[i])]++; //처음은 전 노드 복사할 필요없이 1만 더해줌.
                continue;
            }
            //이전 값 복사
            discntNum[i] = discntNum[i-1];
            
            //want에 포함된 제품이 아니면 넘김.
            if(!map.containsKey(discount[i])) continue;
            
            discntNum[i][map.get(discount[i])]++;
            
            if(i==9){
                if(number.equals(discntNum[i])){
                    answer=1;
                    break;
                }
            }else if(i>9){
                boolean b=true;
                for(int j=0;j<number.length;j++){
                    if(number[j]!=discntNum[i][j]-discntNum[i-10][j]){
                        b=false; break;
                    }
                }
                if(b){
                    answer=i-10+1;
                }
            }
            
        }
        
        
        
        return answer;
    }
}
