package Leetcode;

import java.util.*;
class Solution119 {
	public List<Integer> getRow2(int rowIndex) {
		int []ans=new int[rowIndex+1];
		ans[0]=1;

		for (int i=1;i<rowIndex+1;i++) {
			ans[i] = 1;
			for (int j=i-1;j>0;j--){
				ans[j]=ans[j]+ans[j-1];
			}
			//System.out.println(i+":"+Arrays.toString(ans));
		}

		List<Integer> temp = new LinkedList<>();
		for (int i:ans)
			temp.add(i);
		return temp;
	}

	public List<Integer> getRow1(int rowIndex) {

		int []ans=new int[rowIndex+1];
		int up=rowIndex;
		int down=1;
		int value=1;
		int index=0;
		while (index<=rowIndex/2){

			ans[index]=value;
			ans[rowIndex-index]=value;

			value=value*up/down;
//			value = (int)(((long)(value*up))/down);

			up--;
			down++;
			index++;
		}
		System.out.println(Arrays.toString(ans));
		List<Integer> temp = new LinkedList<>();
		for (int i:ans)
			temp.add(i);
		return temp;
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> temp = new LinkedList<>();
		if (rowIndex<=0)
			return temp;
		temp.add(1);
		if (rowIndex==1)
			return temp;
		List<Integer> lastlist = temp;
		int i=2;
		while (i<=rowIndex+1){
			System.out.println(temp.toString());
			temp = new LinkedList<>();
			temp.add(1);
			for (int j=0;j<i-2;j++)
				temp.add(lastlist.get(j)+lastlist.get(j+1));
			temp.add(1);
			lastlist=temp;
			i++;
		}
		System.out.println();
		return lastlist;
	}
}
public class Leetcode119 {
	public static void main(String []args){
		int numrow=1;
		Solution119 sol = new Solution119();
//		System.out.println();
		System.out.println(sol.getRow2(numrow));
//			System.out.println(lis.toString());
		// 2147483647
		//  145422675, -131213633
		//  155117520
	}
}
