package Leetcode;

import java.util.*;
// 和 Leetcode 1081 是同一题
// 单调栈
// 数组实现：
// https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/solution/shu-zu-mo-ni-dan-diao-zhan-by-xhzs/
class Solution316 {
	public String removeDuplicateLetters2(String s){
		char []stack = new char[26];
		boolean []used = new boolean[26];
		int []loc = new int[26];
		for (int i=0;i<s.length();i++){
			loc[s.charAt(i)-'a']=i;
		}
		// 索引栈顶元素的下标
		int index=0;
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (!used[ch-'a']){
				//System.out.println(Arrays.toString(stack));
				//System.out.println(Arrays.toString(used));
				while (index>0 && ch < stack[index-1] && loc[stack[index-1]-'a']>i) {
					index--;
					used[stack[index]-'a']=false;
					stack[index]=0;
				}
				stack[index]=ch;
				used[ch-'a']=true;
				index++;
			}
		}
		StringBuilder ans = new StringBuilder(index);
		for (int i=0;i<index;i++)
			ans.append(stack[i]);
		return ans.toString();
	}

	public String removeDuplicateLetters1(String s){
		// stack 用来存储结果
		Stack<Character> sta = new Stack<>();
		// set 用来表示当前结果中存在的字母
		Set<Character> sett = new HashSet<>();
		// map 用来记录一个字母出现的最后位置
		Map<Character,Integer> mapp = new HashMap<>();
		for (int i=0;i<s.length();i++){
			mapp.put(s.charAt(i),i);
		}
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			//System.out.println(deq.toString());
			if (!sett.contains(ch)) {
				while (!sta.isEmpty() && ch < sta.peek() && mapp.get(sta.peek())>i) {
					//System.out.println(deq.peekLast()+" "+count[deq.peekLast()]);
					sett.remove(sta.pop());
				}
				sett.add(ch);
				sta.push(ch);
			}
		}
		StringBuilder ans = new StringBuilder(sta.size());
		while (sta.size()>0){
			ans.append(sta.pop());
		}
		return ans.reverse().toString();
	}

	public String removeDuplicateLetters(String s){
		// 计数
		int []count = new int['z'+1];
		for (int i=0;i<s.length();i++){
			count[s.charAt(i)]++;
		}
		Deque<Character> deq = new LinkedList<>();
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			//System.out.println(deq.toString());
			if (!deq.contains(ch)) {
				while (!deq.isEmpty() && ch < deq.peekLast() && count[deq.peekLast()] > 1) {
					//System.out.println(deq.peekLast()+" "+count[deq.peekLast()]);
					count[deq.peekLast()]--;
					deq.pollLast();
				}
				deq.offerLast(ch);
			}
			else
				count[ch]--;
		}
		//System.out.println(deq.toString());

		StringBuilder ans = new StringBuilder();
		while (deq.size()>0){
			char ch = deq.pollFirst();
			if (count[ch]!=999) {
				ans.append(ch);
				count[ch]=999;
			}
		}
		if (ans.length()==0)
			return "0";
		else
			return ans.toString();
	}
}
public class Leetcode316 {
	public static void main(String []args){
		Solution316 sol =new Solution316();
		String s = "bddbccd";
		System.out.println(sol.removeDuplicateLetters2(s));
	}
}
