import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++)
            list.add(Integer.toString(numbers[i]));
        
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        if(list.get(0).equals("0"))
            return "0";
        
        for(String s : list)
            answer = answer + s;
        
        return answer;
    }
}