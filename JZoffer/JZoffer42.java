package JZoffer;

//Leetcode53
// 介绍了线段树
//https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
class SolutionJZoffer42 {
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int tempmax = nums[0];
		for (int i=1;i< nums.length;i++){
			if (tempmax<0)
				tempmax=nums[i];
			else
				tempmax=tempmax+nums[i];

			max = Math.max(tempmax,max);
		}
		return max;
	}
}
public class JZoffer42 {
	public static void main(String []args){
		int []nums = {-2,1,-3,4,-1,2,1,-5,4};
		SolutionJZoffer42 sol = new SolutionJZoffer42();
		System.out.println(sol.maxSubArray(nums));
	}
}
