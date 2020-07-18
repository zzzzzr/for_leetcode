import java.util.*;
class Solution9 {
	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		String num=""+x;
		int len=num.length();
		int l=0;
		int r=len-1;
		boolean flag=true;
		while(l<r){
			if(num.charAt(l)==num.charAt(r)){
				l++;
				r--;
			}
			else{
				return false;
			}
		}
		return true;
	}
}
public class Leetcode9 {
	public static void main(String []args){
		int numrows=10;
		Solution9 sol=new Solution9();
		//System.out.println(""+numrows);
		System.out.println(sol.isPalindrome(numrows));
	}
}
