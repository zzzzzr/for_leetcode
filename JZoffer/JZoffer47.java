package JZoffer;

class SolutionJZoffer47 {
	public int maxValue(int[][] grid) {
		int m= grid.length;
		int n=grid[0].length;
//		// 对倒数第一行的dp进行填充，从倒数第一行的倒数第二列开始
//		for (int i= n-2;i>=0;i--)
//			grid[m-1][i]= grid[m-1][i]+grid[m-1][i+1];
//		// 对倒数第一列的dp进行填充，从倒数第一列的倒数第二行开始
//		for (int i= m-2;i>=0;i--)
//			grid[i][n-1]= grid[i][n-1]+grid[i+1][n-1];
//
//		for (int i=m-2;i>=0;i--){
//			for (int j=n-2;j>=0;j--){
//				grid[i][j]+=Math.max(grid[i][j+1],grid[i+1][j]);
//			}
//		}
//		return grid[0][0];

		// 对第一行的dp进行填充，从第一行的第二列开始
		for (int i= 1;i<n;i++)
			grid[0][i]+= grid[0][i-1];
		// 对第一列的dp进行填充，从第一列的第二行开始
		for (int i= 1;i<m;i++)
			grid[i][0]+= grid[i-1][0];

		for (int i=1;i<m;i++){
			for (int j=1;j<n;j++){
				grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
			}
		}
		return grid[m-1][n-1];
	}
}
public class JZoffer47 {
	public static void main(String []args){
		int [][]nums = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
				};
		SolutionJZoffer47 sol = new SolutionJZoffer47();
		System.out.println(sol.maxValue(nums));
	}
}
