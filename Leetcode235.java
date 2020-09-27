
import java.util.*;
import LeetcodeStructure.*;
class Solution235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val==p.val||root.val==q.val|| (p.val< root.val&&q.val>root.val))
			return root;
		if (p.val< root.val)
			return lowestCommonAncestor(root.left,p,q);
		else return lowestCommonAncestor(root.right, p, q);

	}
}
public class Leetcode235 {
}
