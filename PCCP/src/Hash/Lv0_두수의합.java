package Hash;

import java.util.*;

public class Lv0_두수의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution3(new int[] {7, 3, 2, 13, 9, 15, 8, 11}, 12);
		solution3(new int[] {21, 12, 30, 15, 6, 2, 9, 19, 14},24);
		solution3(new int[] {12, 18, 5, 8, 21, 27, 22, 25, 16, 2},28);
		solution3(new int[] {11,17,6,8,21,9,19,12,25,16,2},26);
		solution3(new int[] {7,5,12,-9,-12,22,-30,-35,-21},-14);
		solution3(new int[]{7, 5, 12, 20}, 15);
	}
	//O(n)
	public static int[] solution3(int[] nums, int target) {
		int[] answer = {0,0};
		
		Set<Integer> save = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if(save.contains(target-nums[i])) {
				if(nums[i]<target-nums[i]) {
					answer[0]=nums[i];
					answer[1]=target-nums[i];
				}else {
					answer[0]=target-nums[i];
					answer[1]=nums[i];
				}
				break;
			}else {
				save.add(nums[i]);
			}
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	//O(n^2)
	public static int[] solution(int[] nums, int target) {
		int[] answer = new int[2];
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					if(nums[i]<nums[j]) {
						answer[0]=nums[i];
						answer[1]=nums[j];
						break;
					}else {
						answer[0]=nums[j];
						answer[1]=nums[i];
						break;
					}
				}
			}
			if(answer[0]>0) break;
		}
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
	//이분탐색
	//O(nlogn)
	public static int[] solution2(int[] nums, int target) {
		int[] answer = new int[2];
		
		Arrays.sort(nums);//오름차순 정렬
		
		int left=0;
		int right=nums.length-1;
		
		while(left!=right) {
			if(nums[left]+nums[right]>target) {
				right--;
			}else if(nums[left]+nums[right]<target) {
				left++;
			}else {
				answer[0]=nums[left];
				answer[1]=nums[right];
				break;
			}
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
