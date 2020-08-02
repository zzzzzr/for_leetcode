package JZoffer;
class SolutionJZ03 {
	// 更好的方法使用hashset
	public int findRepeatNumber(int[] nums) {
		int []number=new int[nums.length];
		for(int num:nums){
			number[num]++;
			if(number[num]>1)
				return num;
		}
		return -1;
	}
}
public class JZoffer03 {
	public static void main(String []args){
		int []nums=new int []{1,2,3,5,4,3};
		//{2, 3, 1, 0, 2, 5, 3};
		SolutionJZ03 sol=new SolutionJZ03();
		System.out.println(sol.findRepeatNumber(nums));
	}
}
