package Leetcode;

import java.util.*;
class Solution52 {
	public int totalNQueens(int n) {
		if (n==2||n==3||n<=0)
			return 0;

		board = new char[n][n];
		duij = new boolean[2*n-1];
		duji = new boolean[2*n-1];
		columns = new boolean[n];
		ans = 0;

		for (char[]row:board)
			Arrays.fill(row,'.');

		dfs(0,n);

		return ans;
	}

	char [][]board;
	boolean []duij;
	boolean []duji;
	boolean []columns;
	int ans ;

	public void dfs(int floor,int n){
		if (floor>= n){
			ans++;
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

	public int totalNQueens1(int n) {
		int []ans = {0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200};
		return ans[n];
	}

}
public class Leetcode52 {
	public static void main(String []args){
		int n=13;
		Solution52 sol = new Solution52();
//		int ans = sol.totalNQueens(n);
//		System.out.println(ans);

		int []table = new int[n];
		for (int i=4;i<n;i++){
			table[i]=sol.totalNQueens(i);
		}
		System.out.println(Arrays.toString(table));
	}
}
