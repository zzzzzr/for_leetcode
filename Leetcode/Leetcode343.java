package Leetcode;

import java.util.*;

class Solution343 {
	//DP 动态规划
	public int integerBreak_1(int n) {
		int []dp1=new int[]{1, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243, 324, 486, 729, 972, 1458, 2187, 2916, 4374, 6561, 8748, 13122, 19683, 26244, 39366, 59049, 78732, 118098, 177147, 236196, 354294, 531441, 708588, 1062882, 1594323, 2125764, 3188646, 4782969, 6377292, 9565938, 14348907, 19131876, 28697814, 43046721, 57395628, 86093442, 129140163, 172186884, 258280326, 387420489, 516560652, 774840978, 1162261467, 1549681956};
		int []dp=new int[n];
		dp[0]=1;        // integerbreak(1)=1
		dp[1]=1;        // integerbreak(2)=1
		dp[2]=2;        // integerbreak(3)=2
		for(int i=3;i<=n;i++){
			//自2开始到n的每一个数字
			//dp[i-1]=0;
			for(int j=1;j<i-1;j++){
				//System.out.println(j+" "+(i-j));
				int num1=Math.max(dp[j-1],j);
				int num2=Math.max(dp[i-j-1],i-j);
				dp[i-1]=Math.max(dp[i-1],num1*num2);
			}
			System.out.println(dp[i-1]);
		}
		return dp[n-1];
	}
	public int integerBreak(int n) {
		int []dp1=new int[]{1, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108,
				162, 243, 324, 486, 729, 972, 1458, 2187, 2916, 4374, 6561,
				8748, 13122, 19683, 26244, 39366, 59049, 78732, 118098, 177147,
				236196, 354294, 531441, 708588, 1062882, 1594323, 2125764, 3188646,
				4782969, 6377292, 9565938, 14348907, 19131876, 28697814, 43046721,
				57395628, 86093442, 129140163, 172186884, 258280326, 387420489,
				516560652, 774840978, 1162261467, 1549681956};

		return dp1[n-1];
	}
	public int[] integerBreakArray(int n) {
		int []dp=new int[n];
		dp[0]=1;        // integerbreak(1)=1
		dp[1]=1;        // integerbreak(2)=1
		dp[2]=2;        // integerbreak(3)=2
		for(int i=3;i<=n;i++){
			//自2开始到n的每一个数字
			//dp[i-1]=0;
			for(int j=1;j<i-1;j++){
				//System.out.println(j+" "+(i-j));
				int num1=Math.max(dp[j-1],j);
				int num2=Math.max(dp[i-j-1],i-j);
				dp[i-1]=Math.max(dp[i-1],num1*num2);
			}
			//System.out.println(dp[i-1]);
		}
		return dp;
	}
}
public class Leetcode343 {
	public static void main(String []args){
		int num=58;
		Solution343 sol=new Solution343();
		System.out.println(Arrays.toString(sol.integerBreakArray(num)));
	}
}
