package JZoffer;
// 与 Leetcode003 一样
import java.util.*;
class SolutionJZoffer48 {
	public int lengthOfLongestSubstring(String s) {
		int i,j;
		Map<Character, Integer> mapp = new HashMap<>();
		int ans=0;
		char []ch = s.toCharArray();
		for (i=0,j=0;j<s.length();j++){
			if (mapp.containsKey(ch[j])){
				i = Math.max(mapp.get(ch[j])+1,i);
			}
			ans  = Math.max(j-i+1,ans);
			mapp.put(ch[j],j);
			System.out.println(i+" "+j+" "+ans+" "+mapp.toString());
		}
		return ans;
	}
}
public class JZoffer48 {
	public static void main(String[]args){
		String s="pwwkew";
		SolutionJZoffer48 sol = new SolutionJZoffer48();
		System.out.println(sol.lengthOfLongestSubstring(s));
	}
}
