package Leetcode;

import java.util.*;
class Solution1190 {

	public String reverseParentheses(String s) {
//		StringBuilder strb = new StringBuilder(s);
		char []ch = s.toCharArray();
		Stack<Integer> sta = new Stack<>();
		int len = s.length();
		for (int i=0;i<len;i++){
			if (s.charAt(i)=='('){
				sta.push(i);
			}
			else if (s.charAt(i)==')'){
				int start = sta.pop();
//				StringBuilder sub = ((StringBuilder) strb.subSequence(start, i+1)).reverse();
				reverse(ch, start, i);
//				strb.replace(start, i+1, String.valueOf(sub));
			}
		}
		StringBuilder strb = new StringBuilder();
		for (int i=0;i<len;i++){
			if (ch[i]!='(' && ch[i]!=')'){
				strb.append(ch[i]);
			}
		}
		return strb.toString();
	}

	// [start, end]
	public void reverse(char[]ch, int start, int end){
		for (int i=start+1, j=end-1; i<j; i++,j--){
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
		}
	}

}

public class Leetcode1190 {

	public static void main(String[] args) {
		Solution1190 sol = new Solution1190();
		String s = "a(bcdefghijkl(mno)p)q";
		// "(ed(et(oc))el)";
		// "(u(love)i)";
		// "(abcd)";
		System.out.println(sol.reverseParentheses(s));
	}

}
