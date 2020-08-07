package JZoffer;
// 同时也是leetcode226
// 大名鼎鼎的反转二叉树
class SolutionJZoffer27 {
	public TreeNode mirrorTree(TreeNode root) {
		if(root==null)
			return null;
		TreeNode right=mirrorTree(root.left);
		TreeNode left=mirrorTree(root.right);
		root.right=right;
		root.left=left;
		return root;
	}
}
public class JZoffer27 {
}
