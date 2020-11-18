
import java.util.*;
class Solution1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//		int range = Math.max(Math.max(r0,R-r0-1),Math.max(c0,C-c0));
		int range = Math.max(r0,R-r0-1)+Math.max(c0,C-c0-1);
		System.out.println(range);
		int newr,newc;
		int locup,locdown,locleft,locright;
		int [][]dir={{-1,1,0,0},{0,0,-1,1}};
		int [][]ans = new int[R*C][2];
		ans[0]=new int[]{r0,c0};
		int index = 1;
		for (int i=1;i<=range;i++){
			locup = r0-i;
			locdown = r0+i;
			locleft = c0-i;
			locright  =c0+i;

			for (int j=0;j<i;j++){
				newr = r0-i+j;
				newc = c0+j;
				if (newr>=0 && newr<R && newc>=0 && newc <C){
					ans[index] = new int[]{newr,newc};
					index++;
				}
			}
			for (int j=0;j<i;j++){
				newr = r0+j;
				newc = c0+i-j;
				if (newr>=0 && newr<R && newc>=0 && newc <C){
					ans[index] = new int[]{newr,newc};
					index++;
				}
			}
			for (int j=0;j<i;j++){
				newr = r0+i-j;
				newc = c0-j;
				if (newr>=0 && newr<R && newc>=0 && newc <C){
					ans[index] = new int[]{newr,newc};
					index++;
				}
			}
			for (int j=0;j<i;j++){
				newr = r0-j;
				newc = c0-i+j;
				if (newr>=0 && newr<R && newc>=0 && newc <C){
					ans[index] = new int[]{newr,newc};
					index++;
				}
			}

		}
		return ans;
	}
}
public class Leetcode1030 {
	public static void main(String []args){
		int R=2;
		int C=3;
		int r0=1;
		int c0=2;
		Solution1030 sol = new Solution1030();
//		System.out.println(Arrays.toString(sol.allCellsDistOrder(R,C,r0,c0)));
		for (int []arr:sol.allCellsDistOrder(R,C,r0,c0))
			System.out.println(Arrays.toString(arr));
	}
}
