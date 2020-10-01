package Leetcode;

import java.util.*;
import LeetcodeStructure.*;

//class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode(int x) { val = x; }
//}

class Solution257 {
	List<String> ans = new LinkedList<>();
	List<Integer> lis = new LinkedList<>();
	public List<String> binaryTreePaths(TreeNode root) {
		if (root==null)
			return ans;

//		str = new StringBuilder(root.val);
//		if (root.left!=null)
//			dfs(root.left);

		dfs(root);

		return ans;
	}

	public void dfs(TreeNode root){
//		str.append(root.val);
//		str.append("->");
		lis.add(root.val);

		if (root.left==null&&root.right==null){
//			str.delete(str.length()-2,str.length());
//			ans.add(str.toString());
//			str.delete(str.length()-(1+decimallen(root.val)),str.length());
			ans.add(trans(lis));
//			return;
		}

		if (root.left!=null)
			dfs(root.left);

		if (root.right!=null)
			dfs(root.right);

//		str.delete(str.length()-(3+decimallen(root.val)),str.length());
		lis.remove(lis.size()-1);
	}

	public String trans(List<Integer> lis){
		StringBuilder strb = new StringBuilder();
		for (int str:lis){
			strb.append(str);
			strb.append("->");
		}
		return strb.substring(0,strb.length()-2);
	}

	public int decimallen(int num){
		return (int)Math.log10(num);
	}
}
/*
["37->-34->-100",
"37->-34->-48->-100",
"37->-34->-48->-1048->-54->-71",
"37->-34->-48->-1048->-54->-7-22->8"]

["37->-34->-100",
"37->-48->-100",
"37->-48->48->-54->-71",
"37->-48->48->-54->-22->8"]

[
								37,
				-34,                            -48,
		null,           -100,           -100,           48,
					null,   null,   null,   null,   -54,    null,
												-71,    -22,
											null,null,null,8
]
 */
public class Leetcode257 {
	public static void main(String []args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;

		Solution257 sol = new Solution257();
		List<String> ans = sol.binaryTreePaths(node1);
		for (String s:ans){
			System.out.println(s);
		}
	}
}
