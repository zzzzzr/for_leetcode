package Leetcode;

import java.util.*;
class Solution47 {
	boolean []vis ;
	List<List<Integer>> ans;
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		ans = new LinkedList<>();
		vis = new boolean[nums.length];
		List<Integer> lis = new LinkedList<>();

		dfs(lis,0,nums);

		return ans;
	}

	public void dfs(List<Integer> lis,int index,int[]nums){
		if (index>=nums.length){
			ans.add(new LinkedList<>(lis));
		}
		int last=-99;
		for (int i=0;i< nums.length;i++){

			if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
				continue;
			}

			//if (!vis[i]&&nums[i]!=last){
				lis.add(nums[i]);
				last=nums[i];
				//index++;
				vis[i]=true;
				dfs(lis, index+1, nums);
				vis[i]=false;
				//index--;
				lis.remove(lis.size()-1);
			}
		//}
	}
}

public class Leetcode47 {
	public static void main(String []args){
		Solution47 sol = new Solution47();
		int []nums = {1,2,1,1};
		for (List<Integer> lis: sol.permuteUnique(nums))
			System.out.println(lis);
	}
}
