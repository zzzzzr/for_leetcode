package Leetcode;

import java.util.*;
class Solution402 {
	public String removeKdigits1(String num, int k) {
		Deque<Character>  deq = new LinkedList<>();
		for (int i=0;i<num.length();i++){
			//System.out.println(deq.toString());
			char ch = num.charAt(i);
			while (!deq.isEmpty() && k>0 && ch<deq.peekLast()){
				k--;
				deq.pollLast();
			}
			deq.offerLast(ch);
		}
		while(k>0){
			deq.pollLast();
			k--;
		}

		while (deq.size()>0 && deq.peekFirst()=='0'){
			deq.pollFirst();
		}
		// System.out.println(deq.toString());
		StringBuilder ans = new StringBuilder();
		while (deq.size()>0){
			ans.append(deq.pollFirst());
		}
		if (ans.length()==0)
			return "0";
		else
			return ans.toString();
	}

	// 这个超时了
	public String removeKdigits(String num, int k) {
		char []nums = num.toCharArray();
		List<Character> liss = new LinkedList<>();
		for (char ch:nums)
			liss.add(ch);
		while(k>0){
			k--;
			int i;
			for (i=0;i< liss.size()-1;i++){
				if (liss.get(i)>liss.get(i+1)){
					break;
				}
			}
			liss.remove(i);
		}
		while(liss.size()>0&&liss.get(0)=='0'){
			liss.remove(0);
		}
		StringBuilder ans = new StringBuilder();
		for (char ch:liss){
			ans.append(ch);
		}
		if (ans.length()==0)
			return "0";
		else
			return ans.toString();
	}
}
public class Leetcode402 {
	public static void main(String []args){
		String num = "1432219";
		int k=3;
		Solution402 sol = new Solution402();
		System.out.println(sol.removeKdigits1(num,k));
	}
}
