package Leetcode;

class Solution861 {
	public int matrixScore(int[][] A) {
		// 把所有行都变为首部为1
		for (int i=0;i<A.length;i++){
			if (A[i][0]==0){
				for (int j=0;j<A[0].length;j++){
					A[i][j]=1-A[i][j];
				}
			}
		}
		// 把每列都变到 1 更多的情况
		for (int i=1;i<A[0].length;i++){
			if (2*count(A,i)<A.length){
				for (int j=0;j< A.length;j++){
					A[j][i]=1-A[j][i];
				}
			}
		}
//		for (int []a:A)
//			System.out.println(Arrays.toString(a));
		// 按位求结果
		int ans=0;
		for (int[] ints : A) {
			for (int j = 0; j < A[0].length; j++) {
				ans += (ints[j] << (A[0].length - j - 1));
			}
		}
		return ans;
	}
	public int count(int [][]num,int column){
		int ans=0;
		for (int[] ints : num) ans += ints[column];
		return ans;
	}
}
public class Leetcode861 {
	public static void main(String []args){
		int [][]num = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
		Solution861 sol = new Solution861();
		System.out.println(sol.matrixScore(num));
	}
}
