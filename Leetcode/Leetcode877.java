package Leetcode;

import java.util.*;

class Solution877 {

	public boolean stoneGame(int[] piles) {
		return true;
	}

	public boolean stoneGame1(int[] piles) {
		int len = piles.length;
		int [][]dp = new int[len][len];
//		int sum = 0;
		for (int i=0;i<len;i++){
			dp[0][i] = piles[i];
//			sum += piles[i];
		}
		for (int i=1; i<len; i++){
			for (int j=0; j<len-i; j++){
//				System.out.println(i + " " + j);
				dp[i][j] = Math.max(piles[j]-dp[i-1][j+1], piles[i+j]-dp[i-1][j]);
			}
		}
		for (int []arr : dp){
			System.out.println(Arrays.toString(arr));
		}
		return dp[len-1][0]>0;
	}
}

public class Leetcode877 {
	public static void main(String[] args) {
		Solution877 sol = new Solution877();
		int []stone = {5,3,4,5};
		System.out.println(sol.stoneGame(stone));
	}
}
