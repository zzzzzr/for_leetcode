package Leetcode;

import java.util.*;
// 前缀和 + 哈希表优化

class Solution560 {
	public int subarraySum1(int[] nums, int k) {
		int presum=0;
		int count=0;
		Map<Integer,Integer> mapp = new HashMap<>();
		//  mapp 中存储的值是前面的所有前缀和的出现次数
		// 当前前缀和 - 之前前缀和 = k ， 则中间的子数组和为 k
		// 而 presum 即指代当前前缀和，或者说是到目前数字为止的所有数字之和
		mapp.put(0,1);
		for (int i:nums){
			presum+=i;
			if (mapp.containsKey(presum-k))
				count+=mapp.get(presum-k);
			mapp.put(presum,mapp.getOrDefault(presum,0)+1);
		}
		return count;
	}


	public int subarraySum(int[] nums, int k) {
		int sum=0;
		int []subsum = new int[nums.length+1];
		for (int i=0;i< nums.length;i++){
			sum+=nums[i];
			subsum[i+1]=sum;
		}
//		for (int i:subsum)
//			System.out.println(i);

		int count=0;
		for (int i=0;i<subsum.length-1;i++){
			for (int j=i+1;j<subsum.length;j++){
				if (subsum[j]-subsum[i]==k)
					count++;
			}
		}
		return count;
	}
}
public class Leetcode560 {
	// nums = [1,1,1], k = 2
	public static void main(String[]args){
		int []nums = {1,1,1};
		int k=2;
		Solution560 sol = new Solution560();
		System.out.println(sol.subarraySum1(nums,k));
	}
}
