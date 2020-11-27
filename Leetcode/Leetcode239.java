package Leetcode;

import java.util.*;
class Solution239 {
	public int[] maxSlidingWindow2(int[] nums, int k) {
		int len= nums.length;
		if(len == 0 || k == 0)
			return new int[0];
		int []left = new int[nums.length];
		int []right = new int[nums.length];
		left[0] = nums[0];
		right[len-1] = nums[len-1];
		for (int i=1;i< len;i++){
			if (i%k==0)
				left[i]=nums[i];
			else
				left[i]=Math.max(left[i-1], nums[i]);

			int j= len-i-1;
			if ((j+1)%k==0)
				right[j]=nums[j];
			else
				right[j] = Math.max(right[j+1],nums[j]);
		}
		int []ans = new int[len-k+1];
		for (int i=0;i<len-k+1;i++)
			ans[i] = Math.max(right[i],left[i+k-1]);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		//System.out.println(Arrays.toString(ans));
		return ans;
	}

	public int[] maxSlidingWindow1(int[] nums, int k) {
		if(nums.length == 0 || k == 0)
			return new int[0];
		Deque<Integer> dequee = new LinkedList<>();
		int []ans = new int[nums.length-k+1];
		for (int i=0;i<k;i++){
			while (!dequee.isEmpty() && dequee.peekLast()<nums[i])
				dequee.pollLast();
			dequee.addLast(nums[i]);
		}
		ans[0]=dequee.peekFirst();
		for (int i=k;i< nums.length;i++){
			if (nums[i-k]==dequee.peekFirst())
				dequee.pollFirst();
			while (!dequee.isEmpty() && dequee.peekLast()<nums[i])
				dequee.pollLast();
			dequee.addLast(nums[i]);
			ans[i-k+1]=dequee.peekFirst();
		}
		return ans;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length<=0)
			return new int[]{};
		if (k==1)
			return nums;
		int []ans = new int[nums.length-k+1];
		int tempmax=nums[0];
		for (int i=1;i<k;i++)
			tempmax = Math.max(tempmax,nums[i]);
		ans[0]=tempmax;
		int startindex=0;
		int endindex = k-1;
		while (endindex< nums.length-1){
			endindex++;
			if (nums[endindex]>tempmax){
				startindex++;
				tempmax = nums[endindex];
				ans[startindex]=nums[endindex];
			}
			else if (nums[startindex]<tempmax){
				startindex++;
				ans[startindex]=tempmax;
			}
			else {
				startindex++;
				tempmax=nums[startindex];
				for (int i=startindex+1;i<=endindex;i++)
					tempmax = Math.max(tempmax,nums[i]);
				ans[startindex] = tempmax;
			}
		}
		return ans;
	}
}
public class Leetcode239 {
	public static void main(String []args){
		int []nums = {1,3,-1,-3,5,3,6,7};
		int k=3;
		Solution239 sol = new Solution239();
		System.out.println(Arrays.toString(sol.maxSlidingWindow2(nums,k)));
	}
}
