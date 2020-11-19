package JZoffer;

import java.util.*;
class SolutionJZoffer57 {
	public int[] twoSum(int[] nums, int target) {
		int index1=0;
		int index2= nums.length-1;
		while(index1<index2){
			if (nums[index1]+nums[index2]>target)
				index2--;
			else if (nums[index1]+nums[index2]<target)
				index1++;
			else
				return new int[]{index1,index2};
		}
		return null;
	}
}
public class JZoffer57_1 {
}
