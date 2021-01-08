package Leetcode;

import java.util.*;

class Solution322 {

	public int coinChange1(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}


	public int coinChange(int[] coins, int amount) {
		if (amount==0)
			return 0;
		if (coins.length==1)
			return amount%coins[0]==0?amount/coins[0]:-1;


		Arrays.sort(coins);
		if (coins[0]>amount)
			return -1;
		Map<Integer,Integer> mapp = new HashMap<>();
		for (int coin:coins)
			for (int i=1;i*coin<=amount;i++)
				mapp.put(coin*i,i);

		System.out.println(mapp.toString());

		for (int i=coins[0]+1;i<=amount;i++){
			int temp = mapp.getOrDefault(i,amount+1);
			for (int coin:coins){
				temp = Math.min(temp,mapp.getOrDefault(i-coin,amount+1)+1);
			}
			mapp.put(i,temp);
		}

		System.out.println(mapp);


		if (mapp.get(amount)>amount)
			return -1;
		return mapp.get(amount);
	}
}
public class Leetcode322 {
	public static void main(String []args){
		int amount = 9832;
		int []coin = {357,239,73,52};
		/*
		357,239,73,52
		9832
		 */
		Solution322 sol = new Solution322();
		System.out.println(sol.coinChange1(coin,amount));
	}
}
