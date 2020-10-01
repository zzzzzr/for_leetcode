package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}
class Solution107 {
	List<List<Integer>> ans = new LinkedList<>();
	List<List<Integer>> ans1 = new LinkedList<>();
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root==null)
			return ans;
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()){
			int len = que.size();
			List<Integer> lis = new LinkedList<>();
			while(len>0&&!que.isEmpty()){
				len--;
				TreeNode temp = que.poll();
				lis.add(temp.val);
				if (temp.left!=null)
					que.offer(temp.left);
				if (temp.right!=null)
					que.offer(temp.right);
			}
			ans1.add(lis);
		}
		while (!ans1.isEmpty()){
			ans.add(ans1.remove(ans1.size()-1));
		}
		return ans;
	}
}
public class Leetcode107 {
	public static void main(String []args){
		Solution107 sol = new Solution107();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left=node2;
		node1.right=node3;
		node3.left=node4;
		node3.right=node5;
		for (List<Integer> lis: sol.levelOrderBottom(node1))
			System.out.println(lis);
	}
}
