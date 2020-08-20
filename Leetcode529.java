import java.util.*;
class Solution529 {
	int []x_direc = new int[]{-1,-1,-1,0,+1,+1,+1,0};
	int []y_direc = new int[]{-1,0,+1,+1,+1,0,-1,-1};
	public char[][] updateBoard(char[][] board, int[] click) {
		if(board[click[0]][click[1]]=='M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
//		int count=find_mine(board,click);
//		if(count!=0){
//			board[click[0]][click[1]] = (char)count;
//			return board;
//		}
		reveal(board,click);
		return board;
	}
	public int find_mine(char [][]board,int[]click){
		int m=click[0];
		int n=click[1];
		int row= board.length;
		int column = board[0].length;
		if(m<0||m>row||n<0||n>column)
			return 0;
		int ans=0;
		for(int i=0;i<8;i++){
			int newx = m+x_direc[i];
			int newy = n+y_direc[i];
			if(newx<0||newx>=row||newy<0||newy>=column)
				continue;
			if (board[newx][newy]=='M')
				ans++;
		}


//		// 左上
//		if(m-1>=0&&n-1>=0&&board[m-1][n-1]=='M')
//			ans++;
//		// 正上
//		if(m-1>=0&&board[m-1][n]=='M')
//			ans++;
//		// 右上
//		if(m-1>=0&&n+1<column&&board[m-1][n+1]=='M')
//			ans++;
//		// 正左
//		if(n-1>=0&&board[m][n-1]=='M')
//			ans++;
//		// 正右
//		if(n+1<column&&board[m][n+1]=='M')
//			ans++;
//		// 左下
//		if(m+1<row&&n-1>=0&&board[m+1][n-1]=='M')
//			ans++;
//		// 正下
//		if(m+1<row&&board[m+1][n]=='M')
//			ans++;
//		//右下
//		if(m+1<row&&n+1<column&&board[m+1][n+1]=='M')
//			ans++;

		return ans;
	}
	public void reveal(char[][]board,int []click){
		int row= board.length;
		int column = board[0].length;
		boolean [][]visited=new boolean[row][column];
		int m,n;
//		board[click[0]][click[1]]='B';
//		visited[click[0]][click[1]]=true;
		Queue<int[]> que = new LinkedList<>();
		que.offer(click);
		visited[click[0]][click[1]]=true;
		int []temp;
		while(!que.isEmpty()){
			temp = que.poll();
			//visited[temp[0]][temp[1]]=true;
			m=temp[0];
			n=temp[1];
			int count=find_mine(board,temp);
			System.out.println(""+m+" "+n);
			if(count!=0){
				board[m][n] = (char)(count+48);
			}
			else{
				board[m][n]='B';

				for(int i=0;i<8;i++){
					int newx = m+x_direc[i];
					int newy = n+y_direc[i];
					if(newx<0||newx>=row||newy<0||newy>=column||visited[newx][newy])
						continue;
					que.offer(new int[]{newx,newy});
					visited[newx][newy]=true;
				}

//				if(m-1>=0&&n-1>=0&&board[m-1][n-1]=='E'&&!visited[m-1][n-1])
//					que.offer(new int[]{m-1,n-1});
//				// 正上
//				if(m-1>=0&&board[m-1][n]=='E'&&!visited[m-1][n])
//					que.offer(new int[]{m-1,n});
//				// 右上
//				if(m-1>=0&&n+1<column&&board[m-1][n+1]=='E'&&!visited[m-1][n+1])
//					que.offer(new int[]{m-1,n+1});
//				// 正左
//				if(n-1>=0&&board[m][n-1]=='E'&&!visited[m][n-1])
//					que.offer(new int[]{m,n-1});
//				// 正右
//				if(n+1<column&&board[m][n+1]=='E'&&!visited[m][n+1])
//					que.offer(new int[]{m,n+1});
//				// 左下
//				if(m+1<row&&n-1>=0&&board[m+1][n-1]=='E'&&!visited[m+1][n-1])
//					que.offer(new int[]{m+1,n-1});
//				// 正下
//				if(m+1<row&&board[m+1][n]=='E'&&!visited[m+1][n])
//					que.offer(new int[]{m+1,n});
//				//右下
//				if(m+1<row&&n+1<column&&board[m+1][n+1]=='E'&&!visited[m+1][n+1])
//					que.offer(new int[]{m+1,n+1});
			}
		}
	}
}
public class Leetcode529 {
	public static void main(String []args){
		Solution529 sol = new Solution529();
		String[][]board1 = new String[][]{
				{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"},
		{"E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E"}
		};
		char [][]board = new char[board1.length][board1[0].length];
		for(int i=0;i<board1.length;i++){
			for(int j=0;j<board1[0].length;j++){
				board[i][j] = board1[i][j].charAt(0);
			}
		}
//		{
//				{'E', 'E', 'E', 'E', 'E'},
//				{'E', 'E', 'M', 'E', 'E'},
//				{'E', 'E', 'E', 'E', 'E'},
//				{'E', 'E', 'E', 'E', 'E'}
//		};

//		{
//				{'B', '1', 'E', '1', 'B'},
//				{'B', '1', 'M', '1', 'B'},
//				{'B', '1', '1', '1', 'B'},
//				{'B', 'B', 'B', 'B', 'B'}
//		};

		int []click = new int[]{29,2};
		//System.out.println(board[29][2]);
		char [][]ans = sol.updateBoard(board,click);
		for(char[] row:ans){
			for(char ele:row){
				System.out.print(" "+ele);
			}
			System.out.println();
		}
	}
}
