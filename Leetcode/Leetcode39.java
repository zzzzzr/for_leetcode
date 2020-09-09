package Leetcode;

import java.util.*;
class Solution39 {
	List<List<Integer>> ans = new LinkedList<>();
	//int temp=0;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> lis = new LinkedList<>();
		dfs(candidates,target,0,lis,0);
		return ans;
	}

	public void dfs(int[] candidates, int target,int temp,List<Integer> lis,int last){
		if (temp>target)
			return;
		if (temp==target){
			ans.add(new LinkedList<>(lis));
			return;
		}
		for(int i:candidates){
			if (i<last)
				continue;
			if (temp+i<=target) {
				lis.add(i);
				temp+=i;
				dfs(candidates, target, temp, lis, i);
				temp-=i;
				lis.remove(lis.size() - 1);
			}
		}
	}
}
public class Leetcode39 {
	public static void main(String []args){
		Solution39 sol = new Solution39();
		int []nums = {2,3,6,7};
		//{2,3,5};
		int target = 7;
		System.out.println(sol.combinationSum(nums,target));
	}
}
