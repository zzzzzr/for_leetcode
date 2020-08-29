package Leetcode;

class Solution392 {
	public boolean isSubsequence(String s, String t) {
		if(s.length()<=0){
			return true;
		}
		if(t.length()<s.length()){
			return false;
		}

		int index1=0;
		int index2=0;
		//boolean status=false;
		/*
		s的字符控制大循环，t的字符不断向后寻找
		*/
		while(index1<s.length()){
			// 寻找t的对应字母
//			if(index2<t.length()) {
				// 在t中寻找和s对应位置相同的字符
				while (index2<t.length()&&t.charAt(index2) != s.charAt(index1)) {
					index2++;
				}
				if(index2>=t.length()){
					return false;
				}
				//找到了
				index1++;
				index2++;
			}
			// t到尽头了
//			else{
//				return false;
//			}
//		}

		return true;
	}
}
public class Leetcode392 {
	public static void main(String []args){
		String a="abc";         //"asd";
		String b="ahbgdc";      //"avscdb";
		Solution392 sol=new Solution392();
		System.out.println(sol.isSubsequence(a,b));
	}
}
