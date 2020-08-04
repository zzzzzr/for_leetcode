package JZoffer;

import java.util.LinkedList;
import java.util.Queue;

class SolutionJZoffer12 {
	//  深搜的做法
	public boolean exist_1(char[][] board, String word) {
		if(word.length()<=0){
			return true;
		}
		for(int i=0;i< board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					// 设置为已走过
					board[i][j]='1';
					boolean temp =dfs(board,word,1,i,j);
					if(temp)
						return temp;
					// 归位
					board[i][j]=word.charAt(0);
				}
			}
		}
		return false;
	}
	boolean dfs(char[][]board,String word,int index,int row,int column){
		//boolean temp=false;
		if(index>=word.length())
			return true;
		if(row>=1&&board[row-1][column]==word.charAt(index)) {
			board[row-1][column]='1';
			index++;
			if( dfs(board,word,index,row-1,column))
				return true;
			index--;
			board[row-1][column]=word.charAt(index);
		}
		if(row< board.length-1&&board[row+1][column]==word.charAt(index)) {
			board[row+1][column]='1';
			index++;
			if( dfs(board,word,index,row+1,column))
				return true;
			index--;
			board[row+1][column]=word.charAt(index);
		}
		if(column>=1&&board[row][column-1]==word.charAt(index)) {
			board[row][column-1]='1';
			index++;
			if( dfs(board,word,index,row,column-1))
				return true;
			index--;
			board[row][column-1]=word.charAt(index);
		}
		if(column<board[0].length-1&&board[row][column+1]==word.charAt(index)) {
			board[row][column+1]='1';
			index++;
			if( dfs(board,word,index,row,column+1))
				return true;
			index--;
			board[row][column+1]=word.charAt(index);
		}
		return false;
	}

	//  广搜的做法
	//  不能广搜，广搜要把新的状态加入队列中，然而二维数组不能加进去，加的话内存占用太大
}
public class JZoffer12 {
}
