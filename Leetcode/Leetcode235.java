package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.TreeNode;

class Solution235 {
	public LeetcodeStructure.TreeNode lowestCommonAncestor(LeetcodeStructure.TreeNode root, LeetcodeStructure.TreeNode p, TreeNode q) {
		if (root.val==p.val||root.val==q.val|| (p.val< root.val&&q.val>root.val))
			return root;
		if (p.val< root.val)
			return lowestCommonAncestor(root.left,p,q);
		else return lowestCommonAncestor(root.right, p, q);

	}
}
public class Leetcode235 {
}
