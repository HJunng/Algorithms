package String;

import java.util.*;
public class Lv2_오픈채팅방 {
	static Map<String,String> id_Nick = new HashMap<>();
    static ArrayList<String[]> command = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	public String[] solution(String[] record) {
        String[] answer = {};
        
        for(int i=0;i<record.length;i++){
            String[] s = record[i].split(" ");
            
            if(s[0].equals("Enter")){//입장 및 닉네임 설정
                id_Nick.put(s[1],s[2]);
                command.add(new String[]{s[0],s[1]}); 
                
            }else if(s[0].equals("Change")){//닉네임 변경
                id_Nick.put(s[1],s[2]);
                
            }else{//닉네임 삭제
                //id_Nick.remove(s[1]);
                command.add(new String[]{s[0],s[1]});
            }
        }
        
        answer=new String[command.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=id_Nick.get((command.get(i))[1]); //닉네임 가져오기
                
            if((command.get(i))[0].equals("Enter"))
                answer[i]+="님이 들어왔습니다.";
            else
                answer[i]+="님이 나갔습니다.";
                
        }
        
        return answer;
    }
}
