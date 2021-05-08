package Leetcode;

import java.util.*;
class Solution377 {
	public int combinationSum4(int[] nums, int target) {
		Set<Integer> sett = new HashSet<>();
		for (int i:nums){
			sett.add(i);
		}

		// Map<Integer,Integer> mapp = new HashMap<>();
		Arrays.sort(nums);
		int []dp = new int[target+1];

		for (int i=1; i <= target; i++){
			int temp=0;
			for (int j=1;j<i;j++){
				// temp+=mapp.getOrDefault(j,0)*mapp.getOrDefault(i-j,0);
				if (sett.contains(j)){
					temp += dp[i-j];
				}
			}
			if (sett.contains(i)){
				temp++;
			}
			dp[i] = temp;
		}
		System.out.println(Arrays.toString(dp));

		return dp[target];
	}
}
public class Leetcode377 {
	public static void main(String[] args) {
		Solution377 sol = new Solution377();
		int []nums = {1,2,3};
		int target = 6;
		System.out.println(sol.combinationSum4(nums,target));
	}
}
