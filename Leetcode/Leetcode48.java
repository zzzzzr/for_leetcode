package Leetcode;

class Solution48 {
	public void rotate(int[][] matrix) {
		if (matrix.length%2==0){
			int half = matrix.length/2;
			for (int i=0;i< half;i++){
				for (int j=0;j< half;j++){
					int temp = matrix[i][j];
					int p = half-i;
					int q = half-j;

					matrix[i][j]=matrix[half-1+q][half-p];              // 4->1
					matrix[half-1+q][half-p] = matrix[half-1+p][half-1+q];      // 3->4
					matrix[half-1+p][half-1+q] = matrix[half-q][half-1+p];      // 2->3
					matrix[half-q][half-1+p] = temp;                    // 1->2

				}
			}
		}
		else {
			int half = matrix.length/2;
			for (int i=0;i<= half;i++){
				for (int j=0;j< half;j++){
					int temp = matrix[i][j];
					int p = half-i;
					int q = half-j;

					matrix[i][j]=matrix[half+q][half-p];              // 4->1
					matrix[half+q][half-p] = matrix[half+p][half+q];      // 3->4
					matrix[half+p][half+q] = matrix[half-q][half+p];      // 2->3
					matrix[half-q][half+p] = temp;                    // 1->2

				}
			}

		}
	}
	public void prt(int [][]num){
		for (int []arr:num) {
			for (int digit:arr){
				System.out.printf("%4d",digit);
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
	}
}
public class Leetcode48 {
	public static void main(String []args){
		int n=7;
		int [][]num = new int[n][n];

//		{
//				{5, 1, 9,11},
//				{2, 4, 8,10},
//				{13, 3, 6, 7},
//				{15,14,12,16}
//		};

		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++)
				num[i][j] = i*n+j;
		}
		Solution48 sol = new Solution48();
		sol.prt(num);
		sol.rotate(num);
		sol.prt(num);
	}
}
