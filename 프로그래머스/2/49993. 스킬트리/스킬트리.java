class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            String s = skill_trees[i];
            String removeOthers = "";
            
            for(int j=0;j<s.length();j++){
                for(int k=0;k<skill.length();k++){
                    if(s.charAt(j)==skill.charAt(k)){
                        removeOthers+=s.charAt(j);
                    }
                }
            }
            
            if(removeOthers.equals(skill.substring(0,removeOthers.length()))) answer++;
        }
        
        return answer;
    }
}