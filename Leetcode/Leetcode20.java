package Leetcode;

import java.util.Stack;

class Solution20 {
	// 状态机
	public boolean isValid_1(String s) {
		if(s.length()<=0){
			return true;
		}
		Stack<Character> sta=new Stack<>();
		for(int i=0;i<s.length();i++){
			char bracket=s.charAt(i);
			//System.out.println(bracket);
			switch (bracket){
				case '(':
				case '[':
				case '{': {
					sta.push(bracket);
					break;
				}
				case ')':{
					if(sta.isEmpty()){
						return false;
					}
					if(sta.peek()=='('){
						sta.pop();
						break;
					}
					else
						return false;
				}
				case ']':{
					if(sta.isEmpty()){
						return false;
					}
					if(sta.peek()=='['){
						sta.pop();
						break;
					}
					else
						return false;
				}
				case '}':{
					if(sta.isEmpty()){
						return false;
					}
					if(sta.peek()=='{'){
						sta.pop();
						break;
					}
					else
						return false;
				}
			}
			//System.out.println(sta);
		}
		return sta.isEmpty();
	}

	public boolean isValid(String s) {
		if(s.length()<=0){
			return true;
		}
		if(s.length()==1){
			return false;
		}
		Stack<Character> sta=new Stack<>();
		sta.push(s.charAt(0));
		for(int i=1;i<s.length();i++){
			char bracket=s.charAt(i);
			if(bracket=='('||bracket=='['||bracket=='{'){
				sta.push(bracket);
			}
			else if(bracket==')'&&sta.peek()=='('){
				sta.pop();
			}
			else if(bracket==']'&&sta.peek()=='['){
				sta.pop();
			}
			else if(bracket=='}'&&sta.peek()=='{'){
				sta.pop();
			}
			else{
				return false;
			}
		}
		return sta.isEmpty();
	}
}
public class Leetcode20 {
	public static void main(String []args){
		Solution20 sol = new Solution20();
		String s="{[]}";
		System.out.println(sol.isValid_1(s));
	}
}
