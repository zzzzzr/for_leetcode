package Leetcode;

import LeetcodeStructure.*;
import LeetcodeStructure.TreeNode;

import java.util.*;
class Solution404 {
	int sum = 0;
	public int sumOfLeftLeaves(LeetcodeStructure.TreeNode root) {
		if (root==null)
			return 0;
		dfs(root);

		return sum;
	}
	public void dfs(TreeNode root){
		if (root == null)
			return;

		// visit
		if (root.left != null && root.left.left==null && root.left.right == null)
			sum+=root.left.val;

		dfs(root.left);
		dfs(root.right);
	}
}
public class Leetcode404 {
}
