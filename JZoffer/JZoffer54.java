package JZoffer;

import java.util.*;
import LeetcodeStructure.*;
class SolutionJZoffer54 {
	public int kthLargest1(TreeNode root, int k) {
		Stack<TreeNode> sta  = new Stack<>();
		sta.push(root);
		while(!sta.isEmpty()){
			TreeNode tmp = sta.pop();
			if (tmp.left==null && tmp.right==null){
				k--;
				if (k==0)
					return tmp.val;
			}
			else {
				if (tmp.left != null){
					sta.push(tmp.left);
				}
				sta.push(tmp);
				if (tmp.right != null){
					sta.push(tmp.right);
				}
				tmp.left=null;
				tmp.right=null;
			}
		}
		return -1;
	}


	/*
	执行结果：通过显示详情
	执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
	内存消耗：38.2 MB, 在所有 Java 提交中击败了92.51%的用户
	 */
	TreeNode ans = null;
	int ks;
	public int kthLargest(TreeNode root, int k) {
		ks=k;
		dfs(root);
		return ans.val;
	}
	public void dfs(TreeNode root){
		if (root==null||ks<=0)
			return ;

		dfs(root.right);

		// visit root
		ks--;
		if (ks==0)
			ans = root;

		dfs(root.left);

	}
}
public class JZoffer54 {
}
