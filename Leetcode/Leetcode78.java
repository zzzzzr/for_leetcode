package Leetcode;

import java.util.*;

/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39 MB, 在所有 Java 提交中击败了59.29%的用户
 */
class Solution78 {

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>>ans = new LinkedList<>();
		List<Integer> lis = new LinkedList<>();
		boolean []vis = new boolean[nums.length];
		dfs2(ans,nums,vis,0);
		return ans;
	}

	public void dfs2(List<List<Integer>>ans,int[]nums,boolean[]vis,int index){
		if (index== nums.length){
			List<Integer> lis = new LinkedList<>();
			for (int i=0;i< nums.length;i++){
				if (vis[i])
					lis.add(nums[i]);
			}
			ans.add(lis);
			return;
		}
		index++;
		//vis[index-1]=false;
		dfs2(ans, nums, vis, index);
		vis[index-1]=true;
		dfs2(ans, nums, vis, index);
		vis[index-1]=false;
	}


	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>>ans = new LinkedList<>();
		List<Integer> lis = new LinkedList<>();
		dfs(ans,lis,nums,0);
		return ans;
	}
	public void dfs(List<List<Integer>>ans,List<Integer>lis,int[]nums,int index){
		//System.out.println(lis);

		if (index== nums.length){
			ans.add(new LinkedList<>(lis));
			return;
		}

		//index++;
		dfs(ans, lis, nums, index+1);
		lis.add(nums[index]);
		dfs(ans, lis, nums, index+1);
		lis.remove(lis.size()-1);

	}

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> oldlis = new LinkedList<>();
		List<List<Integer>> newlis = new LinkedList<>();

		List<Integer> lis = new LinkedList<>();
		oldlis.add(lis);

		for (int i:nums){
			for (List<Integer> temp:oldlis){
				newlis.add(new LinkedList<>(temp));
				temp.add(i);
				newlis.add(temp);
			}
			oldlis = newlis;
			newlis = new LinkedList<>();
		}

		return oldlis;
	}
}
public class Leetcode78 {
	public static void main(String []args){
		int []nums = {1,2,3};
		Solution78 sol = new Solution78();
		for (List<Integer>lis: sol.subsets2(nums))
			System.out.println(lis);
	}
}
