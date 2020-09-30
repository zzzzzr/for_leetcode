package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
//import LeetcodeStructure.TreeNode;

/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了31.99%的用户
 */
class Solution701 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode temp = root;
		while(temp!=null){
			if (val<temp.val){
				if (temp.left==null){
					temp.left=new TreeNode(val);
					return root;
				}
				else{
					temp = temp.left;
				}
			}
			else{
				if (temp.right==null){
					temp.right=new TreeNode(val);
					return root;
				}
				else{
					temp = temp.right;
				}
			}
		}
		return new TreeNode(val);
	}
}
public class Leetcode701 {
}
