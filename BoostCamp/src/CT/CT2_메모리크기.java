package CT;
import java.util.*;
public class CT2_메모리크기 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new String[] {"INT","INT","BOOL","SHORT","LONG"}));
		System.out.println(solution(new String[] {"INT","SHORT","FLOAT","INT","BOOL"}));
		System.out.println(solution(new String[] {"FLOAT","SHORT","BOOL","BOOL","BOOL","INT"}));
		System.out.println(solution(new String[] {"BOOL","LONG","SHORT","LONG","BOOL","LONG","BOOL","LONG","SHORT","LONG","LONG"}));
		System.out.println(solution(new String[] {"SHORT","BOOL","SHORT"}));
		
	}
	static String solution(String[] arr) {
		String answer="";
		
		
		for(int i=0;i<arr.length;i++) {
			
			if(answer.length()>128) break;
			
			switch(arr[i]){
			case("BOOL"):{
				answer+="#";
				break;
			}
			case("SHORT"):{
				while(answer.length()%2!=0) {
					answer+=".";
				}
				answer+="##";
				break;
			}
			case("FLOAT"):{
				while(answer.length()%4!=0) {
					answer+=".";
				}
				answer+="####";
				break;
			}
			case("INT"):{
				while(answer.length()%8!=0) {
					answer+=".";
				}
				answer+="########";
				break;
			}
			case("LONG"):{
				while(answer.length()%8!=0) {
					answer+=".";
				}
				answer+="################";
				break;
			}
			}
		}
		if(answer.length()>128) return "HALT";
		
		String answerComma="";
		int now=0;
		while(now<answer.length()) {
			//now부터 8자리가 있다면.
			if(now+8<answer.length()) {
				answerComma+=answer.substring(now,now+8)+",";
				
			}
			//8의 배수로 끝나면 마지막 , 붙이지 않기.
			else if(now+8==answer.length()) {
				answerComma+=answer.substring(now,now+8);
			}
			//길이가 조금 남으면
			else {
				answerComma+=answer.substring(now);
				for(int i=0;i<now+8-answer.length();i++)
					answerComma+=".";
			}
			now+=8;
		}
		
		return answerComma;
	}
}
