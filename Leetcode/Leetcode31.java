package Leetcode;

import java.util.*;
// https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
class Solution31 {
	public void nextPermutation(int[] nums) {
		int i;
		for (i=nums.length-2;i>=0;i--){
			if (nums[i]<nums[i+1])
				break;
		}
		System.out.println(i);
		if (i==-1){
			Arrays.sort(nums);
		}
		else{
			int j;
			Arrays.sort(nums,i+1,nums.length);
			for (j=i+1;j< nums.length;j++){
				if (nums[j]>nums[i]){
					break;
				}
			}
			System.out.println(j);
			int temp=nums[j];
			nums[j]=nums[i];
			nums[i]=temp;
		}
	}
}
public class Leetcode31 {
	public static void main(String[]args){
		Solution31 sol = new Solution31();
		int[]nums = {1,3,2};
		sol.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
