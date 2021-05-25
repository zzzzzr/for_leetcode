package Leetcode;

import java.util.*;

class Solution668{

	/*
	对于一个乘法表的每一行，他的数字都是一个以第一个数字 i 为公因数的等比数列
	那么对于一个数字 target， target/ 第一个数字 i 的结果就是在这一行里小于等于 target 的数字的个数
	为了避免 target 过大， 以 Math.min(target/i, n) 表示这一行里小于等于 target 的数字的个数
	对每一行都用上面的方式进行计算，就能得到在整个乘法表矩阵里小于等于某个数字的个数
	然后使用二分法，以乘法表的最小最大元素为两端，对 k 进行二分查找，直到找到为止
	 */
	public int findKthNumber(int m, int n, int k) {
		int left=1;
		int right= m*n+1;
		while (left < right){
			int mid = (left + right)/2;
			if (getSmallerSum(m,n,mid) >= k){
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		return left;
	}

	public int getSmallerSum(int m, int n, int target){
		int ans=0;
		for (int i=1;i<=m;i++){
			ans += Math.min(target / i, n);
		}
		return ans;
	}

	// 空间复杂度过高
	public int findKthNumber1(int m, int n, int k) {
		int []table = new int[m*n];
		for (int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				table[(i-1) *n + (j-1)] = i*j;
			}
		}
		// System.out.println(Arrays.toString(table));
		Arrays.sort(table);
		return table[k-1];
	}
}
public class Leetcode668 {
	public static void main(String[] args) {
		int m=3;
		int n=3;
		int k=5;
		Solution668 sol = new Solution668();
		System.out.println(sol.findKthNumber(m, n, k));
	}
}
