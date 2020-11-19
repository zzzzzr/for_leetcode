package Leetcode;

import java.util.*;
class Solution283 {
	public void moveZeroes(int[] nums) {
		if (nums.length<=0)
			return;
		int indexwrite=0;
		int indexfind;
		while (indexwrite<nums.length){
			if (nums[indexwrite]==0)
				break;
			indexwrite++;
		}
		if (indexwrite>=nums.length)
			return;
		indexfind =indexwrite+1;
		while(indexfind<nums.length){
			if (nums[indexfind]!=0){
				nums[indexwrite]=nums[indexfind];
				indexwrite++;
				indexfind++;
			}
			else {
				indexfind++;
			}
		}
		while (indexwrite< nums.length){
			nums[indexwrite]=0;
			indexwrite++;
		}
	}
}
public class Leetcode283 {
	public static void main(String []args){
		int []nums = {0,1,0,3,12};
		Solution283 sol = new Solution283();
		sol.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
