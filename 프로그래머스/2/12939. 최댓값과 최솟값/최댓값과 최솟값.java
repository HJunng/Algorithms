import java.util.*;
import java.util.stream.Collectors; // 필수

class Solution {
    public String solution(String s) {
        String answer = "";
        
        List<Integer> nums = Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
        Collections.sort(nums);
        
        answer = nums.get(0)+" "+nums.get(nums.size()-1);
        return answer;
    }
}