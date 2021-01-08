package Leetcode;

import java.util.*;
class Solution1137{
	public int tribonacci(int n) {
		if (n<=1)
			return n;
		if (n==2)
			return 1;
		int p=0;
		int q=1;
		int r=1;
		int s;
		for (int i=3;i<=n;i++){
			s = p + q + r;
			p = q;
			q = r;
			r = s;
		}
		return r;
	}
}
public class Leetcode1137 {
}
