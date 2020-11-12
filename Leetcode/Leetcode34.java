package Leetcode;

import java.util.*;
class Solution34 {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length<=0||target<nums[0]||target>nums[nums.length-1])
			return new int[]{-1,-1};
		return search(nums, target,0, nums.length);
	}
	public int[] search(int[]nums,int target,int start,int end){
//		System.out.println(start+" "+end);

		if (start+1==end) {
			if (nums[start]==target)
				return new int[]{start,start};
			else
				return new int[]{-1,-1};
		}
		int mid = (start+end)/2;
		if (nums[mid]>target)
			return search(nums, target, start, mid);
		else if (nums[mid]<target)
			return search(nums, target, mid, end);
		else {
			int []tmp1 = search(nums, target, start, mid);
			int []tmp2 = search(nums, target, mid, end);
			if (tmp1[0]==-1)
				return tmp2;
			if (tmp2[0]==-1)
				return tmp1;
			return new int[]{tmp1[0],tmp2[1]};
		}
	}
}
public class Leetcode34 {
	public static void main(String []args){
		int[]nums = {5,7,7,8,8,10};
		// [5,7,7,8,8,10]
		//5
		int target=5;
		Solution34 sol = new Solution34();
		System.out.println(Arrays.toString(sol.searchRange(nums,target)));
	}
}
