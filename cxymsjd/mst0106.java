package cxymsjd;
import java.util.*;
class Solution0106 {
	public String compressString(String S) {
		StringBuilder strb = new StringBuilder();
		int len = S.length();
		int index=0;
		while (index<len){
			char ch = S.charAt(index);
			int count=0;
			while (S.charAt(index)==ch){
				index++;
			}
			strb.append(ch);
			strb.append(count);
		}
		if (strb.length()>=len){
			return S;
		}else {
			return strb.toString();
		}
	}
}
public class mst0106 {
}
