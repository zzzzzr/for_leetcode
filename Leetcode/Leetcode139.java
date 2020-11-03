package Leetcode;

import java.util.*;
class Solution139 {
	public boolean wordBreak1(String s, List<String> wordDict) {
		Set<String> sett = new HashSet<>(wordDict);
		boolean []dp = new boolean[s.length()+1];
		dp[0]=true;
		for (int i=1;i<=s.length();i++){
			for (int j=0;j<i;j++){
				if (dp[j]&&sett.contains(s.substring(j,i))){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	// 超时
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length()<=0)
			return true;

		for (int i=1;i<=s.length();i++){
			if (wordDict.contains(s.substring(0,i))){
				System.out.println(s.substring(0,i));
				if (wordBreak(s.substring(i),wordDict))
					return true;
			}
		}
		return false;
	}
}
public class Leetcode139 {
	public static void main(String[]args){
		// s = "leetcode", wordDict = ["leet", "code"]
		String s = "leetcode";
		List<String> wordDict = new LinkedList<>();
		wordDict.add("leet");
		wordDict.add("code");

		Solution139 sol = new Solution139();
		System.out.println(sol.wordBreak(s,wordDict));
	}
}
