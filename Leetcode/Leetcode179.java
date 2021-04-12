package Leetcode;

import java.util.*;
class Solution179 {
	public String largestNumber(int[] nums) {
		String []arr = new String[nums.length];
		for (int i=0;i< nums.length;i++)
			arr[i] = String.valueOf(nums[i]);
			// arr[i] = ""+nums[i];
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});

		if(arr[0].equals("0"))
			return "0";


		StringBuilder strb = new StringBuilder();
		for (String s:arr)
			strb.append(s);

		return strb.toString();
	}
}
public class Leetcode179 {
	public static void main(String[] args) {
		int []nums = {3,30,34,5,9};
		// {10};
		// {3,30,34,5,9};
		// {10,2};
		Solution179 sol = new Solution179();
		System.out.println(sol.largestNumber(nums));
	}
}
