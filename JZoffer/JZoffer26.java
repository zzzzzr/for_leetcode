package JZoffer;
class SolutionJZoffer26 {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(A==null&&B==null)
			return true;
		if(A == null)
			return false;
		if(B == null)
			return false;
		if(A.val!=B.val)
			return isSubStructure(A.left,B)||isSubStructure(A.right,B);
		if(isSubTree(A, B))
			return true;
		return isSubStructure(A.left,B)||isSubStructure(A.right,B);
	}
	// 这个函数借用了今天的每日一题，LEETCODE100的想法，但有所不同
	public boolean isSubTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null)
			return true;
		if(p == null)
			return false;
		if(q == null)
			return false;
		if(p.val!=q.val)
			return false;
		return isSubTree(p.left,q.left)&&isSubTree(p.right,q.right);
	}
}
public class JZoffer26 {
}
