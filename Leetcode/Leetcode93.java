package Leetcode;

import java.util.*;
class Solution93 {
	List<String> lis;
	int len;
	char []ch;
	public List<String> restoreIpAddresses(String s) {
		lis= new LinkedList<>();
		len=s.length();
		if(len<4||len>12)
			return lis;
		ch=s.toCharArray();
		StringBuilder str=new StringBuilder();
		dfs(str,0,0);

		return lis;
	}
	void dfs(StringBuilder str,int times,int index){
		if(index>=len&&times<4)
			return;
		if(times>4)
			return;
		if(times==4){
			if(str.length()-3==len)
				lis.add(str.toString());
			return;
		}
		if(times!=0)
			str.append('.');

		int num = ch[index] - '0';
		str.append(ch[index]);
		dfs(str,times+1,index+1);
		str.delete(str.length()-1,str.length());

		if(index+1<len) {
			if (num!=0) {

				num = num * 10 + (ch[index + 1] - '0');
				str.append(ch[index]);
				str.append(ch[index + 1]);
				dfs(str, times + 1, index + 2);
				str.delete(str.length() - 2, str.length());
			}

		}

		if(index+2<len){
			if (num!=0) {
				num = num * 10 + (ch[index + 2] - '0');
				if (num <= 255) {
					str.append(ch[index]);
					str.append(ch[index + 1]);
					str.append(ch[index + 2]);
					dfs(str, times + 1, index + 3);
					str.delete(str.length() - 3, str.length());
				}
			}
		}
		if(times!=0)
			str.deleteCharAt(str.length()-1);

	}
}
public class Leetcode93 {
	public static void main(String []args){
		Solution93 sol= new Solution93();
		String s="010010";
		for(String str: sol.restoreIpAddresses(s))
			System.out.println(str);
	}
}
