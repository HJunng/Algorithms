import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        char last = '.';
        
        for(int i=0;i<words.length;i++){
            
            if(set.contains(words[i])){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            } else if(i!=0 && words[i].charAt(0) != last){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            set.add(words[i]);
            last = words[i].charAt(words[i].length()-1);
        }
        
        return answer; 
    }
}