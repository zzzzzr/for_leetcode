package algorithm_datastructure;

import java.util.Arrays;

public class QuickSort {
	// start 数组开始的下标，最初为0
	// end 数组结束的下标，最初为n-1
	// 找到数组中第k大的数字，平均时间复杂度为O(n)，最差时间复杂度为O(n^2)
	public static int quickFind(int[]nums,int k,int start,int end){
		int pivot=nums[start],low=start,high=end;
		while(low<high){
			while(low<high&&nums[high]>=pivot)
				high--;
			nums[low]=nums[high];
			while (low<high&&nums[low]<=pivot)
				low++;
			nums[high]=nums[low];
		}
		nums[low]=pivot;
		if (low==k-1){
			System.out.println(Arrays.toString(nums));
			System.out.println(low);
			return pivot;
		}
		else if (low>k-1)
			return quickFind(nums, k, start, low-1);
		else
			return quickFind(nums, k, low+1, end);
	}

	public static void main(String []args){

	}
}
