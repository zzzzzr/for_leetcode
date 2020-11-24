package Leetcode;

class Solution389 {
	// a-z 97-122
	public char findTheDifference(String s, String t) {
		int sum=0;
		for (int i=0;i<t.length();i++)
			sum+=t.charAt(i);
		for (int i=0;i<s.length();i++)
			sum-=s.charAt(i);
		return (char)(sum);

	}
	public char findTheDifference1(String s, String t) {
		int []count = new int[150];
		for (int i=0;i<t.length();i++)
			count[t.charAt(i)]++;
		for (int i=0;i<s.length();i++)
			count[s.charAt(i)]--;
		for (char ch='a';ch<='z';ch++)
			if (count[ch]==1)
				return ch;
		return ' ';
	}

	public char findTheDifference2(String s, String t) {
		int ch=0;
		for (int i=0;i<s.length();i++)
			ch^=s.charAt(i);
		for (int i=0;i<t.length();i++)
			ch^=t.charAt(i);
		return (char)ch;
	}
}
public class Leetcode389 {
	public static void main(String []args){
		// s = "abcd", t = "abcde"
		String s="abcd";
		String t="abcde";
		Solution389 sol = new Solution389();
		System.out.println(sol.findTheDifference2(s,t));
	}
}
