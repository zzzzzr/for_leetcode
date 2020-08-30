package Leetcode;

class Solution557 {
	public String reverseWords(String s) {
		if (s==null||s.length()<=0)
			return null;
		StringBuilder ans = new StringBuilder();
		//char[]str = s.toCharArray();

		int start = 0,end = 0;


		while(start<s.length()&&end<s.length()) {
			start=end;
			while (start<s.length()&&s.charAt(start)==' ')
				start++;
			ans.append(s, end, start);

			end = start;
			while(end<s.length()&&s.charAt(end)!=' ')
				end++;
			ans.append(new StringBuilder(s.substring(start,end)).reverse());
		}
		return ans.toString();
	}
}
public class Leetcode557 {
	public static void main(String[]args){
		Solution557 sol = new Solution557();
		String s = "                                            ";
		//"Let's take LeetCode contest";
		//"i like dy";
		System.out.println(sol.reverseWords(s));
		System.out.println(sol.reverseWords(s).length());
		System.out.println(s.length());
	}
}
