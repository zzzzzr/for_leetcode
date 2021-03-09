package Leetcode;

import java.util.*;
class Solution1047 {
	public String removeDuplicates3(String S) {
		char []arr = new char[S.length()];
		int top=-1;
		for (int i=0;i<S.length();i++){
			if (top>=0 && arr[top]==S.charAt(i)){
				top--;
			}
			else {
				top++;
				arr[top] = S.charAt(i);
			}
		}
		return new String(arr,0,top+1);
	}

	public String removeDuplicates2(String S) {
		StringBuilder strb = new StringBuilder();
		int top=-1;
		for (int i=0;i<S.length();i++){
			if (top>=0 && strb.charAt(top)==S.charAt(i)){
				strb.deleteCharAt(top);
				top--;
			}
			else {
				strb.append(S.charAt(i));
				top++;
			}
		}
		return strb.toString();
	}

	public String removeDuplicates1(String S) {
		Stack<Character> sta = new Stack<>();
		for (int i=S.length()-1;i>=0;i--){
			if (!sta.isEmpty() && sta.peek()==S.charAt(i)){
				sta.pop();
			}
			else {
				sta.push(S.charAt(i));
			}
		}
		StringBuilder strb = new StringBuilder();
		while (!sta.isEmpty()){
			strb.append(sta.pop());
		}
		return strb.toString();
	}

	public String removeDuplicates(String S) {
		int len = S.length();
		boolean []isdelete = new boolean[len];
		StringBuilder strb = new StringBuilder(S);
		for (int i=0;i<len-1;i++){
			if (strb.charAt(i)==strb.charAt(i+1)){
				strb.deleteCharAt(i);
				strb.deleteCharAt(i);
				len-=2;
				i= (i>=2)?(i-2):-1;
			}
		}
		return strb.toString();
	}
}
public class Leetcode1047 {
	public static void main(String []args){
		Solution1047 sol = new Solution1047();
		String s = "abbaca";
		System.out.println(sol.removeDuplicates3(s));
	}
}
