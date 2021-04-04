package Leetcode;

import java.util.*;
class Solution59 {
	public int[][] generateMatrix(int n) {
		int [][]ans = new int[n][n];
		int id=1;
		int start=0,end=n-1;
		while (start<=end){
			for (int i=start;i<end;i++){
				ans[start][i]=id;
				id++;
			}
			for (int i=start;i<end;i++){
				ans[i][end]=id;
				id++;
			}
			for (int i=end;i>start;i--){
				ans[end][i]=id;
				id++;
			}
			for (int i=end;i>start;i--){
				ans[i][start]=id;
				id++;
			}
			start++;
			end--;
		}
		if (n%2==1)
			ans[n/2][n/2]=id;
		return ans;
	}
}
public class Leetcode59 {
	public static void main(String []args){
		int n=4;
		Solution59 sol = new Solution59();
		int [][]arr = sol.generateMatrix(n);
		for (int []ar:arr){
			System.out.println(Arrays.toString(ar));
		}
	}
}
