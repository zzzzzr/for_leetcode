package Leetcode;

import java.util.*;
class Solution90_2 {
	List<Integer> t = new ArrayList<Integer>();
	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(false, 0, nums);
		return ans;
	}

	public void dfs(boolean choosePre, int cur, int[] nums) {
		if (cur == nums.length) {
			ans.add(new ArrayList<Integer>(t));
			return;
		}
		dfs(false, cur + 1, nums);
		if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
			return;
		}
		t.add(nums[cur]);
		dfs(true, cur + 1, nums);
		t.remove(t.size() - 1);
	}
}


class Solution90_1 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<>();
		List<Integer> temp = new LinkedList<>();
		int i=0;
		int len = nums.length;
		dfs(nums,0,len,temp,ans);
		return ans;
	}
	public void dfs(int []nums, int index, int len, List<Integer> temp, List<List<Integer>>ans){
		if (index==len){
			ans.add(new LinkedList<>(temp));
			return;
		}
		int i=index+1;
		while (i<len && nums[i]==nums[index])
			i++;
		for (int j=0;j<i-index+1;j++){
			dfs(nums, i, len, temp, ans);
			temp.add(nums[index]);
		}
		for (int j=0;j<i-index+1;j++){
			temp.remove(temp.size()-1);
		}
	}
}

class Solution90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<>();
		ans.add(null);
		int i=0;
		int len = nums.length;
		while(i<len){
			int j=i+1;
			while(j<len && nums[j]==nums[i])
				j++;
			List<List<Integer>> part = split(nums[i],j-i);
			// System.out.println(part);
			ans = multiply(ans, part);
			i=j;
		}
		return ans;
	}
	public List<List<Integer>> multiply(List<List<Integer>> og, List<List<Integer>> part){
//		System.out.println(og);
//		System.out.println(part);
		List<List<Integer>> ret = new LinkedList<>();
		for(List<Integer> lisi:og){
			if (lisi==null){
				for (List<Integer> lisj : part) {
					ret.add(new LinkedList<>(lisj));
				}
			}
			else {
				for (List<Integer> lisj : part) {
					List<Integer> temp = new LinkedList<>(lisi);
					temp.addAll(lisj);
					//System.out.println(temp);
					ret.add(new LinkedList<>(temp));
				}
			}
		}
//		System.out.println(ret);
		return ret;
	}
	public List<List<Integer>> split(int num,int count){
		List<List<Integer>> ret = new LinkedList<>();
		List<Integer> temp = new LinkedList<>();
		for(int j=0;j<=count;j++){
			ret.add(new LinkedList<>(temp));
			temp.add(num);
		}
		return ret;
	}
}
public class Leetcode90 {
	public static void main(String []args){
		int []nums = {1,1,2,2};

//		Leetcode.Solution90 sol = new Leetcode.Solution90();
//		List<List<Integer>> asn = sol.subsetsWithDup(nums);
//		for (List<Integer> liss:asn)
//			System.out.println(liss);

		Solution90_1 sol_1 = new Solution90_1();
		List<List<Integer>> ans = sol_1.subsetsWithDup(nums);
		for (List<Integer> liss:ans)
			System.out.println(liss);
	}
}
