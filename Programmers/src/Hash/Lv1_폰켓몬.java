package Hash;

import java.util.*;

public class Lv1_폰켓몬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {
		public int solution(int[] nums) {
	        int answer = 0;
	        
	        Set<Integer> set = new HashSet<>();
	        for(int i=0;i<nums.length;i++){
	            set.add(nums[i]);
	        }
	        
	        if(set.size()<=nums.length/2)
	            answer = set.size();
	        else{
	            answer = nums.length/2;
	        }
	        
	        return answer;
	    }
	}
}
