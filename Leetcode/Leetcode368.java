package Leetcode;

import java.util.*;
class Solution368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;

		int []dp = new int[len];
		int []pre = new int[len];

		for (int i=0;i<len;i++){
			int tempLen = 1;
			int tempIndex=-1;
			for (int j=i-1;j>=0;j--){
				if (nums[i] % nums[j] == 0){
					if (dp[j]+1 > tempLen){
						tempIndex = j;
						tempLen = dp[j]+1;
					}
				}
			}
			pre[i] = tempIndex;
			dp[i] = tempLen;
		}

		int maxLen=1;
		int maxIndex=0;
		for (int i=0; i<len; i++) {
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				maxIndex = i;
			}
		}

		List<Integer> list = new ArrayList<>();
		while (maxIndex!=-1){
			list.add(nums[maxIndex]);
			maxIndex = pre[maxIndex];
		}
		return list;
	}

	public List<Integer> largestDivisibleSubset1(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;

		int []dp = new int[len];
		Arrays.fill(dp,1);
		int []pre = new int[len];
		Arrays.fill(pre,-1);

		int maxLen=1;
		int maxIndex=0;

		for (int i=1;i<len;i++){
			int tempLen = dp[i];
			int tempIndex=-1;
			for (int j=i-1;j>=0;j--){
				if (nums[i] % nums[j] == 0){
					// System.out.println(nums[i] +" "+ nums[j]);
					if (dp[j]+1 > tempLen){
						tempIndex = j;
						tempLen = dp[j]+1;
					}
				}
			}
			pre[i] = tempIndex;
			dp[i] = tempLen;
			if (tempLen > maxLen){
				maxLen = tempLen;
				maxIndex = i;
			}
		}
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(pre));

		List<Integer> list = new ArrayList<>(maxLen);
		while (maxIndex!=-1){
			list.add(nums[maxIndex]);
			maxIndex = pre[maxIndex];
		}
		return list;
	}
}

public class Leetcode368 {
	public static void main(String[] args) {
		Solution368 sol = new Solution368();
		int []arr = {1,2,4,6,8,12};
		// {1,2,4,8};
		// {1,2,3};
		System.out.println(sol.largestDivisibleSubset(arr));
	}
}
