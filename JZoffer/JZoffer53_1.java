package JZoffer;

class SolutionJZoffer53 {
	public int search(int[] nums, int target) {
		if (nums.length<=0||target<nums[0]||target>nums[nums.length-1])
			return 0;
		return search(nums, target,0, nums.length);

	}
	public int search(int[]nums,int target,int start,int end){
//		System.out.println(start+" "+end);
//		if (start>end)
//			return 0;

		if (start+1==end) {
			if (nums[start]==target)
				return 1;
			else
				return 0;
		}
		int mid = (start+end)/2;
		if (nums[mid]>target)
			return search(nums, target, start, mid);
		else if (nums[mid]<target)
			return search(nums, target, mid, end);
		else
			return search(nums, target, start, mid)+search(nums, target, mid, end);
	}
}
public class JZoffer53_1 {
	public static void main(String []args){
		int []nums = {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
		// [0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10]
		//4
		int target=4;
		SolutionJZoffer53 sol =new SolutionJZoffer53();
		System.out.println(sol.search(nums,target));
	}
}
