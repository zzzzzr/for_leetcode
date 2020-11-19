package JZoffer;

import LeetcodeStructure.*;
class SolutionJZoffer55_2 {
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
public class JZoffer55_2 {
}
