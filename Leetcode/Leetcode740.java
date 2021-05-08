package Leetcode;

class Solution740 {

	public int deleteAndEarn(int[] nums) {

		int maxlen=0;
		for (int i:nums){
			maxlen = Math.max(i, maxlen);
		}

		int []arr = new int[maxlen+1];
		for (int i:nums){
			arr[i] += i;
		}

		// int [][]dp = new int[maxlen+1][2];

		// for (int i=1;i<maxlen+1;i++){
		// 	dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
		// 	dp[i][1] = dp[i-1][0] + arr[i];
		// }
		// return Math.max(dp[maxlen][0], dp[maxlen][1]);

		// int []dp = new int[maxlen+1];
		// dp[0] = arr[0];
		// dp[1] = Math.max(arr[0], arr[1]);

		int temp;
		int dp0 = arr[0];
		int dp1 = Math.max(arr[0], arr[1]);
		for (int i=2;i<maxlen+1;i++){
			// dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
			temp = dp1;
			dp1 = Math.max(dp1, dp0+arr[i]);
			dp0 = temp;
		}
		// return dp[maxlen];
		return dp1;
	}

	public int deleteAndEarn1(int[] nums) {
		int []arr = new int[10001];
		int maxlen=0;
		for (int i:nums){
			arr[i] += i;
			maxlen = Math.max(i, maxlen);
		}
		int [][]dp = new int[maxlen+1][2];
		for (int i=1;i<maxlen+1;i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = dp[i-1][0] + arr[i];
		}
		return Math.max(dp[maxlen][0], dp[maxlen][1]);
	}

}
public class Leetcode740 {
	public static void main(String[] args) {
		Solution740 sol = new Solution740();
		int []nums = {2,4,3,3,2,3};
		// {3,4,2};
		System.out.println(sol.deleteAndEarn(nums));
	}
}
