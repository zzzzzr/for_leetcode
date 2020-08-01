import java.util.*;
class Solution18 {
	// 仿照LeetCode15 三数之和做
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans=new ArrayList<>();
		if(nums.length<=3){
			return ans;
		}
		Arrays.sort(nums);
		// 让整个数组有序
		for(int i=0;i<nums.length-3;i++){
			// 固定第一个数字
			if(i>0&&nums[i]==nums[i-1]){
				continue;
			}
			for(int j=i+1;j< nums.length-2;j++) {
				if(j>i&&nums[j]==nums[j-1]){
					continue;
				}
				int l = j + 1;
				int k = nums.length - 1;
				while (l < k) {
					// 寻找剩下两个数字
					if (nums[l] + nums[k] + nums[i] +nums[j]== target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[l]);
						temp.add(nums[k]);
						ans.add(temp);
						l++;
						k--;
						while (l < k && nums[l] == nums[l - 1]) {
							l++;
						}
						while (l < k && nums[k] == nums[k + 1]) {
							k--;
						}
					} else if (nums[l] + nums[k] + nums[i] +nums[j] < target) {
						l++;
					} else {
						// nums[l] + nums[k] + nums[i] +nums[j] > target
						k--;
					}
				}
			}
		}
		return ans;
	}
}
public class Leetcode18 {
	public static void main(String []args){
		int []test=new int []{1,2,-1,0,-1,-1,-1,-1,2,2,-3};
		//{-1, 0, 1, 2, -1, -4};
		//{1,2,-1,0,-1};
		Solution18 sol=new Solution18();
		System.out.println(sol.fourSum(test,5));
	}
}
