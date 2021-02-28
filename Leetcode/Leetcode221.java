package Leetcode;

class Solution221 {
	public int maximalSquare1(char[][] matrix) {
		int ans=0;
		int m = matrix.length;
		int n = matrix[0].length;
		int [][]dp = new int[m][n];
		for(int i=0;i<m;i++)
			if(matrix[i][0]=='1') {
				dp[i][0] = 1;
				ans=1;
			}
		for(int j=0;j<n;j++)
			if(matrix[0][j]=='1') {
				dp[0][j] = 1;
				ans=1;
			}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j]=='1'){
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
					ans = Math.max(dp[i][j], ans);
				}
				else{
					dp[i][j]=0;
				}
			}
		}
		return ans*ans;
	}

	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int ans=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]=='1'){
					ans = Math.max(ans,max(matrix,i,j));
					System.out.println(i+" "+j+" "+max(matrix,i,j));
				}
			}
		}
		return ans*ans;
	}
	public int max(char [][]ch, int p, int q){
		int l = Math.min(ch.length-p-1,ch[0].length-q-1);
		int k;
		for(k=1;k<=l;k++){
			for(int i=0;i<k;i++){
				if(ch[p+k][q+i]=='0')
					return k;
				if(ch[p+i][q+k]=='0')
					return k;
			}
			if(ch[p+k][q+k]=='0')
				return k;
		}
		return k;
	}
	public void print(char[][]ch, int p, int q){
		int l = Math.min(ch.length-p-1,ch[0].length-q-1);
		int k;
		for(k=1;k<=l;k++){
			for(int i=0;i<k;i++){
				System.out.println((p+k)+" "+(q+i)+" "+ch[p+k][q+i]);
				System.out.println((p+i)+" "+(q+k)+" "+ch[p+i][q+k]);
			}
			System.out.println((p+k)+" "+(q+k)+" "+ch[p+k][q+k]);
		}
	}
}
public class Leetcode221 {
	public static void main(String []args){
		char [][]ch ={{'0'}};

//		{
//				{'0','1'},
//				{'1','0'}
//		};

//		{
//				{'1','0','1','0','0'},
//				{'1','0','1','1','1'},
//				{'1','1','1','1','1'},
//				{'1','0','0','1','0'}
//		};

		Solution221 sol = new Solution221();
//		System.out.println(sol.max(ch,1,2));
//		System.out.println(sol.max(ch,1,3));
		System.out.println(sol.maximalSquare(ch));
	}
}
