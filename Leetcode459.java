import java.util.*;
class Solution459 {
	public boolean repeatedSubstringPattern(String s) {
		if (s==null)
			return false;
		for(int i=1;i<=s.length()/2;i++){
			String pattern = s.substring(0,i);
			if(s.length()%i!=0)
				continue;
			//System.out.println(i);
			boolean flag = true;
			for(int j = i;j<s.length();j+=i){
				if(!pattern.equals(s.substring(j,j+i))){
					flag=false;
					break;
				}
			}
			if (flag)
				return true;
		}
		return false;
	}
}
public class Leetcode459 {
	public static void main(String []args){
		String s = "abcabcabcabc";
		Solution459 sol = new Solution459();
		System.out.println(sol.repeatedSubstringPattern(s));
	}
}
