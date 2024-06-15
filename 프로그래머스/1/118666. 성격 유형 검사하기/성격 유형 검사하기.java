import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<String, Integer> score = new HashMap<>();//성격별 점수 저장
        for(int i=0;i<survey.length;i++){
            String[] type = survey[i].split("");
            
            if(choices[i]<4){
                score.put(type[0],score.getOrDefault(type[0],0)+Math.abs(4-choices[i]));
            }else if(choices[i]>4){
                score.put(type[1],score.getOrDefault(type[1],0)+Math.abs(4-choices[i]));
            }
        }
        //System.out.println(score);
        
        String[] t = {"RT","CF","JM","AN"};//알파벳 순 성격 유형
        
        for(int i=0;i<t.length;i++){
            String[] type = t[i].split("");
            
            int t1 = score.getOrDefault(type[0],0);
            int t2 = score.getOrDefault(type[1],0);
            
            if(t1>=t2) answer+=type[0];//성격 유형 중 하나 선택
            else answer+=type[1];
        }
        
        
        return answer;
    }
}