package JZoffer;

import java.util.*;
class Solution59_1 {
	// 单调栈
	public int[] maxSlidingWindow2(int[] nums, int k) {
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


	public int[] maxSlidingWindow1(int[] nums, int k) {
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

	public int[] maxSlidingWindow(int[] nums, int k) {

		int []dp = new int[nums.length];
		System.arraycopy(nums, 0, dp, 0, nums.length);

		for (int i=2;i<=k;i++){
			System.out.println(Arrays.toString(dp));
			for (int j=0;j<dp.length-i+1;j++){
				dp[j] = Math.max(dp[j],nums[j+i-1]);
			}

		}

		return Arrays.copyOfRange(dp,0,nums.length-k+1);
	}
}
public class JZoffer59_1 {
	public static void main(String []args){
		int []nums = {1,3,-1,-3,5,3,6,7};
		int k=3;
		Solution59_1 sol = new Solution59_1();
		System.out.println(Arrays.toString(sol.maxSlidingWindow1(nums,k)));
	}
}