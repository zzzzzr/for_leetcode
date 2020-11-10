package Leetcode;

import java.util.*;
class Solution349 {
	// 先对两个数组排序，然后双指针分别指向两个数组
	// 分别比较大小，相等且不与之前数字相同时写入ans数组
	// 与归并排序思想类似
	public int[] intersection2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int []ans = new int[nums1.length+ nums2.length];
		int index = 0;
		int i=0;
		int j=0;
		while (i<nums1.length&&j<nums2.length) {
			if (nums1[i]==nums2[j]){
				if (index==0||nums1[i]!=ans[index-1]) {
					ans[index] = nums1[i];
					index++;
				}
				i++;
				j++;
			}
			else if (nums1[i]<nums2[j]){
				i++;
			}
			else
				j++;
		}
		int []res = new int[index];
		for (i=0;i<index;i++)
			res[i]=ans[i];
		return res;
	}


	public int[] intersection1(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);
		Set<Integer> sett = new HashSet<>();
		for (int num:nums1)
			if (!sett.contains(num)&&binarySearch(num,nums2,0,nums2.length))
				sett.add(num);

		int []ans = new int[sett.size()];
		int index=0;
		for (int i:sett){
			ans[index]=i;
			index++;
		}
		return ans;
	}
	public boolean binarySearch(int target,int[]nums,int start,int end){
		if(end<=start)
			return false;
		if (end-start<=1){
			return nums[start] == target;
		}
		int mid = (start+end)/2;
		if (target == nums[mid])
			return true;
		if (target< nums[mid])
			return binarySearch(target, nums, start, mid);
		else
			return binarySearch(target, nums, mid, end);
	}

//-------------------------------------------------------------------------------------

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> sett = new HashSet<>();
		for (int i=0;i< nums1.length;i++){
			for (int j=0;j< nums2.length;j++){
				if (!sett.contains(nums1[i])&&nums1[i]==nums2[j]){
					sett.add(nums1[i]);
				}
			}
		}
		int []ans = new int[sett.size()];
		int index=0;
		for (int i:sett){
			ans[index]=i;
			index++;
		}
		return ans;
	}
}
public class Leetcode349 {
	public static void main(String[]args){
		int []nums1={4,9,5};
		int []nums2={9,4,9,8,4};
		Solution349 sol = new Solution349();
		System.out.println(Arrays.toString(sol.intersection2(nums1,nums2)));
	}
}
