package Leetcode;

import java.util.*;
class Solution363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = Integer.MIN_VALUE;

		for (int left=0; left<n; left++){
			int []rowSum = new int[m];
			for (int right=left; right<n; right++){
				for (int i=0;i<m;i++){
					rowSum[i] += matrix[i][right];
				}

				int dp = findMax(rowSum,k);
				System.out.println(Arrays.toString(rowSum));
				System.out.println(dp);
				if (dp <= k && dp >ans)
					ans=dp;
				if (ans==k)
					return k;
			}
		}
		return ans;
	}

	public int findMax(int []num,int k){
		int max = Integer.MIN_VALUE;
		for (int l = 0; l < num.length; l++) {
			int sum = 0;
			for (int r = l; r < num.length; r++) {
				sum += num[r];
				if (sum > max && sum <= k)
					max = sum;
				if (max == k)
					return k;
			}
		}
		return max;
	}

	public int maxSumSubmatrix1(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = Integer.MIN_VALUE;

		for (int i1=0;i1<m;i1++){
			for (int j1=0;j1<n;j1++){
				int [][]dp = new int[m+1][n+1];
				dp[i1+1][j1+1] = matrix[i1][j1];
				for (int i2=i1;i2<m;i2++){
					for (int j2=j1;j2<n;j2++){
						dp[i2+1][j2+1] = dp[i2][j2+1] + dp[i2+1][j2] - dp[i2][j2] + matrix[i2][j2];
						if (dp[i2+1][j2+1] <= k && dp[i2+1][j2+1] >ans)
							ans=dp[i2+1][j2+1];
					}
				}

//				for ( int []arr:dp){
//					System.out.println(Arrays.toString(arr));
//				}
//				System.out.println();
			}
		}
		return ans;
	}
}

public class Leetcode363 {
	public static void main(String[] args) {
		Solution363 sol = new Solution363();
		int [][]num = {
				{5,-4,-3,4},
				{-3,-4,4,5},
				{5,1,5,-4}

		};

//		{
//				{5,-4,-3,4},
//				{-3,-4,4,5},
//				{5,1,5,-4}
//		};

		// {{2,2,-1}};

//		{
//				{1, 0, 1},
//				{0, -2, 3}
//		};

		int k = 8;
		System.out.println(sol.maxSumSubmatrix(num, k));
	}
}
