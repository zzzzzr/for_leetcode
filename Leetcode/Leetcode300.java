package Leetcode;

import java.util.*;
/*
一道类似于滑动窗口的题目
先向初始化窗口数组中加入第一个元素，然后遍历接下来的原数组元素
如果原数组元素比当前窗口最后一个元素还要大，则说明之前形成的窗口还可以扩充，则将当前原数组元素加到窗口数组最后
否则，当前窗口数组中存在一个位置，可以将当前原数组元素插入进去，找到这个位置，并插入这个元素
但是，这样插入后的数组并不是一个合理的数组,因为不能保证插入后的数组总能找到像之前一样长的子序列
但是，这样符合要求的子序列是存在过的，所以维持窗口数组的长度是合理的
我们要做的是在接下来的遍历中继续寻找可能的元素并加以操作：
如果满足条件一，则添加，扩充长度，这可以理解为在并没有插入新元素的情况下增长了数组长度，因为窗口长度其实是维持了旧长度的
如果满足条件二，则插入，这就相当于是在插入新元素的情况下继续为窗口数组换血
插入操作的主要目的一方面是维持曾经窗口的长度，这至少是曾经存在的
另一方面是在换血后让窗口数组能够适应将来潜在的更好的新序列
 */
class Solution300 {
	public int lengthOfLIS2(int[] nums) {
		if (nums==null ||nums.length<=0 )
			return 0;
		int []window = new int[nums.length];
		int len=0;
		window[0] = nums[0];
		for (int i=1;i< nums.length;i++){
			if (nums[i]>window[len]){
				len++;
				window[len] = nums[i];
			}
			else{
				int id = binarySearch1(window, nums[i], len);
				window[id] = nums[i];
			}
			System.out.println(Arrays.toString(window));
		}
		return len+1;
	}
	public int binarySearch1(int []window, int num, int size){
		int low=0, high = size+1, mid;
		while (low<high){
			mid = (low+high)/2;
			if (window[mid]<num){
				low=mid+1;
			}else {
				high=mid;
			}
		}
		return low;
	}

	public int lengthOfLIS1(int[] nums) {
		if (nums==null ||nums.length<=0 )
			return 0;
		List<Integer> lis = new LinkedList<>();
		lis.add(nums[0]);
		int size=0;
		for (int i=1;i< nums.length;i++){
			if (nums[i]>lis.get(size)){
				lis.add(nums[i]);
				size++;
			}
			else{
				int id = binarySearch(lis, nums[i], size);
				// System.out.println(lis+" "+id+" " +nums[i]);
				lis.set(id, nums[i]);
			}
		}
		return size+1;
	}
	public int binarySearch(List<Integer> lis, int num, int size){
		int low=0, high = size+1, mid;
		while (low<high){
			mid = (low+high)/2;
			if (lis.get(mid)<num){
				low=mid+1;
			}else {
				high=mid;
			}
		}
		return low;
	}

	public int lengthOfLIS(int[] nums) {
		int []dp = new int[nums.length];
		Arrays.fill(dp,1);
		int ans=1;
		for(int i=1;i<nums.length;i++){
			for(int j=0;j<i;j++){
				if(nums[i]>nums[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

}
public class Leetcode300 {
	public static void main(String []args){
		Solution300 sol = new Solution300();
		int []num= {10,9,2,5,3,7,101,1};;
		// {7,7,7,7,7,7,7,7,7};
		// {0,1,0,3,2,3};
		// {10,9,2,5,3,7,101,18};
		System.out.println(sol.lengthOfLIS2(num));
	}
}
