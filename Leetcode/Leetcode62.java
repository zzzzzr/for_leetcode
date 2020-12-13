package Leetcode;

import java.util.*;
class Solution62 {
	public int uniquePaths1(int m, int n) {
		if (m==1 || n==1)
			return 1;
		int []dp = new int[m];
		for (int i=0;i<m;i++)
			dp[i]=1;
		for (int j=0;j<n-1;j++){
			for (int i=m-2;i>=0;i--){
				dp[i] = dp[i+1]+dp[i];
			}
		}
		return dp[0];
	}

	public int uniquePaths(int m, int n) {
		if (m==1 || n==1)
			return 1;

		int [][]dp = new int[m][n];
		for (int j=0;j<n;j++)
			dp[m-1][j]=1;
		for (int i=0;i<m;i++)
			dp[i][n-1]=1;
		for (int i=m-2;i>=0;i--){
			for (int j=n-2;j>=0;j--){
				dp[i][j]=dp[i+1][j]+dp[i][j+1];
			}
		}
		return dp[0][0];
	}
}
public class Leetcode62 {
}
