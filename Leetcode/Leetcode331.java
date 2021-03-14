package Leetcode;

import java.util.*;
class Solution331 {
	public boolean isValidSerialization4(String preorder) {
		int len = preorder.length();
		int space=1;
		for (int i=0;i<len;i++){
			char ch = preorder.charAt(i);
			if (space==0)
				return false;
			if (Character.isDigit(ch)){
				space++;
				while (i<len && Character.isDigit(preorder.charAt(i))){
					i++;
				}
				i--;
			}
			else if (ch=='#'){
				space--;
			}
		}
		return space==0;
	}

	public boolean isValidSerialization3(String preorder) {
		int len = preorder.length();
		Stack<Integer> chsta = new Stack<>();
		chsta.push(1);
		for (int i=0;i<len;i++){
			char ch = preorder.charAt(i);
			if (chsta.isEmpty())
				return false;
			if (Character.isDigit(ch)){
				int top = chsta.pop()-1;
				if (top>0){
					chsta.push(top);
				}
				chsta.push(2);
				while (i<len && Character.isDigit(preorder.charAt(i))){
					i++;
				}
				i--;
			}
			else if (ch=='#'){
				int top = chsta.pop()-1;
				if (top>0){
					chsta.push(top);
				}
			}
		}
		return chsta.isEmpty();
	}

	public boolean isValidSerialization2(String preorder) {
		int len = preorder.length();
		Stack<Character> chsta = new Stack<>();
		chsta.push(preorder.charAt(0));
		int i;
		char ch;
		for (i=1;i<len && !chsta.isEmpty();i++){
			ch = preorder.charAt(i);
			if (ch == '#' ) {
				while (chsta.size()>1 && chsta.peek() == '#') {
					chsta.pop();
					if (chsta.peek()!='#')
						chsta.pop();
					// System.out.println(chsta);
				}
				chsta.push('#');
			}
			else if (Character.isDigit(ch))	{
				chsta.push(ch);
				// System.out.println(chsta);
				while (i<len && preorder.charAt(i)!=','){
					i++;
				}
				i--;
			}
//			else if (ch=='#'){
//				chsta.push(ch);
//			}
		}
		// System.out.println(chsta);
		return chsta.size() == 1 && chsta.peek() == '#';
	}

	public boolean isValidSerialization1(String preorder) {
		String []str = preorder.split(",");
		int len = str.length;
		Stack<String> chsta = new Stack<>();
		chsta.push(str[0]);
		int i;
		for (i=1;i<len && !chsta.isEmpty();i++){
			if (str[i].equals("#")  && chsta.peek().equals("#")) {
				while (chsta.size()>1 && chsta.peek().equals("#")) {
					chsta.pop();
					if (!chsta.peek().equals("#"))
						chsta.pop();
					System.out.println("2 "+chsta);
				}
				chsta.push("#");
			}
			else {
				chsta.push(str[i]);
				System.out.println("1 "+chsta);
			}
		}
		System.out.println(chsta);
		return chsta.size() == 1 && chsta.peek().equals("#");
	}

	public boolean isValidSerialization(String preorder) {
		String []str = preorder.split(",");
		int len = str.length;
		Stack<Character> chsta = new Stack<>();
		chsta.push(str[0].charAt(0));
		int i;
		char ch;
		for (i=1;i<len && !chsta.isEmpty();i++){
			ch = str[i].charAt(0);
			if (ch == '#' && chsta.peek() == '#') {
				while (chsta.size()>1 && chsta.peek() == '#') {
					chsta.pop();
					if (chsta.peek()!='#')
						chsta.pop();
					 System.out.println("2 "+chsta);
				}
				chsta.push('#');
			}
			else {
				chsta.push(ch);
				 System.out.println("1 "+chsta);
			}
		}
		 System.out.println(chsta);
		return chsta.size() == 1 && chsta.peek() == '#';
	}
}
public class Leetcode331 {
	public static void main(String []args){
		Solution331 sol = new Solution331();
		String s = "1,#,#,#,#";
		// "9,#,92,#,#";
		// "1,#,#,#,#";
		// "9,#,#";
		// "9,#,#,1";
		// "1,#";
		// "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(sol.isValidSerialization3(s));
	}
}
