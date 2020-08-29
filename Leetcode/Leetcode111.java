package Leetcode;

class Solution111 {
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left==null&&root.right!=null){
			return minDepth(root.right)+1;
		}
		if(root.left!=null&&root.right==null){
			return minDepth(root.left)+1;
		}

		return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);


	}
}
/*
这一题的重点在于必须要有叶子，没有叶子不能算深度
 */
public class Leetcode111 {
}
