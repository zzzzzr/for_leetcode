package Leetcode;

import LeetcodeStructure.*;

import java.util.LinkedList;
import java.util.Queue;

class Solution222 {
	public int countNodes2(TreeNode root) {
		int height = treeHeight(root);
		if (height==0 || height==1)
			return height;

		//左子树和右子树高度相等，则右子树不完全
		if (treeHeight(root.right) == height-1){
			return (1<<(height-1))+countNodes2(root.right);
		}
		else {
			return (1<<(height-2))+countNodes2(root.left);
		}
	}

	public int treeHeight(TreeNode root){
		if (root==null)
			return 0;
		else
			return 1+treeHeight(root.left);
	}

	public int countNodes1(TreeNode root) {
		if (root==null)
			return 0;
		else return 1+countNodes1(root.left)+countNodes1(root.right);
	}


	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		int count=0;
		while (!que.isEmpty()){
			TreeNode node = que.poll();
			if (node != null){
				count++;
				que.offer(node.left);
				que.offer(node.right);
			}
		}
		return count;
	}
}
public class Leetcode222 {
}
