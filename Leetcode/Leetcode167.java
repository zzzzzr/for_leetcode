package Leetcode;

import java.util.*;
class Solution167 {
	public int[] twoSum(int[] numbers, int target) {
		if(numbers.length<2)
		{
			return null;
		}
		int i=0;
		int j=numbers.length-1;
		while (i<j){
			if(numbers[i]+numbers[j]<target){
				i++;
			}
			else if(numbers[i]+numbers[j]>target){
				j--;
			}
			else {
				return new int[]{i+1,j+1};
			}
		}
		return null;
	}
	public int[] twoSum_1(int[] numbers, int target) {
		if(numbers.length<2)
		{
			return null;
		}
		int []ans=new int[2];
		//int index1,index2;
		for(int i=0;i<numbers.length;i++){
			for(int j=numbers.length-1;j>i;j--){
				if(numbers[i]+numbers[j]==target){
					ans[0]=i+1;
					ans[1]=j+1;
					return ans;
				}
			}
		}
		return ans;
	}
}
public class Leetcode167 {
	public static void main(String []args){
		int []test=new int []{1,2,5,6};
		int tar=6;
		Solution167 sol=new Solution167();
		System.out.println(Arrays.toString(sol.twoSum(test, tar)) );
	}
}
