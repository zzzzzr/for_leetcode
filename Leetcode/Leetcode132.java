package Leetcode;

import java.util.*;
class Solution132 {
	public int minCut2(String s) {
		char []ch = s.toCharArray();
		int len = s.length();
		boolean [][]ispar = new boolean[len][len];
		for(int i=0;i<len;i++) {
			for (int j = 0; j < 2; j++) {
				int start = i, end = i + j;
				while (start>=0 && end<len){
					if (ch[start]==ch[end]) {
						ispar[start][end] = true;
						start--;
						end++;
					}
					else
						break;
				}
			}
		}
		int []dp = new int[len];
		Arrays.fill(dp,2000);
		for (int i=0;i<len;i++){
			if (ispar[0][i]) {
				dp[i]=0;
			}
			else {
				for (int j=0;j<i;j++) {
					if (ispar[j+1][i]){
						dp[i] = Math.min(dp[i], dp[j]+1);
					}
				}
			}
		}
		return dp[len-1];
	}

	public int minCut1(String s) {
		char []ch = s.toCharArray();
		int len = s.length();
		boolean [][]ispar = new boolean[len][len];
		for(int i=0;i<len;i++) {
			for (int j = 0; j < 2; j++) {
				int start = i, end = i + j;
				while (start>=0 && end<len){
					if (ch[start]==ch[end]) {
						ispar[start][end] = true;
						start--;
						end++;
					}
					else
						break;
				}
			}
		}
		int [][]ans = new int[len][len];
		for (int i=0;i<len;i++){
			// j表示start，则j+i表示end
			for (int j=0;j<len-i;j++){
				if (ispar[j][j+i]){
					ans[j][j+i]=1;
				}
				else{
					ans[j][j+i]=ans[j][j]+ans[j+1][j+i];
					for (int k=j+1;k<j+i;k++){
						ans[j][j+i] = Math.min(ans[j][j+i],ans[j][k]+ans[k+1][j+i]);
					}
				}
			}
		}
		return ans[0][len-1]-1;
	}

	public int minCut(String s) {
		ch = s.toCharArray();
		len = s.length();
		ispar = new boolean[len][len];
		filldp2(ispar);
		for (boolean []arr:ispar)
			System.out.println(Arrays.toString(arr));
		int [][]ans = new int[len][len];
		fillans(ans);
		for (int []arr:ans)
			System.out.println(Arrays.toString(arr));
		return ans[0][len-1];
	}

	int len;
	char []ch;
	boolean [][]ispar;

	public int dfs(boolean[][]ispar, int i){
		if (i>=len){
			return 0;
		}
		for (int j=len-i-1;j>=0;j--){
			if (ispar[j][i]){
				return dfs(ispar,i+j+1)+1;
			}
		}
		return 2222;
	}

	public void fillans(int [][]arr){
		// i表示start到end的距离
		for (int i=0;i<len;i++){
			// j表示start，则j+i表示end
			for (int j=0;j<len-i;j++){
				if (ispar[j][j+i]){
					arr[j][j+i]=1;
				}
				else{
					arr[j][j+i]=arr[j][j]+arr[j+1][j+i];
					for (int k=j+1;k<j+i;k++){
						arr[j][j+i] = Math.min(arr[j][j+i],arr[j][k]+arr[k+1][j+i]);
					}
				}
			}
		}
	}

	// arr[i][j]表示从i到j的子串是回文的
	public void filldp2(boolean [][]arr){
		for(int i=0;i<len;i++) {
			for (int j = 0; j < 2; j++) {
				int start = i, end = i + j;
				while (start>=0 && end<len){
					if (ch[start]==ch[end]) {
						arr[start][end] = true;
						start--;
						end++;
					}
					else
						break;
				}
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
}
public class Leetcode132 {
	public static void main(String []args){
		String s= "aaabaa";
		// "ab";
		Solution132 sol = new Solution132();
		System.out.println(sol.minCut2(s));
	}
}
