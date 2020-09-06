package Leetcode;

import java.util.*;
class Solution22 {
	List<String> ans=new LinkedList<>();
	char []comma;

	public List<String> generateParenthesis1(int n) {
		if (n<=0)
			return ans;
		comma = new char[n*2];
		comma[0] = '(';
		dfs1(1,1,n);
		return ans;
	}

	public void dfs1(int left,int len,int n){
		if (len>=comma.length){
			//if (check())
			if (left==0)
				ans.add(String.valueOf(comma));
			return;
		}
		//System.out.println(len);
		if (left<n) {
			comma[len] = '(';
			dfs1(left + 1, len + 1,n);
		}
		if (left>0) {
			comma[len] = ')';
			dfs1(left-1,len + 1,n);
		}
	}

//	public void dfs1(StringBuilder strb,int len,int n){
//		if (len>=n){
//			ans.add(strb.toString());
//			return;
//		}
//		strb.append("()");
//		System.out.println(strb.toString());
//		dfs1(strb, len+1, n);
//		strb.delete(strb.length()-2,strb.length());
//
//		strb.append(')');
//		strb.insert(0,"(");
//		System.out.println(strb.toString());
//		dfs1(strb, len+1, n);
//		strb.deleteCharAt(0);
//		strb.deleteCharAt(strb.length()-1);
//	}


	public List<String> generateParenthesis(int n) {
		if (n<=0)
			return ans;
		comma = new char[n*2];
		comma[0] = '(';
		dfs(1);

		return ans;
	}

	public void dfs(int len){
		if (len>=comma.length){
			if (check())
				ans.add(String.valueOf(comma));
			return;
		}
		comma[len]='(';
		dfs(len+1);
		comma[len]=')';
		dfs(len+1);
	}

	public boolean check(){
		int left=0;
		int right=0;
		int i;
		for(i=0;i<comma.length;i++){
			if (comma[i]=='(')
				left++;
			else
				right++;
			if (left<right)
				break;
		}
		return i >= comma.length&&left==right;
	}
}
public class Leetcode22 {
	public static void main(String []args){
		int n=4;
		Solution22 sol = new Solution22();
		System.out.println(sol.generateParenthesis1(n));
		sol.ans = new LinkedList<>();
		System.out.println(sol.generateParenthesis(n));
	}
}
