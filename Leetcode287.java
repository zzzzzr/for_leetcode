
import java.util.*;
class Solution287 {
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int i=0;
		int j=nums.length-1;
		while (i<j){
			int mid = (i+j)/2;
			if (nums[mid]<mid+1)
				j=mid;
			else
				i=mid+1;
		}
		return nums[i];
	}

	// https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
	public int findDuplicate1(int[] nums) {
		int n = nums.length;
		// 数组数字范围 1-n，n=nums.length-1
		int l = 1, r = n - 1, ans = -1;
		while (l <= r) {
			// mid=（l+r）/2
			// 假设数组没有多余的数字，则每个数字都出现，那么比 mid 小的数字的个数恰为 mid-1，比 mid 大的数字个数恰为 n-mid
			int mid = (l + r) >> 1;
			// cnt 用来计算比 mid 小的数字的个数
			int cnt = 0;

			//System.out.println(l+" "+r+" "+mid+" "+cnt+" "+ans);

			// 计算 <=mid 的数字的个数
			for (int i = 0; i < n; ++i) {
				if (nums[i] <= mid) {
					cnt++;
				}
			}
			// <=mid 的数字个数在没有重复数字的情况下应为 mid
			// 如果 <=mid 的数字个数 <=mid，则说明左边没有多出数字，问题出在右边的区间
			if (cnt <= mid) {
				l = mid + 1;
			}
			// 否则，左边的数字过多，重复数字在左边的区间
			else {
				r = mid - 1;
				ans = mid;
			}

		}
		return ans;
	}

	public int findDuplicate2(int[] nums) {
		int slow=0;
		int fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while (slow!=fast);
		slow=0;
		while (slow!=fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
public class Leetcode287 {
	public static void main(String []args){
		int []nums = {3,1,3,4,2};
		Solution287 sol = new Solution287();
		System.out.println(sol.findDuplicate1(nums));
	}
}
