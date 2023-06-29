package Array;

import java.util.*;
public class Lv2_스킬트리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Set<Character> set = new HashSet<>();//skill set
        for(int i=0;i<skill.length();i++)
            set.add(skill.charAt(i));
        
        for(int i=0;i<skill_trees.length;i++){
            int idx=0;//skill index
            boolean sequential=true; //순차적이냐
            
            for(int j=0;j<skill_trees[i].length();j++){
                char ch = skill_trees[i].charAt(j);
                if(set.contains(ch)){
                    if(skill.charAt(idx)==ch) idx++;
                    else{
                        sequential=false;break;
                    }
                }
            }
            if(sequential) answer++;
        }
        
        return answer;
    }
}
