package Leetcode;

class TrieNode{
//	public char ch;
	public boolean isOver;
	public TrieNode []child = new TrieNode[26];

//	public Leetcode.TrieNode(char c){
//		ch = c;
//	}
}
class Trie {
	TrieNode base;

	/** Initialize your data structure here. */
	public Trie() {
		base = new TrieNode();
		base.isOver = true;
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		int index = 0;
		TrieNode tnode = base;
		while (index< word.length() && tnode.child[word.charAt(index)-'a'] != null){
			tnode = tnode.child[word.charAt(index)-'a'];
			index++;
		}
		while (index<word.length()){
			tnode.child[word.charAt(index)-'a'] = new TrieNode();
			tnode = tnode.child[word.charAt(index)-'a'];
			index++;
		}
		tnode.isOver = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		int index = 0;
		TrieNode tnode = base;
		while (index<word.length()){
			if (tnode.child[word.charAt(index)-'a']==null)
				return false;
			else {
				tnode = tnode.child[word.charAt(index)-'a'];
				index++;
			}
		}
		return tnode.isOver;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		int index = 0;
		TrieNode tnode = base;
		while (index<prefix.length()){
			if (tnode.child[prefix.charAt(index)-'a']==null)
				return false;
			else {
				tnode = tnode.child[prefix.charAt(index)-'a'];
				index++;
			}
		}
		return true;
	}
}
class Trie1 {
	private boolean is_string=false;
	private Trie1 next[]=new Trie1[26];

	public Trie1(){}

	public void insert(String word){//插入单词
		Trie1 root=this;
		char w[]=word.toCharArray();
		for(int i=0;i<w.length;++i){
			if(root.next[w[i]-'a']==null)
				root.next[w[i]-'a']=new Trie1();
			root=root.next[w[i]-'a'];
		}
		root.is_string=true;
	}

	public boolean search(String word){//查找单词
		Trie1 root=this;
		char w[]=word.toCharArray();
		for(int i=0;i<w.length;++i){
			if(root.next[w[i]-'a']==null)return false;
			root=root.next[w[i]-'a'];
		}
		return root.is_string;
	}

	public boolean startsWith(String prefix){//查找前缀
		Trie1 root=this;
		char p[]=prefix.toCharArray();
		for(int i=0;i<p.length;++i){
			if(root.next[p[i]-'a']==null)return false;
			root=root.next[p[i]-'a'];
		}
		return true;
	}
}
public class Leetcode208 {
}
