package Leetcode;

import java.util.*;
class Solution217 {
	public boolean containsDuplicate1(int[] nums) {
		Set<Integer> sett = new HashSet<>();
		for (int i:nums){
			if (sett.contains(i))
				return true;
			sett.add(i);
		}
		return false;
	}

	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i=0;i< nums.length;i++)
			if (nums[i]==nums[i+1])
				return true;
		return false;
	}
}
public class Leetcode217 {
}
