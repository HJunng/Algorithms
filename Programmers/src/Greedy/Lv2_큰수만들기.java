package Greedy;
import java.util.*;
public class Lv2_큰수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(solution("1924",2));
		//System.out.println(solution("1231234",3));
		//System.out.println(solution("4177252841",4));
		System.out.println(solution("987654321",5));
		
		LinkedList<Integer> q = new LinkedList<>();

		
	}
	public static String solution(String number, int k) {
        String answer = "";
        
        int max,maxIdx;
        int outLength=number.length()-k;
       while(k>0){
            max=0;
            maxIdx=0;
            
            for(int i=0;i<=k;i++){
                if(number.charAt(i)-'0'>max){
                    max=number.charAt(i)-'0';
                    maxIdx=i;
                }
            }
            answer+=number.charAt(maxIdx);
            number=number.substring(maxIdx+1);
            k-=maxIdx+1;
           
            //끝까지 검사하면 남는 문자열 answer에 합치기
			/*
			 * if(k==0) answer+=number;
			 */
           
            //System.out.println(answer+" "+number+" "+k);
        }
        return answer;
    }
}
