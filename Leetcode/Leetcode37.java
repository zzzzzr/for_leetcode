package Leetcode;

import java.util.*;
class Solution37 {
	public void solveSudoku(char[][] board) {
		dfs(board);
	}

	public boolean dfs(char[][]board){

		int i;
		int j=0;
		boolean find=false;
		// 找到一个没有填满的位置
		for (i=0;i<9;i++){
			for (j=0;j<9;j++){
				if (board[i][j]=='.'){
					find=true;
					break;
				}
			}
			if (find)
				break;
		}
		if (i==9)
			return true;

		for (int k=1;k<=9;k++){
			if (check(board,i,j,k)){
				board[i][j]=(char)(k+'0');
				if(dfs(board))
					return true;
				board[i][j]='.';
			}
		}
		return false;
	}

	public boolean check(char[][]board,int row,int column,int num){

		for(int i=0;i<9;i++){
			if (board[row][i] ==(num+'0'))
				return false;
		}
		for(int i=0;i<9;i++){
			if (board[i][column]==(num+'0'))
				return false;
		}
		int blocki=row/3;
		int blockj=column/3;
		for (int i=blocki*3;i<blocki*3+3;i++){
			for (int j=blockj*3;j<blockj*3+3;j++){
				if (board[i][j]==num+'0')
					return false;
			}
		}
		return true;
	}
}
public class Leetcode37 {
	public static void main(String []args){
		Solution37 sol =new Solution37();
		char[][]board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		sol.solveSudoku(board);
		for (char[] s:board)
		System.out.println(Arrays.toString(s));
	}
}
/*
[
["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]
]
 */