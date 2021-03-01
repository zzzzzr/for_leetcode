import java.util.*;
class Solution74 {
	public boolean searchMatrix1(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if(target<matrix[0][0] || target>matrix[m-1][n-1]) {
//			System.out.println("1");
			return false;
		}
		int mid, low=0, high=m*n;
		while(low<high){
			mid = (low+high)/2;
			System.out.println(low+" "+high+" "+mid+" "+matrix[mid/n][mid%n]);
			if(target > matrix[mid/n][mid%n]){
				low = mid+1;
			}
			else if(target < matrix[mid/n][mid%n]){
				high = mid;
			}
			else
				return true;
		}
//		System.out.println("2");
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if(target<matrix[0][0] || target>matrix[m-1][n-1])
			return false;
		int i;
		for(i=0;i<m;i++){
			if(target>=matrix[i][0] && target<=matrix[i][n-1])
				break;
		}
		if(i==m)
			return false;
		int mid;
		int low=0,high=n;
		while(low<high){
			mid = (low+high)/2;
			if(target > matrix[i][mid]){
				low = mid+1;
			}
			else if(target < matrix[i][mid]){
				high = mid;
			}
			else
				return true;
		}
		return false;
	}

	public boolean binarySearch(int[]num, int target, int low, int high){
		int mid;
		while(low<high){
			mid = (low+high)/2;
			if(target > num[mid]){
				low = mid+1;
			}
			else if(target < num[mid]){
				high = mid;
			}
			else
				return true;
		}
		return false;
	}
}
public class Leetcode74 {
	public static void main(String []args){
		Solution74 sol = new Solution74();
		int [][]num = {{1}};

//		{
//				{1,3,5,7},
//				{10,11,16,20},
//				{23,30,34,60}
//		};

		int target = 1;
//		System.out.println(sol.binarySearch(num[0],target,0,4 ));
		System.out.println(sol.searchMatrix1(num,target));
	}
}
