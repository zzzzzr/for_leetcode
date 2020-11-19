package Leetcode;

class SolutionJZoffer53 {
	public int missingNumber(int[] nums) {
		if(nums[nums.length-1]!=nums.length)
			return nums.length;
		return missing(nums,0,nums.length);
	}
	public int missing(int []nums,int start,int end){
		// 取区间中点，如果中点对得上，那么缺失的点在右侧区间，否则缺失的点在左侧区间
		// 递归检索对应区间
		// 终止条件为：start+1==end
		for (int i=start;i<end;i++)
			System.out.print(nums[i]+" ");
		System.out.println();
		if (start+1 == end){
			if(nums[start]==start)
				return end;
			else
				return start;
		}
		//return start;
		int mid = (start+end)/2;
		if (nums[mid]==mid)
			return missing(nums, mid+1, end);
		else if (nums[mid-1]==mid-1){
			return mid;
		}
		else
			return missing(nums, start, mid);
	}
}
public class JZoffer53_2 {
	public static void main(String []args){
		int []nums = {0,2};
		SolutionJZoffer53 sol = new SolutionJZoffer53();
		System.out.println(sol.missingNumber(nums));
	}
}
