package Leetcode;

import java.util.*;
class Solution1486 {

	public int xorOperation(int n, int start) {
		int []arr = new int[n];
		int ans=start;
		arr[0] = start;
		for (int i=1;i<n;i++){
			arr[i] = arr[i-1]+2;
			ans ^= arr[i];
		}
		System.out.println(Arrays.toString(arr));
		return ans;
	}
}
public class Leetcode1486 {
	public static void main(String[] args) {
		Solution1486 sol = new Solution1486();
		int n= 4;
		int start = 3;
		System.out.println(sol.xorOperation(n,start));
	}
}
