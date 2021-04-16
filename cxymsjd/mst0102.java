package cxymsjd;
import java.util.*;
class Solution0102 {
	public boolean CheckPermutation1(String s1, String s2) {
		int len1= s1.length();
		int len2 = s2.length();
		if(len1 != len2){
			return false;
		}
		char []ch1 = s1.toCharArray();
		char []ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		for (int i=0;i<len1;i++){
			if (ch1[i]!=ch2[i])
				return false;
		}
		return true;
	}

	public boolean CheckPermutation(String s1, String s2) {
		int len1= s1.length();
		int len2 = s2.length();
		if(len1 != len2){
			return false;
		}
		Map<Character,Integer> mapp = new HashMap<>();
		for(int i=0;i<len1;i++){
			char ch = s1.charAt(i);
			mapp.put(ch,mapp.getOrDefault(ch,0)+1);
		}
		for (int i=0;i<len2;i++){
			char ch = s2.charAt(i);
			Integer count = mapp.get(ch);
			if (count==null){
				return false;
			}
			if (count==1){
				mapp.remove(ch);
			}
			else {
				mapp.put(ch,count-1);
			}
		}
		return mapp.isEmpty();
	}
}
public class mst0102 {
}
