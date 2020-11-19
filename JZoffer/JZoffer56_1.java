package JZoffer;

import java.util.*;
class Solution56_1 {
	// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
	// 位运算  我不配 TAT
	public int[] singleNumbers(int[] nums) {
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
public class JZoffer56_1 {
	public static void main(String []args){
		System.out.println(1&2);
		System.out.println(1|2);
		System.out.println(1^2);
	}
}
