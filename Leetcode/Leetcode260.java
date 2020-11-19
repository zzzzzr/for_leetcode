package Leetcode;

import java.util.*;
class Solution260 {
	public int[] singleNumber(int[] nums) {
		int ret = 0;
		for (int num:nums)
			ret^=num;

		int index=1;
		while((index&ret) ==0)
			index<<=1;

		int a=0;
		int b=0;
		for (int num:nums){
			if ((num&index)==0){
				a^=num;
			}
			else {
				b^=num;
			}
		}

		return new int[]{a,b};
	}
}
public class Leetcode260 {
}
