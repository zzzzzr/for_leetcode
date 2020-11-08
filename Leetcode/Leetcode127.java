package Leetcode;
// https://leetcode-cn.com/problems/word-ladder/solution/suan-fa-shi-xian-he-you-hua-javashuang-xiang-bfs23/
import java.util.*;
class Solution127 {
	// 把遍历单词表提供候选单词改成变更字母提供候选单词，时间大幅缩短
	// 14 ms
	// 意思是样例里的单词一般字母长度不大，但样例的单词表可能会很大
	public int ladderLength7(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		String[]wordlis = wordList.toArray(new String[0]);
		if (!wordset.contains(endWord))
			return 0;

		Set<String> used1 = new HashSet<>();
		Set<String> used2 = new HashSet<>();
		used1.add(beginWord);
		used2.add(endWord);

		Queue<String> lis1 = new LinkedList<>();
		Queue<String> lis2 = new LinkedList<>();
		lis1.add(beginWord);
		lis2.add(endWord);

		int epoch=0;
		while(!lis1.isEmpty()&&!lis2.isEmpty()){
			System.out.println(lis1.toString()+" "+lis2.toString());
			epoch++;
			if (lis1.size()<=lis2.size()) {
				int size = lis1.size();
				for (int i = 0; i < size; i++) {
					String str = lis1.poll();
					char[]charr = str.toCharArray();
					for (int j=0;j< str.length();j++){
						char og = charr[j];
						for (char ch='a';ch<='z';ch++){
							if(ch==og)
								continue;
							charr[j]=ch;
							String strnew= new String(charr);
							if (wordset.contains(strnew)&&!used1.contains(strnew)){
								lis1.add(strnew);
								used1.add(strnew);
								if (used2.contains(strnew))
									return epoch+1;
							}
						}
						charr[j]=og;
					}
				}
			}
			else {
				int size = lis2.size();
				for (int i = 0; i < size; i++) {
					String str = lis2.poll();
					char[]charr = str.toCharArray();
					for (int j=0;j< str.length();j++){
						char og = charr[j];
						for (char ch='a';ch<='z';ch++){
							if(ch==og)
								continue;
							charr[j]=ch;
							String strnew= new String(charr);
							if (wordset.contains(strnew)&&!used2.contains(strnew)){
								lis2.add(strnew);
								used2.add(strnew);
								if (used1.contains(strnew))
									return epoch+1;
							}
						}
						charr[j]=og;
					}
				}
			}
		}
		return 0;
	}


	// 改成双向BFS，时间显著缩短
	// 64ms
	public int ladderLength6(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		String[]wordlis = wordList.toArray(new String[0]);
		boolean []used = new boolean[wordList.size()];
		boolean []used2 = new boolean[wordList.size()];
		if (!wordset.contains(endWord))
			return 0;
		Queue<String> lis1 = new LinkedList<>();
		Queue<String> lis2 = new LinkedList<>();
		lis1.add(beginWord);
		lis2.add(endWord);
		used2[wordList.indexOf(endWord)]=true;
		int epoch=0;
		while(!lis1.isEmpty()&&!lis2.isEmpty()){
			System.out.println(lis1.toString()+" "+lis2.toString());
			epoch++;
			if (lis1.size()<=lis2.size()) {
				int size = lis1.size();
				for (int i = 0; i < size; i++) {
					String str = lis1.poll();
					for (int j = 0; j < wordList.size(); j++) {
						if (used[j])
							continue;
						String strr = wordlis[j];
						if (compare(str, strr)) {
							lis1.add(strr);
							used[j] = true;
							if (used2[j])
								return epoch + 1;
						}
					}
				}
			}
			else {
				int size = lis2.size();
				for (int i = 0; i < size; i++) {
					String str = lis2.poll();
					for (int j = 0; j < wordList.size(); j++) {
						if (used2[j])
							continue;
						String strr = wordlis[j];
						if (compare(str, strr)) {
							lis2.add(strr);
							used2[j] = true;
							if (used[j])
								return epoch + 1;
						}
					}
				}
			}
		}
		return 0;
	}

	// 把单词表从list换成array，时间再次减少
	// 494ms
	public int ladderLength5(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		String[]wordlis = wordList.toArray(new String[0]);
		boolean []used = new boolean[wordList.size()];
		if (!wordset.contains(endWord))
			return 0;
		Queue<String> lis1 = new LinkedList<>();
		lis1.add(beginWord);
		int epoch=0;
		while(!lis1.isEmpty()){
			System.out.println(lis1.toString());
			epoch++;
			int size = lis1.size();
			for (int i=0;i<size;i++){
				String str = lis1.poll();
				for (int j=0;j<wordList.size();j++){
					if (used[j])
						continue;
					String strr = wordlis[j];
					if (compare(str,strr)){
						lis1.add(strr);
						used[j]=true;
						if (strr.equals(endWord))
							return epoch+1;
					}
				}

			}
		}
		return 0;
	}

