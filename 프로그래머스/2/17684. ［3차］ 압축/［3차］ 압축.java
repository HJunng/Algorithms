import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        Map<String,Integer> dic = new HashMap<>();
        int dicNum=1;
        for(char c='A';c<='Z';c++) dic.put(c+"", dicNum++);
        
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<msg.length();){
            
            String s = msg.charAt(i)+"";
            
            // dic에 없는 문자열까지 구함 or msg 끝까지 다 조사.
            while(i+s.length()<msg.length() && dic.containsKey(s)){
                s += msg.charAt(i+s.length());
            }
            
            // dic에 없는 문자열일 경우.
            if(!dic.containsKey(s)){
                answerList.add(dic.get(s.substring(0,s.length()-1)));
                dic.put(s,dicNum++);
                i+=s.length()-1;
            }
            // msg끝까지 조사한 경우.
            else{
                answerList.add(dic.get(s));
                i+=s.length();
            }
        }
        
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}