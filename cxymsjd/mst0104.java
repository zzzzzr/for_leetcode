package cxymsjd;
import java.util.*;
class Solution0104 {
	public boolean canPermutePalindrome1(String s) {
		boolean []arr = new boolean[128];
		for (int i=0;i<s.length();i++) {
			int ch = s.charAt(i)-'a';
			arr[ch] = !arr[ch];
		}
		int flag=0;
		for (int i=0;i<128;i++){
			if (arr[i]) {
				flag++;
				if (flag>1){
					return false;
				}
			}
		}
		return true;
	}

	public boolean canPermutePalindrome(String s) {
		Map<Character,Integer> mapp = new HashMap<>();
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			mapp.put(ch,mapp.getOrDefault(ch,0)+1);
		}
		int flag=0;
		for (Integer i: mapp.values()){
			if (i%2!=0){
				flag++;
				if (flag>1){
					return false;
				}
			}
		}
		return true;
	}
}
public class mst0104 {
}
