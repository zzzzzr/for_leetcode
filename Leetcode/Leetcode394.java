package Leetcode;

class Solution394 {
	public String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++){
//			System.out.println(sb);
			// 是普通的字符
			if (Character.isLetter(s.charAt(i))){
				sb.append(s.charAt(i));
			}
			// 是数字，就把数字和后面的中括号以及中括号里的内容加载出字符串再返回
			else if (Character.isDigit(s.charAt(i))){
				int num=0;
				while (Character.isDigit(s.charAt(i))){
					num = num*10+(s.charAt(i)-'0');
					i++;
				}
//				System.out.println(num);
				int startindex=i+1;
				int endindex=i+1;
				int time=1;
				while (time!=0){
					if (s.charAt(endindex)==']')
						time--;
					if (s.charAt(endindex)=='[')
						time++;
					endindex++;
				}
//				System.out.println(startindex+" "+(endindex-1));
				String temp = decodeString(s.substring(startindex,endindex-1));
				for (int j=0;j<num;j++){
					sb.append(temp);
				}
				i=endindex-1;
//				System.out.println(i);
			}
		}
		return sb.toString();
	}
}

public class Leetcode394 {
	public static void main(String []args){
		Solution394 sol = new Solution394();
		String s = 	"100[leetcode]";
		// "100[leetcode]";
		// "abc3[cd]xyz";
		// "2[abc]3[cd]ef";
		// "3[a2[c]]";
		// "3[a]2[bc]";
		System.out.println(sol.decodeString(s));
	}
}
