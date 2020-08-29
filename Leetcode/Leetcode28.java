package Leetcode;

import java.util.*;
class Solution28 {
	public int strStr(String haystack, String needle) {
		if(needle.length()<=0)
			return 0;
		return kmp(haystack,needle);
	}
	public int[] build_next(String p){
		int[]next = new int[p.length()];
		next[0]=-1;
		int i=0,j=-1;

		while (i<p.length()-1){
			if (j==-1 || p.charAt(i)==p.charAt(j)){
				i++;
				j++;
				next[i] = j;
			}
			else
				j=next[j];
		}

		return next;
	}
	public int kmp(String s1,String s2){
		if (s2==null)
			return 0;
		if (s2.length()<=0||s1.length()<s2.length())
			return -1;

		int []next = build_next(s2);

		int index1=0,index2=0;
		while (index1<s1.length()&&index2<s2.length()){
			if (index2==-1 ||s1.charAt(index1)==s2.charAt(index2)){
				index1++;
				index2++;
			}
			else
				index2=next[index2];
		}
		if (index2==s2.length())
			return index1-index2;

		return -1;
	}
}
public class Leetcode28 {
}
