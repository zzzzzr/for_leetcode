package Leetcode;

class Solution65 {
	public boolean isNumber(String s) {
		char []ch = s.toCharArray();

		boolean dotStart = true;
		int numCount = 0;

		int i=0;
		if (ch[i]=='+' || ch[i]=='-'){
			i++;
		}
		for (;i< ch.length; i++){
			char c = ch[i];
			if (c=='.'){
				if (dotStart && numCount>0) {
					dotStart = false;
				} else if (dotStart && i<ch.length-1 && Character.isDigit(ch[i+1])){
					dotStart = false;
				}
				else {
					return false;
				}
			}
			else if ((c=='e' || c=='E')){
				if (numCount>0){
					return isZhengShu(ch, i+1, ch.length);
				} else {
					return false;
				}
			}
			else if ('0'<=c && c<='9'){
				numCount++;
			}
			else {
				return false;
			}
		}
		return true;
	}

	public boolean isZhengShu(char [] ch, int start, int end){
		if (start>=end){
			return false;
		}
		if (ch[start]=='+' || ch[start]=='-'){
			start++;
		}
		if (start>=end){
			return false;
		}
		for (int i=start; i<end; i++){
			if (! Character.isDigit(ch[i])){
				return false;
			}
		}
		return true;
	}

}
public class Leetcode65 {
	public static void main(String[] args) {
		Solution65 sol = new Solution65();

		String []samples1 = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", "0", ".1"};
		for (String str:samples1){
			if (!sol.isNumber(str)){
				System.out.println(str);
			}
		}

		String []samples2 = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "e", "."};
		for (String str:samples2){
			if (sol.isNumber(str)){
				System.out.println(str);
			}
		}
	}
}
