package Leetcode;
// 荷兰国旗问题
// 对数组的使用还是有欠缺
import java.util.*;
class Solution75 {
	public void sortColors(int[] nums) {
		if (nums.length<=0)
			return;
		int num1=0,num2=0;
		for (int ele:nums){
			if (ele==1)
				num1++;
			else if (ele==2)
				num2++;
		}
		for (int i=0;i<num1;i++)
			nums[i]=0;
		for (int i=num1;i<num2+num1;i++)
			nums[i]=1;
		for (int i =num2;i<nums.length;i++)
			nums[i]=2;
	}

	public void sortColors1(int[] nums) {
		if (nums.length<=0)
			return;
		int low=0;
		int high = nums.length-1;
		int cur = 0;
		while (cur<=high){
			if (nums[cur]==0){
				swap(nums,cur,low);
				low++;
				cur++;
			}
			else if (nums[cur]==2){
				swap(nums,cur,high);
				high--;
			}
			else cur++;
		}
	}

	public void swap(int[]nums,int i,int j){
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
public class Leetcode75 {
	public static void main(String []args){
		int []num = {0,0,1,2,1,1,2};
		//{2,0,2,1,1,0};
		//{0,0,1,2,1,1,2};
		Solution75 sol = new Solution75();
		sol.sortColors1(num);
		System.out.println(Arrays.toString(num));
	}
}
