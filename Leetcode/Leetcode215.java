package Leetcode;
// https://blog.csdn.net/orangefly0214/article/details/86527462
import java.util.*;
class Solution215 {
	public int findKthLargest(int[] nums, int k) {
		if (nums.length<=0)
			return -1;
		Arrays.sort(nums);
		return nums[nums.length-k];
	}

	public int findKthLargest1(int[] nums, int k) {
		PriorityQueue<Integer> que = new PriorityQueue<>(k);
		for (int i=0;i<k;i++){
			que.add(nums[i]);
		}
		for (int i=k;i< nums.length;i++){
			if (nums[i]<que.peek())
				continue;
			que.poll();
			que.offer(nums[i]);
		}
		return que.peek();
	}

	public int findKthLargest2(int[] nums, int k) {
		return quicksort(nums, nums.length-k+1,0,nums.length-1);
	}
	public int quicksort(int[]nums,int k,int start,int end){
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
			return quicksort(nums, k, start, low-1);
		else
			return quicksort(nums, k, low+1, end);
	}
}

public class Leetcode215 {
	public static void main(String []args){
		int []nums = new int[]{3,2,3,1,2,4,5,5,6};
		//{3,2,1,5,6,4};
		//{3,2,3,1,2,4,5,5,6};
		Solution215 sol = new Solution215();
		System.out.println(sol.findKthLargest2(nums,4));
	}
}
