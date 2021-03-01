package Leetcode;

class Solution990 {
	int []father = new int[26];
	public boolean equationsPossible(String[] equations) {
		for (int i=0;i<26;i++){
			father[i] = i;
		}
		for(String str:equations){
			if (str.charAt(1)=='='){
				combine(str.charAt(0)-'a',str.charAt(3)-'a');
			}
		}
		for(String str:equations){
			if (str.charAt(1)=='!'){
				if (isconnected(str.charAt(0)-'a',str.charAt(3)-'a'))
					return false;
			}
		}
		return true;
	}
	public boolean isconnected(int i, int j){
		return  find(i)==find(j);
	}
	public void combine(int i, int j){
		int fi = find(i);
		int fj = find(j);
		if (fi!=fj){
			father[fi] = fj;
		}
	}
	public int find(int i){
		if (father[i]!=i){
			father[i] = find(father[i]);
		}
		return father[i];
	}
}
public class Leetcode990 {
	public static void main(String []args){
		Solution990 sol = new Solution990();
		String []equ = {"c==c","b==d","x!=z"};
		// {"a==b","b!=c","c==a"};
		// {"a==b","b==c","a==c"};
		// {"b==a","a==b"};
		// {"a==b","b!=a"};
		System.out.println(sol.equationsPossible(equ));
	}
}
