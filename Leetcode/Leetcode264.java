package Leetcode;

import java.util.*;
class Solution264{
	public int nthUglyNumber(int n) {
		int []ug = new int[1691];
		ug[1]=1;
		int index2=1,index3=1,index5=1;
		for (int i=2;i<=n;i++){
			int ugnew =Math.min(ug[index2]*2,Math.min(ug[index3]*3,ug[index5]*5));
			ug[i]=ugnew;
			if (ugnew==ug[index2]*2)
				index2++;
			if (ugnew==ug[index3]*3)
				index3++;
			if (ugnew==ug[index5]*5)
				index5++;
		}
		System.out.println(Arrays.toString(ug));
		return ug[n];
	}
}
public class Leetcode264 {
}
