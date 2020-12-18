package Leetcode;
import java.util.*;
class Solution27 {
	public int removeElement(int[] nums, int val) {
		int index1,index2=0;
		for (index1=0;index1< nums.length;index1++){
			if (nums[index1]!=val){
				nums[index2]=nums[index1];
				index2++;
			}
		}
		return index2;
	}
}
public class Leetcode27 {
}
