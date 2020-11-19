package Leetcode;

import java.util.*;
class Solution286 {
	// 0到n求和，再减去数组中的数字
	public int missingNumber2(int[] nums) {
		int ans = nums.length*(nums.length+1)/2;
		for (int num:nums)
			ans-=num;
		return ans;
	}

	// 位运算
	public int missingNumber1(int[] nums) {
		int ans = nums.length;
		for (int i=0;i<nums.length;i++){
			ans = ans^i^nums[i];
		}
		return ans;
	}

	public int missingNumber(int[] nums) {
		if(nums[nums.length-1]!=nums.length)
			return nums.length;
		return missing(nums,0,nums.length);
	}
	public int missing(int []nums,int start,int end){
		// 取区间中点，如果中点对得上，那么缺失的点在右侧区间，否则缺失的点在左侧区间
		// 递归检索对应区间
		// 终止条件为：start+1==end
		if (start+1 == end){
			if(nums[start]==start)
				return end;
			else
				return start;
		}
		//return start;
		int mid = (start+end)/2;
		if (nums[mid]==mid)
			return missing(nums, mid+1, end);
		else if (nums[mid-1]==mid-1){
			return mid;
		}
		else
			return missing(nums, start, mid);
	}
}
public class Leetcode286 {
}
