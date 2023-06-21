package Math;

import java.util.*;
public class Lv2_할인행사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new String[] {"banana","apple","rice","pork","pot"},new int[] {3,2,2,2,1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
	}
	static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String,Integer> wantIdx = new HashMap<>();//want의 index저장.
        for(int i=0;i<want.length;i++) wantIdx.put(want[i],i);  
    
        for(int i=0;i+9<discount.length;i++){
            int[] cntNum = new int[number.length];
            
            for(int j=0;j<10;j++){
                //discount배열 원소가 want에 있는 원소이면 해당 값 추가.
                if(wantIdx.containsKey(discount[i+j])) cntNum[wantIdx.get(discount[i+j])]++;
            }
            //System.out.println(i+": "+Arrays.toString(cntNum));
            if(Arrays.equals(cntNum,number)){
                answer++; // 원하는 제품을 모두 살 수 있는 날이면
            }
        }
        
        return answer;
    }
}
