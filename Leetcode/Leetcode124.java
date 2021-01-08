package Leetcode;

import LeetcodeStructure.*;
class Solution124 {
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(tranverse(root),max);
	}
	public int tranverse(TreeNode root){
		if (root==null)
			return 0;
		int left = tranverse(root.left);
		int right = tranverse(root.right);

		int tempmax;
		if (left>=0 && right>=0) {
			tempmax = root.val + Math.max(left , right);
			max = Math.max(max,root.val + left + right);
		}
		else if (left<0 && right>=0) {
			tempmax = right + root.val;
		}
		else if (left>=0) {
			tempmax = left + root.val;
		}
		else {
			tempmax = root.val;
		}
		max = Math.max(max,tempmax);
		System.out.println(tempmax);
		return tempmax;
	}
}
public class Leetcode124 {
	public static void main(String []args){
		/*
		[5,4,8,11,null,13,4,7,2,null,null,null,1]
							5
						4   8
				11  null    13  4
		7   2
		 */

		TreeNode node1 = new TreeNode(-2);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(-6);

//		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;

		Solution124 sol = new Solution124();
		System.out.println(sol.maxPathSum(node1));
	}
}