	// 不用集合表示使用过的字符串，改用数组，时间减少
	// 838ms -> 627ms
	public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		boolean []used = new boolean[wordList.size()];
		if (!wordset.contains(endWord))
			return 0;
		Queue<String> lis1 = new LinkedList<>();
		lis1.add(beginWord);
		int epoch=0;
		while(!lis1.isEmpty()){
			System.out.println(lis1.toString());
			epoch++;
			int size = lis1.size();
			for (int i=0;i<size;i++){
				String str = lis1.poll();
				for (int j=0;j<wordList.size();j++){
					if (used[j])
						continue;
					String strr = wordList.get(j);
					if (compare(str,strr)){
						lis1.add(strr);
						used[j]=true;
						if (strr.equals(endWord))
							return epoch+1;
					}
				}

			}
		}
		return 0;
	}


	// 两个双向 BFS 在大规模输入都超时了
	public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		Set<String> used = new HashSet<>();
		if (!wordset.contains(endWord))
			return 0;
		Queue<String> lis1 = new LinkedList<>();
		Queue<String> lis2 = new LinkedList<>();
		lis1.add(beginWord);
		lis2.add(endWord);
		int epoch=0;
		while(!lis1.isEmpty()&&!lis2.isEmpty()){
			System.out.println(lis1.toString()+" "+lis2.toString());
			epoch++;
			if (lis1.size()>lis2.size()){
				Queue<String> temp = new LinkedList<>(lis1);
				lis1=lis2;
				lis2=temp;
			}
			int size = lis1.size();
			//System.out.println(size);
			for (int i=0;i<size;i++){
				String str = lis1.poll();
				char[]charr = str.toCharArray();
				for (int j=0;j< str.length();j++){
					char og = charr[j];
					for (char ch='a';ch<='z';ch++){
						if(ch==og)
							continue;
						charr[j]=ch;
						String strnew= new String(charr);
						//System.out.println(strnew);
						if (wordList.contains(strnew)&&!lis1.contains(strnew)&&!used.contains(str)){
//						if (wordList.contains(strnew)&&!sett.contains(strnew)){
							lis1.add(strnew);
							if (lis2.contains(strnew))
								return epoch+1;
						}
					}
					charr[j]=og;
				}
//				for (String s:wordList){
//					if (!lis1.contains(s)&&compare(str,s)&&!used.contains(str)){
//						//System.out.println(s);
//						lis1.add(s);
//						if (lis2.contains(s))
//							return epoch+1;
//					}
//				}
				used.add(str);
			}
		}
		return 0;
	}


	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		Set<String> used = new HashSet<>();
		if (!wordset.contains(endWord))
			return 0;
		Queue<String> lis1 = new LinkedList<>();
		Queue<String> lis2 = new LinkedList<>();
		lis1.add(beginWord);
		lis2.add(endWord);
		int epoch=0;
		while(!lis1.isEmpty()&&!lis2.isEmpty()){
			System.out.println(lis1.toString()+" "+lis2.toString());
			epoch++;
			if (lis1.size()>lis2.size()){
				Queue<String> temp = new LinkedList<>(lis1);
				lis1=lis2;
				lis2=temp;
			}
			int size = lis1.size();
			//System.out.println(size);
			for (int i=0;i<size;i++){
				String str = lis1.poll();
				for (String s:wordList){
					if (!lis1.contains(s)&&compare(str,s)&&!used.contains(str)){
						//System.out.println(s);
						lis1.add(s);
						if (lis2.contains(s))
							return epoch+1;
					}
				}
				used.add(str);
			}
		}

		return 0;
	}




	// 两个 BFS 都失败了
	public int ladderLength1(String beginWord,String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		Queue<String> que = new LinkedList<>();
		que.add(beginWord);
		int epoch=1;
		while(!que.isEmpty()){
			System.out.println(que.toString());
			int size = que.size();
			epoch++;
			for (int i=0;i<size;i++){
				String str= que.poll();
				for (String s:wordList){
					if (!que.contains(s)&&compare(str,s)){
						que.add(s);
						if (str.equals(endWord))
							return epoch;
					}
				}
			}
		}
		return 0;
	}
	public boolean compare(String p,String q){
		//System.out.println(p+" "+q);
		char []pp = p.toCharArray();
		char []qq = q.toCharArray();
		int count=0;
		for (int i=0;i<p.length();i++){
			if (pp[i]!=qq[i])
				count++;
			if (count>=2)
				return false;
		}
		return count==1;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k',
		'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Queue<String> que = new LinkedList<>();
		//Set<String> sett = new HashSet<>();
		que.add(beginWord);
		//sett.add(beginWord);
		int epoch=1;
		while(!que.isEmpty()){
			System.out.println(que.toString());
			int size = que.size();
			epoch++;
			for (int i=0;i<size;i++){
				String str= que.poll();
				for (int j=0;j< str.length();j++){
					char[]charr = str.toCharArray();
					for (int k=0;k<26;k++){
						charr[j]=alphabet[k];
						String strnew= new String(charr);
						if (wordList.contains(strnew)&&!strnew.equals(str)&&!que.contains(strnew)){
//						if (wordList.contains(strnew)&&!sett.contains(strnew)){
							if (strnew.equals(endWord))
								return epoch;
							que.add(strnew);
						}
					}
				}
			}
		}
		return 0;
	}


}
public class Leetcode127 {
	public static void main(String []args){
		String beginword = "hit";
		String endword = "cog";
		List<String> wordlist = new LinkedList<>();
		wordlist.add("hot");
		wordlist.add("dot");
		wordlist.add("dog");
		wordlist.add("lot");
		wordlist.add("log");
//		wordlist.add("tog");
		wordlist.add("cog");
//		wordlist.add("tot");
//		wordlist.add("hog");
//		wordlist.add("hop");
//		wordlist.add("pot");
// ["hot","dot","dog","lot","log","cog"]
		// ["hot","cog","dog","tot","hog","hop","pot","dot"]
		Solution127 sol= new Solution127();
		System.out.println(sol.ladderLength6(beginword,endword,wordlist));
	}
}
