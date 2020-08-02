package JZoffer;

import java.util.Arrays;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
/*
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
 */

class SolutionJZoffer07 {
	int findIndex(int[] nums,int target){
		for(int i=0;i<nums.length;i++){
			if(nums[i]==target)
				return i;
		}
		return -1;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 边界输入的检查，同时也可以作为递归终止条件
		if(preorder.length<=0)
			return null;
		TreeNode father=new TreeNode(preorder[0]);
		int midin=findIndex(inorder,preorder[0]);

		// 构造左子树
		if(midin==0)
			father.left=null;
		else {
			int[] leftpre = new int[midin ];
			System.arraycopy(preorder, 1, leftpre, 0, midin );
			int[] leftin = new int[midin ];
			System.arraycopy(inorder, 0, leftin, 0, midin );
			father.left = buildTree(leftpre, leftin);
		}
		// 构造右子树
		if(midin== preorder.length-1){
			father.right=null;
		}
		else {
			int[] rightpre = new int[preorder.length - midin-1];
			System.arraycopy(preorder, midin + 1, rightpre, 0, preorder.length - midin-1);
			int[] rightin = new int[preorder.length - midin-1];
			System.arraycopy(inorder, midin + 1, rightin, 0, preorder.length - midin-1);
			father.right = buildTree(rightpre, rightin);
		}
		//System.out.println(""+father.val);
		return father;
	}
	public void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + "->");
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
	}
}
public class JZoffer07 {
	public static void main(String []args) {
		int []pre= new int[]{3,9,5,20,15,7};
		int []in = new int[]{5,9,3,15,20,7};
		SolutionJZoffer07 sol= new SolutionJZoffer07();
		sol.preOrderTraverse1(sol.buildTree(pre,in));
	}
}
