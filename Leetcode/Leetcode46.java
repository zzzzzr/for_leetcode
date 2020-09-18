package Leetcode;

import java.util.*;
/*
具体来说，假设我们已经填到第 first 个位置，那么 nums[] 数组中 [0,first−1] 是已填过的数的集合，
[first,n−1] 是待填的数的集合。我们肯定是尝试用 [first,n−1] 里的数去填第 first 个数，
假设待填的数的下标为 i ，那么填完以后我们将第 i 个数和第 first 个数交换，即能使得在填第 first+1个数的时候
nums[] 数组的[0,first] 部分为已填过的数，[first+1,n−1] 为待填的数，回溯的时候交换回来即能完成撤销操作。

链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
class Solution46 {

	public List<List<Integer>> permute1(int[] nums) {
		ans = new LinkedList<>();
		List<Integer> lis = new LinkedList<>();
		for (int i:nums)
			lis.add(i);
		permu_swap(lis,0,nums.length);

		return ans;
	}

	public void permu_swap(List<Integer>lis,int first,int n){
		if (first>=n)
			ans.add(new LinkedList<>(lis));
		for (int i=first;i<n;i++){
			Collections.swap(lis,first,i);
			//swap(lis,first,i);
			permu_swap(lis, first+1, n);
			Collections.swap(lis,first,i);
			//swap(lis,first,i);
		}
	}

	public void swap(List<Integer>lis, int i,int j){
		int temp = lis.get(i);
		lis.set(i, lis.get(j));
		lis.set(j,temp);
	}


	boolean[] vis;
	List<List<Integer>> ans;

	public List<List<Integer>> permute(int[] nums) {
		//Arrays.sort(nums);
		ans = new LinkedList<>();
		vis = new boolean[nums.length];
		List<Integer> lis = new LinkedList<>();

		dfs(lis, 0, nums);

		return ans;
	}

	public void dfs(List<Integer> lis, int index, int[] nums) {
		if (index >= nums.length) {
			ans.add(new LinkedList<>(lis));
		}
		for (int i = 0; i < nums.length; i++) {
			if (!vis[i]) {
				lis.add(nums[i]);
				vis[i] = true;
				dfs(lis, index + 1, nums);
				vis[i] = false;
				lis.remove(lis.size() - 1);
			}
		}
	}
}
public class Leetcode46 {
	public static void main(String []args){
		Solution46 sol = new Solution46();
		int []nums = {2,1,3};
		for (List<Integer> lis: sol.permute1(nums))
			System.out.println(lis);
	}
}