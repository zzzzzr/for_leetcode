
class Solution110 {
	boolean ans=true;
	public boolean isBalanced(TreeNode root) {
		// boolean ans=true;
		if(root==null){
			return true;
		}
		int level=maxDepth(root);
		return ans;
	}

	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		else {
			int height1=maxDepth(root.left);
			int height2=maxDepth(root.right);
			if(Math.abs(height1-height2)>=2)
				ans=false;
			return Math.max(height1,height2)+1;
		}
	}
}
/*
题解的做法是不用类变量
他通过接收两个子节点的高度来计算当前节点是否是平衡的，同时接收两个子节点的是否平衡的bool值来判断整棵树是否平衡
 */
public class Leetcode110 {
}
