class SolutionMST0803 {
	public int findMagicIndex(int[] nums) {
		for(int i=0;i<nums.length;i++){
			if(nums[i]==i)
				return i;
		}
		return -1;
	}
}
// 具体看《程序员面试金典》，这是一道有上下文的题目
public class MST0803 {
	public static void main(String []args){
		int []nums = new int[]{1, 0, 2, 3, 4, 5};
		SolutionMST0803 sol = new SolutionMST0803();
		System.out.println(sol.findMagicIndex(nums));
	}
}
