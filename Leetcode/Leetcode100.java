package Leetcode;
import LeetcodeStructure.*;

class Solution100 {
	// DFS
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null)
			return true;
		if(p == null)
			return false;
		if(q == null)
			return false;
		if(p.val!=q.val)
			return false;
		return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	}
}
public class Leetcode100 {
}
