package JZoffer;

import java.util.*;
class SolutionJZoffer50 {
	public char firstUniqChar1(String s) {
		char []ch = s.toCharArray();
		int []count = new int[256];
		for (char c:ch){
			count[c]++;
		}
		for (char c:ch){
			if (count[c]==1)
				return c;
		}
		return ' ';
	}

	public char firstUniqChar(String s) {
		char []ch = s.toCharArray();
		int []count = new int[26];
		for (int i=0;i<s.length();i++){
			count[ch[i]-'a']++;
		}
		for (int i=0;i<s.length();i++){
			if (count[ch[i]-'a']==1)
				return ch[i];
		}
		return ' ';
	}
}
public class JZoffer50 {
}