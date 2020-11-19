package Leetcode;

import java.util.*;
class Solution136 {
	public int singleNumber(int[] nums) {
		int ans=0;
		for (int num:nums)
			ans^=num;
		return ans;

	}
}
public class Leetcode136 {
}
