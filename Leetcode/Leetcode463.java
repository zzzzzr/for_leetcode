package Leetcode;

import java.util.*;

class Solution463 {


	public int islandPerimeter(int[][] grid) {
		int count= 0;
		int edge = 0;
//		int [][]direction={{-1,1,0,0},{0,0,-1,1}};
		int [][]direction={{-1,0},{0,-1}};
		int newrow;
		int newcolumn;
		for (int i=0;i<grid.length;i++){
			for (int j=0;j<grid[0].length;j++){
				if (grid[i][j]==1) {
					count++;
//					for (int k=0;k<4;k++){
//						newrow = i+direction[0][k];
//						newcolumn = j+direction[1][k];
//						if (newrow>=0&&newrow< grid.length &&newcolumn>=0&&newcolumn<grid[0].length){
//							if (grid[newrow][newcolumn]==1)
//								edge++;
//						}
//					}
					for (int k=0;k<2;k++){
						newrow = i+direction[0][k];
						newcolumn = j+direction[1][k];
						if (newrow>=0 && newcolumn>=0 && grid[newrow][newcolumn]==1){
							edge++;
						}
					}
				}
			}
		}
//		System.out.println();
		return 4*count-2*edge;
	}
}

public class Leetcode463 {
	public static void main(String []args){

	}
}
