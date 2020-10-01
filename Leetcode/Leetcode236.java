package Leetcode;

import java.util.*;
import LeetcodeStructure.*;

/*
执行用时：7 ms, 在所有 Java 提交中击败了99.91%的用户
内存消耗：40.9 MB, 在所有 Java 提交中击败了81.07%的用户
 */
class Solution236 {

	TreeNode ans;
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		dfs1(root, p, q);
		return ans;
	}
	public int dfs1(TreeNode root,TreeNode p,TreeNode q){
		if (root==null||ans!=null)
			return 0;

		System.out.println(root.val);


		int leftnum=dfs1(root.left, p, q);
		int rightnum=dfs1(root.right, p, q);

		int thisnum=leftnum+rightnum;
		if (root==p||root==q){
			thisnum+= 1;
		}
		if (thisnum==2&&ans==null)
			ans=root;

		return thisnum;
	}

	/*-----------------------------------------------------------------------------*/

	List<TreeNode> lis1,lis2,temp;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		temp=new LinkedList<>();
		dfs(root, p, q);
		int i=0;
		while(i<lis1.size()&&i<lis2.size()&&lis1.get(i)==lis2.get(i)){
			i++;
		}
		return lis1.get(i-1);
	}
	public void dfs(TreeNode root,TreeNode p,TreeNode q){
		if (root==null)
			return;
		if (lis1!=null&&lis2!=null)
			return;

		temp.add(root);
		// visit val
		if (root==p){
			lis1 = new LinkedList<>(temp);
		}
		if (root==q){
			lis2 = new LinkedList<>(temp);
		}

		dfs(root.left, p, q);
		dfs(root.right, p, q);

		temp.remove(temp.size()-1);
	}
}
public class Leetcode236 {
	public static void main(String []args){
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(0);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(7);
		TreeNode node9 = new TreeNode(4);
		//TreeNode node1 = new TreeNode(1);
		node1.left=node2;
		node1.right=node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left =node8;
		node5.right = node9;

		Solution236 sol = new Solution236();
		TreeNode nodeans=sol.lowestCommonAncestor1(node1,node2,node9);
		System.out.println(sol.ans.val);
	}
}
