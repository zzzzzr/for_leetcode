package Leetcode;

import java.util.*;

class Solution227 {
	public int calculate1(String s) {
		int len = s.length();
		int ans=0;
		int flag=1;
		Stack<Integer> numsta = new Stack<>();
//		Stack<Integer> opasta = new Stack<>();
//		opasta.push(1);
		for (int i=0;i<len;i++) {
			char ch = s.charAt(i);
			if (ch=='+'){
				flag=1;
			}
			else if (ch=='-'){
				flag=-1;
			}
			else if(ch=='*'){
				flag=2;
			}
			else if (ch=='/'){
				flag=3;
			}
			else if (Character.isDigit(ch)){
				int temp = 0;
				while (i<len && Character.isDigit(s.charAt(i))){
					temp = temp*10+(s.charAt(i)-'0');
					i++;
				}
				i--;
				if (flag==1 || flag==-1){
					numsta.push(flag*temp);
				}
				else if (flag==2){
					numsta.push(numsta.pop()*temp);
				}
				else {
					numsta.push(numsta.pop()/temp);
				}
			}
		}
		while (!numsta.isEmpty()){
			ans+=numsta.pop();
		}
		return ans;
	}

	public int calculate(String s) {
		int len = s.length();
		int ans=0;
		int flag=1;
		for (int i=0;i<len;i++){
			char ch = s.charAt(i);
			if (ch=='+'){
				flag=1;
			}
			else if (ch=='-'){
				flag=-1;
			}
			else if (Character.isDigit(ch)){
				int id=i;
				int temp = 0;
				while (i<len && Character.isDigit(s.charAt(i))){
					temp = temp*10+(s.charAt(i)-'0');
					i++;
				}
				while (i<len && s.charAt(i)==' '){
					i++;
				}
				if (i==len){
					ans+=temp*flag;
					break;
				}
				if (s.charAt(i)=='+'){
					ans+=temp*flag;
					flag=1;
				}
				else if (s.charAt(i)=='-'){
					ans+=temp*flag;
					flag=-1;
				}
				else if (s.charAt(i)=='*' || s.charAt(i)=='/'){
					while (i<len && s.charAt(i)!='+'&&s.charAt(i)!='-'){
						i++;
					}
					ans+=times(s.substring(id,i))*flag;
					i--;
				}
			}
		}
		return ans;
	}
	public int times(String s){
		int len=s.length();
		int ans=1;
		int flag=1;
		for (int i=0;i<len;i++){
			char ch = s.charAt(i);
			if (Character.isDigit(ch)){
				int temp = 0;
				while (i<s.length() && Character.isDigit(s.charAt(i))){
					temp = temp*10+(s.charAt(i)-'0');
					i++;
				}
				i--;
				if (flag==1)
					ans *= temp;
				else
					ans/=temp;
				flag=1;
			}
			else if (ch=='*'){
				flag=1;
			}
			else if (ch=='/'){
				flag=0;
			}
		}
		return ans;
	}
}
public class Leetcode227 {
	public static void main(String []args){
		Solution227 sol = new Solution227();
		String s = "3+2*2";
		// " 3+5 / 2 ";
		// " 3/2 ";
		// "3+2*2";
		System.out.println(sol.calculate1(s));
	}
}
