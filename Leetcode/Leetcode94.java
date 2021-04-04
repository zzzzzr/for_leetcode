package Leetcode;

import java.util.*;
import LeetcodeStructure.*;

//	class TreeNode {
//	  int val;
//	  TreeNode left;
//	  TreeNode right;
//	  TreeNode(int x) { val = x; }
//	}

class Solution94 {

		// 二叉树的非递归中序遍历
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Deque<TreeNode> stk = new LinkedList<TreeNode>();
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}



	public List<Integer> inorderTraversal1(TreeNode root) {
		Stack<TreeNode> sta = new Stack<>();

		sta.add(root);
		while (sta.peek().left!=null){
			sta.push(sta.peek().left);
		}
		while (!sta.isEmpty()){

			TreeNode temp = sta.pop();
			if (temp.right==null)
				ans.add(temp.val);
			else {
				ans.add(temp.val);
				sta.push(temp.right);
				while (sta.peek().left!=null){
					sta.push(sta.peek().left);
				}
			}
		}
		return ans;
	}


	public 	List<Integer> ans = new LinkedList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
//		if (root==null)
//			return ans;

		dfs(root);

		return ans;
	}
	public void dfs(TreeNode root){
		if (root==null)
			return;
		dfs(root.left);
		ans.add(root.val);
		dfs(root.right);
	}
}
public class Leetcode94 {
}
