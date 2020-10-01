package Leetcode;

import java.util.*;
import LeetcodeStructure.*;

//class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode(int x) { val = x; }
//}
class Solution637 {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new LinkedList<>();
		if (root==null)
			return ans;
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		double sum;
		int num;
		while (!que.isEmpty()){
			int len = que.size();
			sum=0.0;
			num=0;

			while(num<len&&!que.isEmpty()){
				TreeNode temp = que.poll();
				sum+= temp.val;
				num++;
				if (temp.left!=null)
					que.offer(temp.left);
				if (temp.right!=null)
					que.offer(temp.right);
			}
			ans.add(sum/len);
		}
		return ans;
	}


}
public class Leetcode637 {
}
