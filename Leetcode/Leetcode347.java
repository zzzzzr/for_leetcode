package Leetcode;

import java.util.*;
class Solution347 {
	int []ans;
	int index=0;
	public int[] topKFrequent(int[] nums, int k) {
		ans = new int[k];
		HashMap<Integer,Integer> maap = new HashMap<>();
		for (int i:nums){
			if (!maap.containsKey(i))
				maap.put(i,1);
			else
				maap.put(i,maap.get(i)+1);
		}

//		System.out.println(maap.keySet());
//		System.out.println(maap.values());

		int [][]keys = new int[maap.size()][2];
		int j =0;
		for (int i: maap.keySet()) {
			keys[j][0] = i;
			keys[j][1] = maap.get(i);
			j++;
		}

//		for (int[] arr:keys)
//			System.out.println(Arrays.toString(arr));

		find(k,0,maap.size()-1,keys);

//		for (int i=0;i<ans.length;i++){
//			ans[i] = maap.get(ans[i]);
//		}
		return ans;
	}

	public void find(int k,int start,int end,int[][]nums){
		int low=start;
		int high = end;
		int pivot = nums[start][1];
		int pivot1 = nums[start][0];
		//System.out.println(start+" "+end);
		while(low<high){
			while(low<high&&nums[high][1]<=pivot)
				high--;
			nums[low][1]=nums[high][1];
			nums[low][0]=nums[high][0];
			while (low<high && nums[low][1]>=pivot)
				low++;
			nums[high][1]=nums[low][1];
			nums[high][0]=nums[low][0];

		}
		nums[low][1] = pivot;
		nums[low][0] = pivot1;

		if (low==k-1){
//			for (int[] arr:nums)
//				System.out.println(Arrays.toString(arr));
			for (int i=0;i<k;i++){
				ans[i] = nums[i][0];
				//System.out.println(nums[i][1]);
			}
		}
		else if (low<k-1){
			find(k, low+1, end, nums);
		}
		else {
			find(k, start, low-1, nums);
		}
	}

}
public class Leetcode347 {
	public static void main(String []args){
		int []nums = {-1,-1};
		//{1,1,1,2,2,3};
		int k =1;
		Solution347 sol = new Solution347();
		System.out.println(Arrays.toString(sol.topKFrequent(nums,k)));
	}
}
