package JZoffer;
class SolutionJZ04 {
	public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
		if(matrix.length<=0)
			return false;
		int lowindex=0;
		int highindex=Math.min(matrix.length, matrix[0].length);
		int i=0,j= matrix[0].length-1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] > target)
				j--;
			else i++;
		}
		return false;
	}

	// n*m
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix.length<=0)
			return false;
		int lowindex=0;
		int highindex=Math.min(matrix.length, matrix[0].length);
		for(int i=0;i<highindex;i++){
			if(matrix[i][i]==target)
				return true;
			if(matrix[i][i]<target)
				lowindex=i;
			if(matrix[i][i]>target){
				highindex=i;
				break;
			}
		}
		for(int i=lowindex;i>=0;i--){
			for(int j=lowindex+1;j< matrix.length;j++){
				if(matrix[j][i]==target)
					return true;
			}
		}
		for(int i=lowindex;i>=0;i--){
			for(int j=lowindex+1;j< matrix[0].length;j++){
				if(matrix[i][j]==target)
					return true;
			}
		}
		for(int i=lowindex+1;i< matrix.length;i++){
			for(int j=lowindex+1;j< matrix[0].length;j++){
				if(matrix[i][j]==target)
					return true;
			}
		}
		return false;
	}
}
public class JZoffer04 {
	public static void main(String []args) {
		int[][] matrix = new int[][]{
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		int target = 20;
		SolutionJZ04 sol = new SolutionJZ04();
		System.out.println(sol.findNumberIn2DArray_1(matrix, target));
	}
}
