import java.util.*;
class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
class Solution559 {
	public int maxDepth(Node root) {
		if(root==null)
			return 0;
		//System.out.println(root.val);
		int tempmax= 1;
		//Node temp=root.children.;
		for (Node node : root.children) {
			tempmax = Math.max(tempmax, maxDepth(node)+ 1) ;
		}
		return tempmax;
	}
	// Leetcode 104
//	public int maxDepth(TreeNode root) {
//		if(root==null){
//			return 0;
//		}
//		else {
//			return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
//		}
//	}
}
public class Leetcode559 {
}
