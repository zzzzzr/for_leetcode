package Leetcode;

import java.util.*;
class Solution131 {
	List<List<String>> ans;
	int len;
	char []ch;
	public List<List<String>> partition(String s) {
		ch = s.toCharArray();
		len = s.length();
		boolean [][]ispar = new boolean[len][len];
//		ispar[0] = new boolean[len];
//		Arrays.fill(ispar[0],true);
//		for(int i=1;i<len;i++){
//			ispar[i] = new boolean[len-i];
//			for (int j=0;j<len-i;j++){
//				ispar[i][j] = isparti(j,j+i);
//			}
//		}
		filldp(ispar);
		for (boolean []arr:ispar)
			System.out.println(Arrays.toString(arr));
		ans = new LinkedList<>();
		List<String >temp = new LinkedList<>();
		dfs(temp,ispar,0);
		return ans;
	}

	public void dfs(List<String>lis, boolean[][]ispar, int i){
		if (i>=len){
			ans.add(new LinkedList<>(lis));
		}
		for (int j=0;j<len-i;j++){
			if (ispar[j][i]){
				lis.add(new String(ch,i,j+1));
				dfs(lis,ispar,i+j+1);
				lis.remove(lis.size()-1);
			}
		}
	}

	public void filldp(boolean [][]arr){
		for(int i=0;i<len;i++){
			for (int j=0;j<2;j++){
				int start = i,end = i+j;
				while (start>=0 && end<len){
					if (ch[start]==ch[end]) {
						arr[end - start][start] = true;
						start--;
						end++;
					}
					else
						break;
				}
			}
		}
	}
	public boolean isparti(int start, int end){
		while (start<end){
			if (ch[start]!=ch[end])
				return false;
			start++;
			end--;
		}
		return true;
	}
}
public class Leetcode131 {
	public static void main(String []args){
		String s= "aab";
		Solution131 sol = new Solution131();
		System.out.println(sol.partition(s));
	}
}
