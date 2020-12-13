package Leetcode;

class Solution376 {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length==0)
			return nums.length;
		int count=1;
		int oldsign=0;
		int newsign;
		for (int i=1;i< nums.length;i++){
			newsign = nums[i]-nums[i-1];
			if (oldsign==0 && newsign!=0){
				count++;
				oldsign=newsign;
			}
			if ( (newsign>0 && oldsign<0) || (newsign<0 && oldsign>0)){
				count++;
				oldsign = -oldsign;
			}
		}
		return count;
	}
}
public class Leetcode376 {
	public static void main(String []args){
		int []nums={1,2,3,4,5,6,7,8,9};
		Solution376 sol = new Solution376();
		System.out.println(sol.wiggleMaxLength(nums));
	}
}
