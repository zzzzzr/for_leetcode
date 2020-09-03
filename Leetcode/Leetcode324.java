package Leetcode;

import java.util.*;
class Solution324 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int []ans = new int[nums.length];
		for (int i=(nums.length-1)/2 , j=0;i>= 0 ;i--,j++){
			ans[2*j] = nums[i];
		}
		for (int i=nums.length-1 ,j=1;i>= (nums.length+1)/2;i--,j++){
			ans[2*j-1] = nums[i];
		}
		System.arraycopy(ans,0,nums,0,nums.length);
	}
}
public class Leetcode324 {
	public static void main(String []args){
		int []nums = new int[]{4,5,5,6};
		//{1, 3, 2, 2, 3, 1};
		//{1, 5, 1, 1, 6, 4};
		Solution324 sol = new Solution324();
		sol.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
