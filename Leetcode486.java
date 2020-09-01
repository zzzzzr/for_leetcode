import java.util.*;
class Solution486 {
	int [][]dp;

	public boolean PredictTheWinner(int[] nums) {
		if (nums.length<=2)
			return true;

		dp = new int[nums.length][nums.length];

		for (int i=0;i< nums.length;i++){
			dp[i][i] = nums[i];
		}


		for (int i =0;i< nums.length-1;i++){
			dp[i][i+1] = Math.min(nums[i], nums[i+1])-Math.max(nums[i], nums[i+1]);
		}
		//printf();

		int signal=1;
		for (int i=2;i<= nums.length-1;i++){
			for (int j=0;j< nums.length-i;j++){
				if (signal == 1) {
					dp[j][j + i] =Math.max(dp[j][j+i-1]+nums[j+i],dp[j+1][j+i]+nums[j]);
				}
				else {
					dp[j][j+i] = Math.min((dp[j][j+i-1]-nums[j+i]),
							(dp[j+1][j+i]-nums[j]));
				}
			}
			signal = -1*signal;
		}
		//printf1();
		printf();

		if (nums.length%2==1)
			return dp[0][nums.length-1]>=0;
		else
			return dp[0][nums.length-1]<=0;
	}


	public void printf(){
		for (int i=0;i< dp.length;i++){
			for (int j=0;j< dp.length-i;j++){
				System.out.printf("%6d",dp[j][j+i]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printf1(){
		for (int []arr:dp){
			for (int i:arr){
				System.out.printf("%6d",i);
			}
			System.out.println();
		}
		System.out.println();
	}

//	public int dfs(int i,int j,int len){
//		int num1 ,num2;
//		if (dp[i+1][j]==0)
//			dp[i+1][j] = dfs(i+1,j  );
//		else
//			num1=dfs()
//		if (dp[i][j-1]!=0)
//			num2=dp[i][j-1];
//
//	}


//	public boolean predict(int[]nums,int start,int end,int tempsum){
//		if (end-start==0) {
//			tempsum += nums[start];
//			return tempsum >= 0;
//		}
//		if (end-start==1){
//			tempsum+=Math.max(nums[start],nums[end] )-Math.min(nums[start],nums[end] );
//			return tempsum>=0;
//		}
//		System.out.println(" "+(tempsum+nums[start]-nums[start+1])+" "+(tempsum+nums[end]-nums[end-1])+" "+(tempsum+Math.max(nums[start],nums[end] )-Math.min(nums[start],nums[end] )));
//		return predict(nums,  start+2, end, tempsum+nums[start]-nums[start+1])||
//				predict(nums,  start, end-2, tempsum+nums[end]-nums[end-1])||
//				predict(nums,  start+1, end-1, tempsum+Math.max(nums[start],nums[end] )-Math.min(nums[start],nums[end] ));
//	}
}
public class Leetcode486 {
	public static void main(String []args){
		Solution486 sol = new Solution486();
		int []nums = new int[]{1, 2, 3,4,5};
		System.out.println(sol.PredictTheWinner(nums));
	}
}
