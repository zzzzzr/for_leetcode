package Leetcode;

import LeetcodeStructure.*;
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}
//  递归
class Solution104 {
	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		else {
			return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
		}
	}
}
public class Leetcode104 {
}
