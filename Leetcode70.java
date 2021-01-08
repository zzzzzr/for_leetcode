import java.util.*;
class Solution70 {
	public int climbStairs1(int n) {
		int fir = 1;
		int sec = 1;
		int thi ;
		for (int i=2;i<=n;i++){
			thi = fir+sec;
			fir = sec;
			sec = thi;
		}
		return sec;
	}

	public int climbStairs(int n) {
		int []dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for (int i=2;i<=n;i++)
			dp[i]=dp[i-1]+dp[i-2];
		return dp[n];
	}
}
public class Leetcode70 {
}
