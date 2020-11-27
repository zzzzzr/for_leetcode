package JZoffer;

import java.util.*;
class SolutionJZoffer61 {
	public boolean isStraight1(int[] nums) {
		int []count= new int[14];
		int min=15;
		int max=nums[0];
		for (int i:nums){
			if (i!=0) {
				if (count[i]>0)
					return false;
				count[i]++;
				if (i < min)
					min = i;
				if (i > max)
					max = i;
			}
		}
		return (max-min)<=4;
	}

	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int index;
		int count=0;
		for (index=0;index<5;index++){
			if (nums[index]==0){
				count++;
			}
			else break;
		}
		for (int i=index;i<5-1;i++){
			if (nums[i+1]-nums[i]==1)
				continue;
			if (nums[i+1]-nums[i]<=count){
				count-=(nums[i+1]-nums[i]);
			}
			else {
				break;
			}
		}
		return index==5;

	}
}
public class JZoffer61 {
}
