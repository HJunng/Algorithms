package Hash;

import java.util.*;
public class Lv2_압축 {
	static int dicNum=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(solution("KAKAO"));
		//System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
		solution("TOBEORNOTTOBEORTOBEORNOT");
	}
	static public int[] solution(String msg) {
        int[] answer = {};
        
        Map<String,Integer> dic = new HashMap<>(); //사전 초기화 (A-Z)
        for(char c='A';c<='Z';c++)
            dic.put(Character.toString(c),dicNum++);
        
        ArrayList<Integer> answerList = new ArrayList<>(); //정답입력.
        String w,c;
        w=c="";
        for(int i=0;i<msg.length();){
            w=""; //사전에서 현재 입력과 일치하는 가장 긴 문자열
            for(int j=msg.length()-1;j>=i;j--) {
                if(dic.containsKey(msg.substring(i,j+1))) {
                	w=msg.substring(i,j+1); break;
                }
            }
            //System.out.println(w);
            
            answerList.add(dic.get(w)); //출력
            
            c="";
            if(i+w.length()<=msg.length()-1){//다음 글자가 있으면
                c = msg.substring(i+w.length(),i+w.length()); //다음 글자
                
                dic.put(w+c,dicNum++); //사전 추가
            }
            i+=w.length();
            System.out.println("w:"+w+" "+"(w+c)"+(w+c)+" "+answerList);
        }
        //정답 출력.
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=answerList.get(i);
            
     
        return answer;
    }
}
