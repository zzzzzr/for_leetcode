package Leetcode;

class Solution213 {
	public int rob(int[] nums) {
		if(nums.length<=0)
			return 0;
		if(nums.length==1)
			return nums[0];
		//  不考虑第一个
		int []dp1 = new int[nums.length];
		dp1[nums.length-1]= nums[nums.length-1];
		dp1[nums.length-2]= Math.max(nums[nums.length-2],nums[nums.length-1]);
		for(int i= nums.length-3;i>=1;i--){
			dp1[i]=Math.max(dp1[i+2]+ nums[i],dp1[i+1]);
		}
		//  不考虑最后一个
		int []dp2 = new int[nums.length];
		dp2[nums.length-2]= nums[nums.length-2];
		dp2[nums.length-3]= Math.max(nums[nums.length-3],nums[nums.length-2]);
		for(int i= nums.length-4;i>=0;i--){
			dp2[i]=Math.max(dp2[i+2]+ nums[i],dp2[i+1]);
		}
		return Math.max(dp1[1],dp2[0]);
	}
}
public class Leetcode213 {
	public static void main(String []args){
		int []nums=new int[]{2,7,9,3,1,5};
		//{5,1,3,9,7,2};
		Solution213 sol = new Solution213();
		System.out.println(sol.rob(nums));
	}
}
