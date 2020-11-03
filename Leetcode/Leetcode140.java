package Leetcode;

import java.util.*;
// 记忆化搜索
class Solution140_guanfangtijie {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
		List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
		List<String> breakList = new LinkedList<String>();
		for (List<String> wordBreak : wordBreaks) {
			breakList.add(String.join(" ", wordBreak));
		}
		return breakList;
	}

	public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
		if (!map.containsKey(index)) {
			// 如果哈希表里没有存储 字符串从当前下标到结束的子串 的组合方案，则找出组合方案，否则直接返回即可
			List<List<String>> wordBreaks = new LinkedList<List<String>>();
			// 用来存储 字符串从当前下标到结尾的字符 的所有组合方案
			// 每个组合方案都是一个字符串列表
			if (index == length) {
				// 当前位置就是最后的位置，则加入空串
				wordBreaks.add(new LinkedList<String>());
			}
			for (int i = index + 1; i <= length; i++) {
				// 考虑从当前下标开始，分割出第一个单词
				String word = s.substring(index, i);
				if (wordSet.contains(word)) {
					// 这是一个在单词表里的单词，则继续分割
					List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
					// 以当前单词结尾的位置作为下一次分割开始的位置进行分割，并返回其结果
					for (List<String> nextWordBreak : nextWordBreaks) {
						// 对后面字符串分割的每一种分割方案
						LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
						wordBreak.offerFirst(word);
						// 把当前分割出的单词加入到每一种组合结果中， 则加入后得到的是从当前下标开始的字符串的分割方式
						wordBreaks.add(wordBreak);
						// 然后把从当前下标开始的字符串分割方案依次加入到 wordBreaks 这个预先定义好的用来存储分割方案的列表中
					}
				}
			}
			map.put(index, wordBreaks);
			// 把从当前下标开始到字符串结尾结束的子串的所有分割方案都加入到哈希表中，便于将来的查询
		}
		return map.get(index);
	}
}

// 超时
class Solution140 {
	List<String> ans = new LinkedList<>();
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<Integer> index = new LinkedList<>();
		index.add(0);
		dfs(s,wordDict,index,0);
		//System.out.println(ans.toString());
		return ans;
	}

	public void dfs(String s,List<String> worddict,List<Integer> index,int last){
		if (last==s.length()){
			ans.add(makestr(index,s));
			return;
		}

		for (int i=last+1;i<=s.length();i++){
			if (worddict.contains(s.substring(last,i))){
				index.add(i);
				dfs(s,worddict,index,i);
				index.remove(index.size()-1);
			}
		}
	}
	public String makestr(List<Integer>index,String s){
		StringBuilder str = new StringBuilder();
		int last = index.get(0);
		for (int i=1;i<index.size();i++){
			str.append(s, last, index.get(i));
			str.append(" ");
			last = index.get(i);
		}
		str.deleteCharAt(str.length()-1);
		return str.toString();
	}
}
public class Leetcode140 {
	public static void main(String []args){
		String s = "catsanddog";
		List<String> worddict = new LinkedList<>();
		worddict.add("cat");
		worddict.add("cats");
		worddict.add("and");
		worddict.add("sand");
		worddict.add("dog");
		Solution140 sol = new Solution140();
		System.out.println(sol.wordBreak(s,worddict).toString());
	}
}
