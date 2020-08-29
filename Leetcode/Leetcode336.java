package Leetcode;

import java.util.*;
// 字典树： https://zhuanlan.zhihu.com/p/28891541
// 解法：

class Solution336 {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>>  ans=new LinkedList<>();
		List<Integer> templist;
		String temp1,temp2;
		boolean one,len;
		for(int i=0;i< words.length-1;i++){
			for(int j=i+1;j< words.length;j++){
				temp1=words[i]+words[j];
				one=checkpalin(temp1);
				len=words[i].length()==words[j].length();
				if(one&&len) {
					templist=new LinkedList<>();
					templist.add(i);
					templist.add(j);
					ans.add(templist);
					templist=new LinkedList<>();
					templist.add(j);
					templist.add(i);
					ans.add(templist);
				}
				else {
					if (one) {
						templist = new LinkedList<>();
						templist.add(i);
						templist.add(j);
						ans.add(templist);
					}
					temp2 = words[j] + words[i];
					if (checkpalin(temp2)) {
						templist = new LinkedList<>();
						templist.add(j);
						templist.add(i);
						ans.add(templist);
					}
				}
			}
		}
		return ans;
	}
	public boolean checkpalin(String s){
		if(s==null)
			return true;
		int i=0,j=s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}

public class Leetcode336 {
	public static void main(String []args){
		Solution336 sol = new Solution336();
		String [] words=new String[]{"bat","tab","cat"};
		//{ "abcd","dcba","lls","s","sssll"};
		System.out.println(sol.palindromePairs(words));
	}
}

class Solution336byleetcode {
	class Node {
		int[] ch = new int[26];
		int flag;

		public Node() {
			flag = -1;
		}
	}
	/*
	flag 从根节点到这个节点表示的单词对应的在words中的下标
	ch长度为26，对应26个字母，分别表示每个当前单词加上ch[i]的字母后的新单词所对应的node在tree中的下标，用于访问，新单词
	flag初始值为-1，但新插入的单词的flag值会被赋值为其对应words的下标，则为了插入单词而构造的中间单词变量就不会和单词混淆
	ch初始值为0，而tree在刚开始就add了一个空结点，而任何一个单词在继续向下指向拼接出的新单词时都不会指向tree中的下标为0的单词，这样也就作出了区分
	 */

	List<Node> tree = new ArrayList<Node>();

	public List<List<Integer>> palindromePairs(String[] words) {
		tree.add(new Node());
		int n = words.length;
		for (int i = 0; i < n; i++) {
			insert(words[i], i);
		}
		// 将所有单词正序插入搜索树中

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			int m = words[i].length();
			for (int j = 0; j <= m; j++) {
				if (isPalindrome(words[i], j, m - 1)) {
					int leftId = findWord(words[i], 0, j - 1);
					if (leftId != -1 && leftId != i) {
						ret.add(Arrays.asList(i, leftId));
					}
				}
				// 如果words[i]右半段是回文的且可以找到与左半段对应的反序单词j，则[i的左半段，i的右半段，j]就可以组成一个回文串
				// 要注意这里把左半段是空串和左半段是满串的情况都考虑了进去
				if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
					int rightId = findWord(words[i], j, m - 1);
					if (rightId != -1 && rightId != i) {
						ret.add(Arrays.asList(rightId, i));
					}
				}
				// 如果words[i]左半段是回文的且可以找到与右半段对应的反序单词j，则[j，i的左半段，i的右半段]就可以组成一个回文串
				// 这里把右半段是满串的情况考虑了进去，右半段是空串与上面的左半段是空串一致，不用考虑
			}
		}
		return ret;
	}

	public void insert(String s, int id) {
		int len = s.length(), add = 0;
		for (int i = 0; i < len; i++) {
			int x = s.charAt(i) - 'a';
			if (tree.get(add).ch[x] == 0) {
				tree.add(new Node());
				tree.get(add).ch[x] = tree.size() - 1;
			}
			add = tree.get(add).ch[x];
		}
		tree.get(add).flag = id;
	}
	/*
	x用ascii码值作差的方式求得了对应字母在ch数组中的下标
	add表示当前所表示的字符串所对应的node在tree中的下标
	add初始值为0，表示初始在最顶的根节点处，然后依次向下搜索
	此时的状态也意味着字符串在第一个字母的前方，为空串，与根节点含义相对应
	tree.get(add)表示取出当前节点
	tree.get(add).ch[x]表示询问当前字符串对应的单词加新的字母后产生的单词在tree中的下标
	如果为0，则ch值为初始值，表示没有指向对应新单词的node
	则新建一个node，并用tree.get(add).ch[x]指向他。而新节点是tree的最后一个节点，下标必为tree。size()-1
	然后add指向新单词对应的node在tree中的下标（不论是找到的还是新构建的）
	不断指向加入新字母的新单词，直到指到用完所有字母，此时add指向的即是完整的字符串s对应的node在tree中的下标
	id为s在words中的下标，将其赋值给node.flag
	 */

	public boolean isPalindrome(String s, int left, int right) {
		int len = right - left + 1;
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(left + i) != s.charAt(right - i)) {
				return false;
			}
		}
		return true;
	}

	public int findWord(String s, int left, int right) {
		int add = 0;
		for (int i = right; i >= left; i--) {
			int x = s.charAt(i) - 'a';
			if (tree.get(add).ch[x] == 0) {
				return -1;
			}
			add = tree.get(add).ch[x];
		}
		return tree.get(add).flag;
	}
	// 这里传来的参数是字符串和左右端点
	// 而我们要做的是找到字符串的左半段或右半段的反序对应，所以是反序进行比对
}