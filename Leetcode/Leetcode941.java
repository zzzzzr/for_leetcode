package Leetcode;

import java.util.*;
/*
执行结果：通过 显示详情
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了72.41%的用户
 */
class Solution941 {
	public boolean validMountainArray(int[] A) {
		if (A.length<3)
			return false;
		int i;
		for (i=0;i<A.length-1;i++){
			if (A[i]>=A[i+1])
				break;
		}
		if (i==0||i==A.length-1)
			return false;
		for (;i<A.length-1;i++){
			if (A[i]<=A[i+1])
				return false;
		}
		return true;
	}
}
public class Leetcode941 {
}
