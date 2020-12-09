package Leetcode;

import java.util.*;
class Solution118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new LinkedList<>();
		if (numRows<=0)
			return ans;
		List<Integer> temp  =new LinkedList<>();
		temp.add(1);
		ans.add(temp);
		if (numRows==1)
			return ans;
//		temp  =new LinkedList<>();
//		temp.add(1);
//		temp.add(1);
//		ans.add(temp);
//		if (numRows==2)
//			return ans;
//		//int []num = new int[1000];
		List<Integer> lastlist = temp;
		int i=2;
		while (i<=numRows){
			temp = new LinkedList<>();
			temp.add(1);
			for (int j=0;j<i-2;j++)
				temp.add(lastlist.get(j)+lastlist.get(j+1));
			temp.add(1);
			ans.add(temp);
			lastlist=temp;
			i++;
		}
		return ans;
	}
}
public class Leetcode118 {
	public static void main(String []args){
		int numrow=5;
		Solution118 sol = new Solution118();
		for (List<Integer> lis:sol.generate(numrow))
			System.out.println(lis.toString());
	}
}