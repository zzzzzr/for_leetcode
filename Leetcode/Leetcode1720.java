package Leetcode;

import java.util.*;
class Solution1720 {
	public int[] decode(int[] encoded, int first) {
		int []decode = new int[encoded.length+1];
		decode[0]=first;
		for (int i=1;i< encoded.length+1; i++){
			decode[i] = encoded[i-1] ^ decode[i-1];
		}
		return decode;
	}
}
public class Leetcode1720 {
	public static void main(String[] args) {
		int []encode = {6,2,7,3};
		// {1,2,3};
		int first = 4;
		Solution1720 sol = new Solution1720();
		System.out.println(Arrays.toString(sol.decode(encode, first)));
	}
}
