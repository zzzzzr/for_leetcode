package Leetcode;

import java.util.*;
class Solution873 {
	public int lenLongestFibSubseq1(int[] A) {
		int len = A.length;
		int ans = 0;

		Map<Integer,Integer> mapp = new HashMap<>();
		for (int i=0;i<len;i++)
			mapp.put(A[i],i);

		int [][]dp = new int[len][len];
		for (int []arr:dp)
			Arrays.fill(arr,2);
		// dp[i][j]:以下标为 j k 的数组 A 的元素结束的数列的长度

		for (int k=2;k<len;k++){
			for (int j=1;j<k;j++){
				int i = mapp.getOrDefault(A[k]-A[j],-1);
				if (i!= -1 && i<j){
					dp[j][k] = dp[i][j]+1;
					ans = Math.max(ans,dp[j][k]);
				}
			}
		}
//		System.out.println("  "+Arrays.toString(A));
//		for (int i=0;i<A.length;i++)
//			System.out.println(A[i]+" "+Arrays.toString(dp[i]));
		return ans;
	}

	public int lenLongestFibSubseq(int[] A) {
		int ans=0;
		int tempmax;
		int start1;
		int start2;

		Set<Integer> sett = new HashSet<>();
		for (int num:A)
			sett.add(num);

		for (start1 = 0;start1<A.length-1-ans;start1++){
			for (start2 = start1+1;start2<A.length;start2++){
				int p = A[start1];
				int q = A[start2];
				int temp = p+q;
				if (!sett.contains(temp))
					continue;
				int i=findNum(A,temp,start2);
//				if (i==-1)
//					continue;
				tempmax=2;
				while (true){
					tempmax++;
					p=q;
					q=temp;
					temp = p+q;
					if (!sett.contains(temp))
						break;
					i = findNum(A,temp,i);
				}
				ans = Math.max(ans,tempmax);
			}
		}
		return ans;
	}
	public int findNum(int []a,int target,int begin){
		for (int i=begin;i<a.length;i++){
			if (a[i]==target)
				return i;
		}
		return -1;
	}
}
public class Leetcode873 {
	public static void main(String []args){
		int []num = {1,2,3,4,5,6,7,8};
		// {1,3,7,11,12,14,18};
		// {1,2,3,4,5,6,7,8};
		Solution873 sol = new Solution873();
		System.out.println(sol.lenLongestFibSubseq1(num));
	}
}
