package Leetcode;

import java.util.*;
class NumMatrix {
	int [][]ans_matrix;
	public NumMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		ans_matrix = new int[m+1][n+1];
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				ans_matrix[i+1][j+1] = ans_matrix[i+1][j]+ans_matrix[i][j+1]-ans_matrix[i][j]+matrix[i][j];
			}
		}
		for (int []arr:ans_matrix){
			System.out.println(Arrays.toString(arr));
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return ans_matrix[row2+1][col2+1]-ans_matrix[row2+1][col1]-ans_matrix[row1][col2+1]+ans_matrix[row1][col1];
	}
}
public class Leetcode304 {
	public static void main(String []args){
		int [][]matrix = {
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		};
		NumMatrix nm = new NumMatrix(matrix);
		System.out.println(nm.sumRegion(2, 1, 4, 3));
		System.out.println(nm.sumRegion(1, 1, 2, 2));
		System.out.println(nm.sumRegion(1, 2, 2, 4));
	}
}
/*
matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

 */