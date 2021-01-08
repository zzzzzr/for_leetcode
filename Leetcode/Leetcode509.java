package Leetcode;

import java.util.*;
class Solution509 {
	public int fib(int n) {
		if (n<=1)
			return n;
		int p=0;
		int q=1;
		int r;
		for (int i=2;i<=n;i++){
			r = p+q;
			p=q;
			q=r;
		}
		return q;
	}
}
public class Leetcode509 {
}
