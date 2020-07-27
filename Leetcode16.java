import java.lang.reflect.Array;
import java.util.*;
class Solution16 {
	public int threeSumClosest(int[] nums, int target) {
		if(nums.length==3){
			return nums[0]+nums[1]+nums[2];
		}
		int target1;
		int target2;
		Arrays.sort(nums);
		for(int i=0;;i++){
			target1=target-i;
			target2=target+i;
			if(threeSum(nums,target1)){
				return target1;
			}
			if(threeSum(nums,target2)){
				return target2;
			}
		}
//		return target;
	}
	public boolean threeSum(int [] nums,int target){
		int i,j,k;
		for(i=0;i<nums.length-2;i++){
			if(i>0&&nums[i]==nums[i-1]){
				i++;
			}
			j=i+1;
			k=nums.length-1;
			while (j<k) {
				if (nums[j] + nums[k] +nums[i] == target) {
					return true;
				}
				else if(nums[j] + nums[k] +nums[i] < target){
					j++;
					while (j<nums.length&&nums[j]==nums[j-1]){
						j++;
					}
				}
				else //if(nums[j] + nums[k] > -nums[i])
				{
					k--;
					while (k>=0&&nums[k]==nums[k+1]){
						k--;
					}
				}
			}
		}
		return false;
	}
}
public class Leetcode16 {
	public static void main(String []args){
		int []test=new int []{-1,2,1,-4};
		//{1,2,5,6};
		int tar=1;
		Solution16 sol=new Solution16();
		System.out.println(sol.threeSumClosest(test, tar));
	}
}
