package Leetcode;

class Solution198 {
	public int rob(int[] nums) {
		if(nums.length<=0)
			return 0;
		if(nums.length==1)
			return nums[0];
		if(nums.length==2)
			return Math.max(nums[0],nums[1] );
		if(nums.length==3){
			return Math.max(nums[0]+ nums[2],nums[1] );
		}
		int []dp = new int[nums.length];
		dp[nums.length-1]= nums[nums.length-1];
		dp[nums.length-2]= nums[nums.length-2];
		dp[nums.length-3]= nums[nums.length-3]+nums[nums.length-1];
		for(int i= nums.length-4;i>=0;i--){
			dp[i]=Math.max(dp[i+2],dp[i+3])+ nums[i];
		}
//		for(int num:dp)
//			System.out.println(num);
		return Math.max(dp[0],dp[1]);
	}
	public int rob1(int []nums){
		if(nums.length<=0)
			return 0;
		if(nums.length==1)
			return nums[0];
		int []dp = new int[nums.length];
		dp[nums.length-1]= nums[nums.length-1];
		dp[nums.length-2]= Math.max(nums[nums.length-2],nums[nums.length-1]);
		for(int i= nums.length-3;i>=0;i--){
			dp[i]=Math.max(dp[i+2]+ nums[i],dp[i+1]);
		}
		return dp[0];

//		dp[0] = nums[0];
//		dp[1] = Math.max(nums[0], nums[1]);
//		for (int i = 2; i < nums.length; i++) {
//			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//		}
//		return dp[nums.length - 1];
	}
}
public class Leetcode198 {
	public static void main(String []args){
		int []nums=new int[]{5,1,3,9,7,2};
		Solution198 sol = new Solution198();
		System.out.println(sol.rob1(nums));
	}
}

/*
198. 解题思路：
典型的动态规划，以下按照标准流程解题。

状态定义：
	设动态规划列表 dp ，dp[i] 代表前 i 个房子在满足条件下的能偷窃到的最高金额。
转移方程：
	设： 有 n 个房子，前 n 间能偷窃到的最高金额是 dp[n] ，前 n-1n−1 间能偷窃到的最高金额是 dp[n-1]dp[n−1] ，此时向这些房子后加一间房，此房间价值为 num ；
	加一间房间后： 由于不能抢相邻的房子，意味着抢第 n+1n+1 间就不能抢第 nn 间；那么前 n+1n+1 间房能偷取到的最高金额 dp[n+1]dp[n+1] 一定是以下两种情况的 较大值 ：
		不抢第 n+1n+1 个房间，因此等于前 nn 个房子的最高金额，即 dp[n+1] = dp[n]dp[n+1]=dp[n] ；
		抢第 n+1n+1 个房间，此时不能抢第 nn 个房间；因此等于前 n-1n−1 个房子的最高金额加上当前房间价值，即 dp[n+1] = dp[n-1] + numdp[n+1]=dp[n−1]+num ；
	细心的我们发现： 难道在前 nn 间的最高金额 dp[n]dp[n] 情况下，第 nn 间一定被偷了吗？假设没有被偷，那 n+1n+1 间的最大值应该也可能是 dp[n+1] = dp[n] + numdp[n+1]=dp[n]+num 吧？其实这种假设的情况可以被省略，这是因为：
		假设第 nn 间没有被偷，那么此时 dp[n] = dp[n-1]dp[n]=dp[n−1] ，此时 dp[n+1] = dp[n] + num = dp[n-1] + numdp[n+1]=dp[n]+num=dp[n−1]+num ，即可以将 两种情况合并为一种情况 考虑；
		假设第 nn 间被偷，那么此时 dp[n+1] = dp[n] + numdp[n+1]=dp[n]+num 不可取 ，因为偷了第 nn 间就不能偷第 n+1n+1 间。
	最终的转移方程： dp[n+1] = max(dp[n],dp[n-1]+num)dp[n+1]=max(dp[n],dp[n−1]+num)
初始状态：
	前 00 间房子的最大偷窃价值为 00 ，即 dp[0] = 0dp[0]=0 。
返回值：
	返回 dpdp 列表最后一个元素值，即所有房间的最大偷窃价值。
 */