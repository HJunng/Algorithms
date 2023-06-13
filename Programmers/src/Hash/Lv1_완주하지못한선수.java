package Hash;

import java.util.*;

public class Lv1_완주하지못한선수 {

	public static void main(String[] args) {
		
		String participant[] = {"leo", "kiki", "eden"};
		String completion[] = {"eden", "kiki"};
		
		System.out.println(solution(participant,completion));
	}
	static public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<participant.length;i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0;i<completion.length;i++){
            map.put(completion[i],map.get(completion[i])-1);
        }
        
        for(int i=0;i<participant.length;i++){
            
            if(map.get(participant[i])==1){
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
