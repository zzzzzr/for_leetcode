package cxymsjd;
import java.util.*;
class Solution0103 {
	public String replaceSpaces1(String S, int length) {
		char []arr = new char[S.length()];
		System.out.println(S.length());
		int index=0;
		for (int i=0;i<length;i++){
			char ch = S.charAt(i);
			if (ch!=' '){
				arr[index] = ch;
				index++;
			}
			else {
				arr[index] = '%';
				index++;
				arr[index] = '2';
				index++;
				arr[index] = '0';
				index++;
			}
		}
		return new String(arr,0,index);
	}

	public String replaceSpaces(String S, int length) {
		StringBuilder strb = new StringBuilder();
		for (int i=0;i<S.length() && length!=0;i++){
			char ch = S.charAt(i);
			if (ch!=' '){
				strb.append(ch);
			}
			else{
				strb.append("%20");

			}
			length--;
		}
		while (length!=0){
			strb.append("%20");
			length--;
		}
		return strb.toString();
	}
}
public class mst0103 {
	public static void main(String[] args) {
		Solution0103 sol = new Solution0103();
		// "ds sdfs afs sdfa dfssf asdf             "
		//27
		String s = "ds sdfs afs sdfa dfssf asdf             ";
		int len = 27;
		System.out.println(sol.replaceSpaces1(s,len));
	}
}
/*
"ds%20sdfs%20afs%20sdfa%20dfssf%20asdf"
"ds%20sdfs%20afs%20sdfa%20dfssf%20asdf\u0000\u0000\u0000"
 */