package Leetcode;

import java.util.*;
class Solution51 {
	char [][]board;
	boolean []duij;
	boolean []duji;
	boolean []columns;
	List<List<String >> ans = new LinkedList<>();
	public List<List<String>> solveNQueens(int n) {
		if (n==2||n==3||n<=0)
			return ans;

		board = new char[n][n];
		duij = new boolean[2*n-1];
		duji = new boolean[2*n-1];
		columns = new boolean[n];

		for (char[]row:board)
			Arrays.fill(row,'.');

		dfs(0,n);

		return ans;
	}

	public void dfs(int floor,int n){
		if (floor>= n){
			ans.add(trans());
			return;
		}

		for (int i=0;i<n;i++){
			if (columns[i]||duij[floor-i+n-1]||duji[floor+i])
				continue;

			board[floor][i]='Q';
			columns[i]=true;
			duij[floor-i+n-1]=true;
			duji[floor+i]=true;

			dfs(floor+1, n);

			duji[floor+i]=false;
			duij[floor-i+n-1]=false;
			columns[i]=false;
			board[floor][i]='.';
		}
	}

	public List<String> trans(){
		List<String> temp = new LinkedList<>();
		for (char[]row:board){
			StringBuilder tempstr = new StringBuilder();

			for (char ch:row)
				tempstr.append(ch);

			temp.add(tempstr.toString());
		}
		return temp;
	}

}
public class Leetcode51 {
	public static void main(String []args){
		int n=4;
		Solution51 sol = new Solution51();
		List<List<String>> ans = sol.solveNQueens(n);
		System.out.println(ans.size());
		for (List<String> lis:ans){
			//System.out.println(lis.toString());
			print(lis);
		}
	}
	/*
	[[
	".Q..",
	"...Q",
	"Q...",
	"..Q."
	],
	["..Q.","Q...","...Q",".Q.."]]
	[
	["[., Q, ., .]",
	"[., ., ., Q]",
	"[Q, ., ., .]",
	"[., ., Q, .]"],
	["[., ., Q, .]","[Q, ., ., .]","[., ., ., Q]","[., Q, ., .]"]]
	 */
	public static void print(List<String>lis){
		for (String str:lis){
			System.out.println(str);
		}
		System.out.println();
	}
}
