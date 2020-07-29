import java.util.*;
class Solution14 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length<=0) {
			return "";
		}
		if(strs.length==1){
			return strs[0];
		}
		int index=0;
		char charr;
		//String ans="";
		while(true){
			if(index>=strs[0].length()){
				return strs[0].substring(0,index);
			}
			charr=strs[0].charAt(index);
			for(String str:strs){
				if(index>=str.length()||charr!=str.charAt(index)){
					return strs[0].substring(0,index);
				}
			}
			index++;
			//ans=ans+charr;
			/*
			 * 不需要维护ans字符串，只需要维护index即可
			 * return 时返回0到index的子串即可
			 */

		}
	}
}
public class Leetcode14 {
	public static void main(String []args){
		String[] strs=new String[]{"dog","racecar","car"};
		// {"flower","flow","flight"};
//		strs[0]=new String("asd");
//		strs[1]=new String("asfd");
//		strs[2]=new String("sassd");
		Solution14 sol=new Solution14();
		System.out.println(sol.longestCommonPrefix(strs));
	}
}
