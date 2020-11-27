package Leetcode;

import java.util.*;
class Solution733 {
	class cordinate{
		int row;
		int column;
		cordinate(int x,int y){
			row=x;
			column = y;
		}
	}
	int hang,lie;
	int objectcolor;
	boolean viseted[][];
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		hang = image.length;
		lie = image[0].length;
		objectcolor = image[sr][sc];
		viseted = new boolean[hang][lie];
		Queue<cordinate> que = new LinkedList<>();
		que.add(new cordinate(sr,sc));
		viseted[sr][sc]=true;
		while(!que.isEmpty()){
			cordinate temp = que.poll();
			image[temp.row][temp.column]=newColor;
			if(temp.row-1>=0&&!viseted[temp.row-1][temp.column]&&image[temp.row-1][temp.column]==objectcolor) {
				que.add(new cordinate(temp.row - 1, temp.column));
				viseted[temp.row-1][temp.column]=true;
			}
			if(temp.row+1<hang&&!viseted[temp.row+1][temp.column]&&image[temp.row+1][temp.column]==objectcolor) {
				que.add(new cordinate(temp.row + 1, temp.column));
				viseted[temp.row+1][temp.column]=true;
			}
			if(temp.column-1>=0&&!viseted[temp.row][temp.column-1]&&image[temp.row][temp.column-1]==objectcolor) {
				que.add(new cordinate(temp.row, temp.column - 1));
				viseted[temp.row][temp.column-1]=true;
			}
			if(temp.column+1<lie&&!viseted[temp.row][temp.column+1]&&image[temp.row][temp.column+1]==objectcolor) {
				que.add(new cordinate(temp.row, temp.column + 1));
				viseted[temp.row][temp.column+1]=true;
			}

		}
		return image;
	}
}
public class Leetcode733 {
	public static void main(String []args){
		int [][]nums ={{0,0,0},{0,1,1}};
		//{{1,1,1},{1,1,0},{1,0,1}};
		int sr=1,sc=1;
		int newcolor =1;
		Solution733 sol = new Solution733();
		int [][]ans = sol.floodFill(nums,sr,sc,newcolor);
		for(int []lie:ans){
			for(int pixel:lie){
				System.out.print(" "+pixel);
			}
			System.out.println();
		}
	}
}
