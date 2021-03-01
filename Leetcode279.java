import java.util.*;
class Solution279 {
	int []book;
	int []squre;
	public int numSquares(int n) {
		book = new int[n+1];
		int sqr = (int)Math.sqrt(n);
		squre = new int[sqr+1];
		for(int i=1;i<=sqr;i++){
			book[i*i]=1;
			squre[i]=i*i;
		}
		for (int i=2;i<=Math.min(n,3);i++){
			book[i]=i;
		}
		return dfs(n);
	}
	public int dfs(int n){
		if (book[n]!=0)
			return book[n];
		int sqr = (int)Math.sqrt(n);
		int tempans=Integer.MAX_VALUE;
		for(int i=sqr;i>1;i--){
			tempans = Math.min(tempans,dfs(n-squre[i])+1);
		}
		book[n] = tempans;
		return tempans;
	}
}

class Solution279_1 {
	int[] book;
	int[] squre;

	public int numSquares(int n) {
		book = new int[n + 1];
		Arrays.fill(book,n+1);
		book[0]=0;
		int sqr = (int) Math.sqrt(n);
		squre = new int[sqr + 1];
		for (int i = 1; i <= sqr; i++) {
			book[i * i] = 1;
			squre[i] = i * i;
		}
		for (int i = 2; i <= n; i++) {
			sqr = (int)Math.sqrt(i);
			for (int j=1;j<=sqr;j++){
				book[i] = Math.min(book[i], book[i-squre[j]]+1);
			}
		}
		System.out.println(Arrays.toString(book));
		return book[n];
	}
}
public class Leetcode279 {
	public static void main(String []args){
		Solution279_1 sol = new Solution279_1();
		int num = 13;
		System.out.println(sol.numSquares(num));
	}
}
