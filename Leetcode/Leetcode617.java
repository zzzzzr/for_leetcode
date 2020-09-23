package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.TreeNode;

class Solution617 {
	public LeetcodeStructure.TreeNode mergeTrees1(LeetcodeStructure.TreeNode t1, LeetcodeStructure.TreeNode t2) {
		if (t1==null&&t2==null)
			return null;
		LeetcodeStructure.TreeNode temp ;
		if (t1==null) {
//			temp = new TreeNode(t2.val);
//			temp.left = mergeTrees1(null,t2.left);
//			temp.right = mergeTrees1(null,t2.right);
			return t2;
		}
		else if (t2==null) {
//			temp = new TreeNode(t1.val);
//			temp.left = mergeTrees1(t1.left,null);
//			temp.right = mergeTrees1(t1.right,null);
			return t1;
		}
		else {
			temp = new LeetcodeStructure.TreeNode(t1.val + t2.val);
			temp.left = mergeTrees1(t1.left,t2.left);
			temp.right = mergeTrees1(t1.right,t2.right);
			return temp;
		}

	}

	public LeetcodeStructure.TreeNode mergeTrees(LeetcodeStructure.TreeNode t1, LeetcodeStructure.TreeNode t2) {
		if (t1==null&&t2==null)
			return null;
		LeetcodeStructure.TreeNode temp ;
		if (t1==null) {
			temp = new LeetcodeStructure.TreeNode(t2.val);
			temp.left = mergeTrees(null,t2.left);
			temp.right = mergeTrees(null,t2.right);
			return temp;
		}
		else if (t2==null) {
			temp = new LeetcodeStructure.TreeNode(t1.val);
			temp.left = mergeTrees(t1.left,null);
			temp.right = mergeTrees(t1.right,null);
			return temp;
		}
		else {
			temp = new TreeNode(t1.val + t2.val);
			temp.left = mergeTrees(t1.left,t2.left);
			temp.right = mergeTrees(t1.right,t2.right);
			return temp;
		}

	}
}
public class Leetcode617 {
}
