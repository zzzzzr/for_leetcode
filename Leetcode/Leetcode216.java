package Leetcode;

import java.util.*;
class Solution216 {



	//**************************************************************

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new LinkedList<>();
		List<Integer> lis = new LinkedList<>();
		dfs(ans,lis,0,k,n);

		return ans;
	}

	public void dfs(List<List<Integer>>ans, List<Integer>lis,int last,int k,int n){
		if (k==1) {
			if ( n > last && n <= 9) {
				lis.add(n);
				ans.add(new LinkedList<>(lis));
				lis.remove(lis.size() - 1);

			}return;
		}
		for (int i=last+1;i<9&&i<n;i++){
			lis.add(i);
			last=i;
			k--;
			n-=i;
			dfs(ans, lis, last, k, n);
			n+=i;
			k++;
			lis.remove(lis.size()-1);
		}
	}
}
public class Leetcode216 {
	public static void main(String []args){
		int k=2;
		int n=18;
		Solution216 sol = new Solution216();
		System.out.println(sol.combinationSum3(k,n));
	}
}
