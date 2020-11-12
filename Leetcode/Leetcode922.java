package Leetcode;

import java.util.*;
class Solution922 {
	public int[] sortArrayByParityII_1(int[] A) {
		int index1=0,index2=1;
		for (;index1<A.length;index1+=2){
			if (A[index1]%2!=0){
				while (A[index2]%2!=0)
					index2+=2;
				int temp = A[index1];
				A[index1] = A[index2];
				A[index2] = temp;
			}
		}
		return A;
	}

	public int[] sortArrayByParityII(int[] A) {
		int index1=0,index2=1;
		while (index1<A.length && index2<A.length){
			while (index1<A.length && A[index1]%2==0)
				index1+=2;
			while (index2<A.length && A[index2]%2!=0)
				index2+=2;
			if (index1>A.length || index2>A.length)
				break;
			int temp = A[index1];
			A[index1] = A[index2];
			A[index2] = temp;
		}
		return A;
	}
}
public class Leetcode922 {
	public static void main(String []args){
		Solution922 sol = new Solution922();
		int []nums={4,2,5,7};
		System.out.println(Arrays.toString(sol.sortArrayByParityII(nums)));
	}
}
