package Leetcode;

import java.util.*;
/*
执行结果：通过 显示详情
执行用时：8 ms, 在所有 Java 提交中击败了96.86%的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了93.12%的用户
 */
class Solution321 {
	// 先分别从两个数组中找出 i j 个最大数字，i+j=k，然后把这 k 个数字归并的组合起来
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		//int range = Math.min(k,Math.min(len1,len2));
		//System.out.println(range);
		int []ans= new int[k];
		for (int i=0;i<k;i++)
			ans[i]=0;
		for (int i=0;i<=k;i++){
			if (i>len1 || (k-i)>len2)
				continue;
			int []arr1 = getKdigits(nums1,len1,i);
			int []arr2 = getKdigits(nums2,len2,k-i);
			int []tmp = combine(arr1,arr2,k);
			if (compare(tmp,ans,k))
				ans=tmp;
		}
		return ans;
	}

	public int[] getKdigits(int[]nums,int len,int k){
		if (k==0)
			return new int[]{};
		int []stack = new int[len];
		int remv = len-k;
		int index=0;
		for (int i=0;i<len;i++){
			while(index>0 && remv>0 && nums[i]>stack[index-1]){
				index--;
				stack[index]=0;
				remv--;
			}
			stack[index]=nums[i];
			index++;
		}
		int []ans = new int[k];
		System.arraycopy(stack, 0, ans, 0, k);
		return ans;
	}
	public int[] combine(int[]num1,int []num2,int k){
		int i=0;
		int j=0;
		int index=0;
		int []ans = new int[k];
		while (i< num1.length && j< num2.length){
			if (compare1(num1, i, num2, j)){
				ans[index]=num1[i];
				i++;
				index++;
			}
			else {
				ans[index]=num2[j];
				j++;
				index++;
			}
		}
		while (i<num1.length){
			ans[index]=num1[i];
			index++;
			i++;
		}
		while (j<num2.length){
			ans[index]=num2[j];
			index++;
			j++;
		}
		System.out.println(Arrays.toString(num1)+" "+Arrays.toString(num2)+" "+Arrays.toString(ans));
		return ans;
	}

	public boolean compare(int[]nums1,int[]nums2,int k){
		for (int i=0;i<k;i++){
			if (nums1[i]==nums2[i])
				continue;
			else
				return nums1[i]>nums2[i];
		}
		return false;
	}

	// https://leetcode-cn.com/problems/create-maximum-number/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-7/628256
	// 从评论区抄来的比较函数，用来比较哪个数字放在下一个位置，尤其适用在连续出现相同数字时
	public boolean compare1(int[] nums1, int p1, int[] nums2, int p2) {
		if (p2 >= nums2.length) return true;
		if (p1 >= nums1.length) return false;
		if (nums1[p1] > nums2[p2]) return true;
		if (nums1[p1] < nums2[p2]) return false;
		return compare1(nums1, p1 + 1, nums2, p2 + 1);
	}
}

public class Leetcode321 {
	public static void main(String []args){
		Solution321 sol = new Solution321();
		int []nums1 = {1,6,5,4,7,3,9,5,3,7,8,4,1,1,4};
		int []nums2 = {4,3,1,3,5,9};
		int k=21;
		/*
		nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5

nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5

[2,5,6,4,4,0]
[7,3,8,0,6,5,7,6,2]
15

[1,6,5,4,7,3,9,5,3,7,8,4,1,1,4]
[4,3,1,3,5,9]
21
[4,3,1,6,5,4,7,3,9,5,3,7,8,4,1,3,5,9,1,1,4]
		 */
		System.out.println(Arrays.toString(sol.maxNumber(nums1,nums2,k)));
	}
}
