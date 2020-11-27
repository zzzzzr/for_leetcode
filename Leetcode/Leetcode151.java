package Leetcode;

import java.util.*;
class Solution151 {
	public String reverseWords(String s) {
		s= s.trim();
		if (s.length()<=0)
			return "";
		StringBuilder stb = new StringBuilder();
		int endindex = s.length()-1;
		int startindex;
		while (endindex>=0) {
			while (endindex>=0 && s.charAt(endindex) == ' ')
				endindex--;
			startindex = endindex;
			while (startindex>=0 && s.charAt(startindex) != ' ')
				startindex--;

			stb.append(s, startindex + 1, endindex + 1);
			//if (startindex != endindex)
			stb.append(' ');
			endindex=startindex;
		}
		if(stb.length()==0)
			return "";
		else
			return stb.toString().trim();
	}
}

public class Leetcode151 {
}
