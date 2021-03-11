package Leetcode;

import java.util.*;
class Solution224 {
	public int calculate1(String s) {
		int ans=0;
		int flag=1;
		Stack<Integer> opesta = new Stack<>();
		opesta.push(1);
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (ch==' ' || ch=='+')
				continue;
			if (ch=='-'){
				flag=-1;
			}
 			else if (Character.isDigit(ch)){
                 int temp = 0;
                 while (i<s.length() && Character.isDigit(s.charAt(i))){
 					temp = temp*10+(s.charAt(i)-'0');
 					i++;
 				}
 				i--;
 				ans += flag*opesta.peek()*temp;
 				flag=1;
 			}
			else if (ch=='('){
				opesta.push(flag*opesta.peek());
				flag=1;
			}
			else if (ch==')'){
				opesta.pop();
			}
		}
		return ans;
	}
	public int calculate(String s) {
		int ans=0;
		int flag=1;
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (ch==' ' || ch=='+')
				continue;
			if (Character.isDigit(ch)){
				int temp=ch-'0';
				int id = i+1;
				while (id<s.length() && Character.isDigit(s.charAt(id))){
					temp = temp*10+(s.charAt(id)-'0');
					id++;
				}
				i=id-1;
				ans += flag*temp;
				flag=1;
			}
			else if (ch=='-'){
				flag=-1;
			}
			else if (ch=='('){
				int id=i+1;
				int count=1;
				while (id<s.length() && count!=0){
					if (s.charAt(id)=='(')
						count++;
					else if (s.charAt(id)==')')
						count--;
					id++;
				}
				ans += flag*calculate(s.substring(i+1,id-1));
				flag=1;
				i=id-1;
			}
		}
		//System.out.println(s+" "+ans);
		return ans;
	}
}
public class Leetcode224 {
	public static void main(String []args){
		Solution224 sol = new Solution224();
		String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
		// "2-4-(8+2-6+(8+4-(1)+8-10))";
		// -15
		// "(1+(4+5+2)-3)+(6+8)";
		// 23
		// " 2-1 + 2 ";
		// 3
		// "1 + 2";
		// 3
		System.out.println(sol.calculate1(s));
	}
}
