package JZoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SolutionJZoffer29 {
	public int[] spiralOrder(int[][] matrix) {
		int m= matrix.length;
		if(m<=0)
			return new int[]{};
		int n=matrix[0].length;
		int round=Math.min(m/2,n/2);
		int []ans = new int[m*n];
		List<Integer> lis=new LinkedList<>();
		int index=0;
		for(int i=0;i<(m+1)/2;i++){
			// up
			for(int j=i;j<=n-i-1;j++){
				ans[index]=matrix[i][j];
				lis.add(matrix[i][j]);
				index++;
				if(index>=m*n)
					return ans;
			}
			// right
			for(int j=i+1;j<m-i-1;j++){
				ans[index]= matrix[j][n-i-1];
				index++;
				if(index>=m*n)
					return ans;
			}
			// down
			for(int j=n-i-1;j>i;j--){
				ans[index]= matrix[m-i-1][j];
				index++;
				if(index>=m*n)
					return ans;
			}
			// left
			for(int j=m-i-1;j>i;j--){
				ans[index]=matrix[j][i];
				index++;
				if(index>=m*n)
					return ans;
			}
		}
		return ans;
	}

	// leetcode54
	public List<Integer> spiralOrder1(int[][] matrix) {
		int m= matrix.length;
		if(m<=0)
			return new LinkedList<Integer>();
		int n=matrix[0].length;

		List<Integer> lis=new LinkedList<>();
		int left=0,right=n-1,up=0,down=m-1,i,j;

		while(left<=right&&up<=down){

			for(i=up, j=left;j<=right;j++){
				lis.add(matrix[i][j]);
			}

			for(i=up+1, j=right;i<=down;i++){
				lis.add(matrix[i][j]);
			}

			if(left<=right&&up<=down) {
				for (i = down, j = right - 1; j >= left; j--) {
					lis.add(matrix[i][j]);
				}

				for (i = down - 1, j = left; i > up; i--) {
					lis.add(matrix[i][j]);
				}
			}

			left++;
			right--;
			up++;
			down--;

		}
		return lis;
	}
}
public class JZoffer29 {
	public static void main(String []args){
		int [][]nums=new int[][]{
				{1, 2, 3, 4,114},
				{5, 6, 7, 8,118},
				{9,10,11,12,1112},
				{13,14,15,16,1116},
				{17,18,19,20,1120},
				{21,22,23,24,1124},
				{25,26,27,28,1128}
		};
		SolutionJZoffer29 sol=new SolutionJZoffer29();
//		int []ans= sol.spiralOrder(nums);
		List<Integer> lis=sol.spiralOrder1(nums);
		for(int num:lis){
			System.out.println(num);
		}
	}
}
