package Leetcode;

class Solution79 {
	int []direc1={-1,1,0,0};
	int []direc2 = {0,0,-1,1};
	public boolean exist(char[][] board, String word) {
		boolean [][]vis = new boolean[board.length][board[0].length];
		//int index=0;

		for (int i=0;i< board.length;i++){
			for (int j=0;j<board[0].length;j++){
				if (board[i][j]==word.charAt(0)){
					vis[i][j]=true;
					if(dfs(board,vis,word,1,i,j))
						return true;
					vis[i][j]=false;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][]board,boolean[][]vis,String word,int index,int row,int column){
		if (index>=word.length()){
			return true;
		}
		for (int i=0;i<4;i++){
			int newrow = row+direc1[i];
			int newcolumn = column + direc2[i];
			//index++;
			if (newrow>=0 && newrow< board.length && newcolumn>=0 && newcolumn<board[0].length
					&& board[newrow][newcolumn]==word.charAt(index) && !vis[newrow][newcolumn]){
				vis[newrow][newcolumn]=true;

				if (dfs(board, vis, word, index+1, newrow, newcolumn))
					return true;

				vis[newrow][newcolumn]=false;
			}
			//index--;
		}
		return false;
	}
}
public class Leetcode79 {
	public static void main(String[]args){
		Solution79 sol = new Solution79();
		char[][]board ={
				{'C','A','A'},
				{'A','A','A'},
				{'B','C','D'}
		};

//				{
//						{'A','B','C','E'},
//						{'S','F','C','S'},
//						{'A','D','E','E'}
//				};
		String word = "AAB";
		//"ABCB";
		//"ABCCED";
		System.out.println(sol.exist(board,word));
	}
}
