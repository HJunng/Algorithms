class Solution {
    public String solution(String s) {
        
        String[] splitString = s.split(" ");
        int min = Integer.parseInt(splitString[0]);
        int max = Integer.parseInt(splitString[0]);
        
        for(String ss : splitString){
            int num = Integer.parseInt(ss);
            
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min+" "+max;
    }
}