package Array;

import java.util.Arrays;

public class Lv0_두수의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution2(new int[] {7, 3, 2, 13, 9, 15, 8, 11}, 12);
		solution2(new int[] {21, 12, 30, 15, 6, 2, 9, 19, 14},24);
		solution2(new int[] {12, 18, 5, 8, 21, 27, 22, 25, 16, 2},28);
		solution2(new int[] {11,17,6,8,21,9,19,12,25,16,2},26);
		solution2(new int[] {7,5,12,-9,-12,22,-30,-35,-21},-14);
		solution2(new int[]{7, 5, 12, 20}, 15);
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
	//O(n)
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
