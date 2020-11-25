package Leetcode;

import java.util.*;
class Solution1370 {
	public String sortString(String s) {
		int []count = new int['z'+2];
		int len = s.length();
		for (int i=0;i<len;i++){
			count[s.charAt(i)]++;
		}
		char lowwerbound='a'-1;
		char upperbound = 'z'+1;
		StringBuilder stb = new StringBuilder();
		int flag=1;
		System.out.println((int)'a'+" "+(int)'z');
		for (char i='a';i<=upperbound && i>=lowwerbound && len>0;i+=flag){
			if (count[i]>0){
				stb.append(i);
				count[i]--;
				len--;
				System.out.println(Arrays.toString(count));
				System.out.println(len+" "+(int)lowwerbound+" "+(int)upperbound);
			}
			if (i==upperbound ) {
				flag = -1;
				while (count[upperbound-1]==0) {
					upperbound--;
				}
				i=upperbound;
			}
			if (i==lowwerbound ) {
				flag = 1;
				while (count[lowwerbound+1]==0) {
					lowwerbound++;
				}
				i=lowwerbound;
			}
		}
		return stb.toString();
	}
}
public class Leetcode1370 {
	public static void main(String []args){
		String s="aaaabbbbcccc";
		Solution1370 sol = new Solution1370();
		System.out.println(sol.sortString(s));
	}
}
