import java.util.*;
class Solution414 {
	public int thirdMax(int[] nums) {
		int m1=nums[0];
		int m2=-1;
		int m3=-1;
		int i;
		for (i=1;i< nums.length;i++){
			if (nums[i]!=m1){
				m2=nums[i];
				break;
			}
		}
		if (i== nums.length)
			return m1;

		for (i=1;i< nums.length;i++){
			if (nums[i]!=m1&&nums[i]!=m2){
				m3=nums[i];
				break;
			}
		}
		if (i== nums.length)
			return Math.max(m1,m2);

		int tempmax= Math.max(m1,Math.max(m2,m3));
		int tempmin= Math.min(m1,Math.min(m2,m3));

		m2 = m1+m2+m3-tempmax-tempmin;
		m3 = tempmin;
		m1 = tempmax;

		for (i=1;i< nums.length;i++){
			if (nums[i]==m1||nums[i]==m2||nums[i]==m3||nums[i]<m3)
				continue;
			if (nums[i]>m1){
				m3=m2;
				m2=m1;
				m1=nums[i];
				continue;
			}
			if (nums[i]>m2){
				m3=m2;
				m2=nums[i];
				continue;
			}
			if (nums[i]>m3){
				m3=nums[i];
			}
		}

		return m3;
	}
}
public class Leetcode414 {
	public static void main(String[]args){
		Solution414 sol = new Solution414();
		int[]nums = new int[]{1,2,2,-2147483648};
		System.out.println(sol.thirdMax(nums));
	}
}
