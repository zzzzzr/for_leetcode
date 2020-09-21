package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.TreeNode;

/*
1038的提交结果：
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了50.74%的用户
 */

// 同时也是 Leetcode1038
class Solution538 {
	public int sum=0;

	public LeetcodeStructure.TreeNode convertBST(LeetcodeStructure.TreeNode root) {
		taildfs(root);
		return root;
	}

	public void taildfs(TreeNode root){
		if (root==null)
			return;

		taildfs(root.right);

		//visit current val
		sum+= root.val;
		root.val=sum;

		taildfs(root.left);
	}
}
public class Leetcode538 {
}
