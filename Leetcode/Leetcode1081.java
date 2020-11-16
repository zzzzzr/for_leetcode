package Leetcode;

import java.util.*;
// 和 Leetcode316 是同一题
class Solution1081 {
	public String smallestSubsequence(String s) {
		char []stack = new char[26];
		boolean []used = new boolean[26];
		int []loc = new int[26];
		for (int i=0;i<s.length();i++){
			loc[s.charAt(i)-'a']=i;
		}
		// 索引栈顶元素的下标
		int index=0;
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (!used[ch-'a']){
				//System.out.println(Arrays.toString(stack));
				//System.out.println(Arrays.toString(used));
				while (index>0 && ch < stack[index-1] && loc[stack[index-1]-'a']>i) {
					index--;
					used[stack[index]-'a']=false;
					stack[index]=0;
				}
				stack[index]=ch;
				used[ch-'a']=true;
				index++;
			}
		}
		StringBuilder ans = new StringBuilder(index);
		for (int i=0;i<index;i++)
			ans.append(stack[i]);
		return ans.toString();
	}
}
public class Leetcode1081 {
}
