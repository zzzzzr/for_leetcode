package Leetcode;

import java.util.*;
class Solution189 {
	public void rotate1(int[] nums, int k) {
		int len = nums.length;
		k=k%len;
		reverse(nums,0,len-1);
		reverse(nums,0,k-1);
		reverse(nums,k,len-1);
	}
	public void reverse(int []nums,int start,int end){
		int temp;
		while (start<end){
			temp = nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}

	public void rotate(int[] nums, int k) {
		int temp;
		int len = nums.length;
		for (int i=0;i<k;i++){
			temp = nums[len-1];
			System.arraycopy(nums, 0, nums, 1, len - 1);
			nums[0]=temp;
		}
	}
}
public class Leetcode189 {
}
/*
 */
