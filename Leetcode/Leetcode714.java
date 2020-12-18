package Leetcode;

class Solution714 {
	public int maxProfit2(int[] prices, int fee) {
		int pre0=0;
		int pre1=-prices[0];
		int now0;
		int now1;

		for (int i=1;i<prices.length;i++){
			now0 = Math.max(pre0, pre1-fee+prices[i]);
			now1 = Math.max(pre1, pre0-prices[i]);

			pre0=now0;
			pre1=now1;
		}
		return pre0;
	}

	public int maxProfit1(int[] prices, int fee) {
		int [][]dp = new int[2][prices.length];
		dp[0][0]=0;
		dp[1][0]=-prices[0];
		for (int i=1;i<prices.length;i++){
			dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]-fee+prices[i]);
			dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1]-prices[i]);
		}
		return dp[0][prices.length-1];
	}

	public int maxProfit(int[] prices, int fee) {
		int [][]dp = new int[prices.length][2];
		dp[0][0]=0;
		dp[0][1]=-prices[0];
		for (int i=1;i<prices.length;i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-fee+prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
		}
		//for (int[] arr:dp)
		//System.out.println(Arrays.toString(arr));
		return dp[prices.length-1][0];
	}
}
public class Leetcode714 {
	public static void main(String []args){
		int []price = {1, 3, 2, 8, 4, 9};
		int fee=2;
		Solution714 sol = new Solution714();
		System.out.println(sol.maxProfit(price,fee));
	}
}
