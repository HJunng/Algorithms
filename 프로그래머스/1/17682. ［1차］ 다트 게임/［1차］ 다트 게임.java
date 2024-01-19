import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        dartResult = dartResult.replaceAll("\\*", "* ");
        dartResult = dartResult.replaceAll("\\#", "# ");
        
        dartResult = dartResult.replaceAll("S", "S ");
        dartResult = dartResult.replaceAll("D", "D ");
        dartResult = dartResult.replaceAll("T", "T ");
        
        System.out.println(dartResult);
        
        String[] darts = dartResult.split(" ");
        
        ArrayList<Integer> scores = new ArrayList<>();
        for(int i=0;i<darts.length;i++){
            
            if(darts[i].equals("*")){
                int idx = scores.size()-1;
                
                scores.set(idx, scores.get(idx)*2);
                if(idx>0) scores.set(idx-1,scores.get(idx-1)*2);
                
                continue;
            }
            
            if(darts[i].equals("#")){
                int idx = scores.size()-1;
                scores.set(idx,scores.get(idx)*(-1));
                continue;
            }
            
            int score = Integer.parseInt(darts[i].substring(0,darts[i].length()-1));
            char bonus = darts[i].charAt(darts[i].length()-1);
            
            if(bonus=='S') scores.add(score);
            else if(bonus=='D') scores.add((int)Math.pow(score,2));
            else if(bonus=='T') scores.add((int)Math.pow(score,3));
        }
        
        for(int s : scores)
            answer += s;
        
        return answer;
    }
}