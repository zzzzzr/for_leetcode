package Leetcode;

import java.util.*;
class Solution137 {
	// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
	// ？？？

	public int singleNumber(int[] nums) {
		int []ans = new int[32];
		for (int num:nums){
			int index=0;
			while(num!=0){
				ans[index]+=(1&num);
				num>>>=1;
				index++;
			}
		}
		int res=0;
		int weight=1;
		for (int i=0;i<32;i++,weight*=2){
			res+=weight*(ans[i]%3);
		}
		return res;
	}
}
public class Leetcode137 {
}
