import java.util.*;
class Solution647 {

	public int countSubstrings(String s) {
		if(s == null)
			return 0;
		int count =0;
		for(int i=0;i<s.length();i++){
			count+=huiwen_length(s,i,i);
			count+=huiwen_length(s,i,i+1);
		}
		return count;
	}
	int huiwen_length(String s,int start,int end){
		int len=0;
		while(start>=0&&end<s.length()){
			if(s.charAt(start)!=s.charAt(end))
				return len;
			start--;
			end++;
			len++;
		}
		return len;
	}


	// 暴力解法，最简单的解法
	public int countSubstrings1(String s) {
		if(s == null)
			return 0;
		int count =0;
		for(int i=0;i<s.length();i++){
			for(int j=i;j<s.length();j++){
				if(is_huiwen(s,i,j))
					count++;
			}
		}
		return count;
	}
	boolean is_huiwen(String s,int start,int end){
		while (start<end){
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
public class Leetcode647 {
	public static void main(String []args){
		Solution647 sol = new Solution647();
		String s = "aaa";
		System.out.println(sol.countSubstrings(s));
	}
}
