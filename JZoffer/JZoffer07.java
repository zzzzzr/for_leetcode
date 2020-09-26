package JZoffer;

import java.util.*;
import LeetcodeStructure.*;

//class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode(int x) { val = x; }
//}
/*
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
 */

// Leetcode105

class Solution105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int length = preorder.length;
		for (int i = 0; i < length; i++) {
			indexMap.put(inorder[i], i);
		}
		TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
		if (preorderStart > preorderEnd) {
			return null;
		}
		int rootVal = preorder[preorderStart];
		TreeNode root = new TreeNode(rootVal);
		if (preorderStart == preorderEnd) {
			return root;
		} else {
			int rootIndex = indexMap.get(rootVal);
			int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
			TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
			TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
			root.left = leftSubtree;
			root.right = rightSubtree;
			return root;
		}
	}
}


class SolutionJZoffer07 {

	int findIndexArr(int[] nums,int target,int start,int end){
		//System.out.println(target);
		for(int i=start;i<end;i++){
			if(nums[i]==target)
				return i;
		}
		return -1;
	}

	public TreeNode buildTree1(int[] preorder,int[] inorder ) {
		Map<Integer,Integer> mapp = new HashMap<>();
		for (int i=0;i<inorder.length;i++){
			mapp.put(inorder[i],i);
		}
		return buildTreeArr(preorder,inorder,0,inorder.length,0,inorder.length,mapp);
	}

	// 像通常的数组一样，左闭右开区间
	public TreeNode buildTreeArr(int[]preorder,int[]inorder,  int start1, int end1, int start2, int end2,Map<Integer,Integer>mapp){
		//System.out.println(start1+" "+end1+" "+ start2+" "+end2);
		if (start1>=end1)
			return null;
		if (start1+1==end1)
			return new TreeNode(preorder[start1]);

		TreeNode father=new TreeNode(preorder[start1]);

//		int midin=findIndexArr(inorder,preorder[start1],start1,end1);
		int midin=mapp.get(preorder[start1]);
		//System.out.println(midin);

		System.out.println(start1+1+" "+(start1+midin-start2+1)+" "+start2+" "+midin);
		father.left = buildTreeArr(preorder,inorder,start1+1,start1+midin-start2+1,start2,midin,mapp);

		System.out.println((start1+midin-start2+1)+" "+end1+" "+(midin+1)+" "+end2);
		father.right = buildTreeArr(preorder,inorder,start1+midin-start2+1,end1,midin+1,end2,mapp);

		//System.out.println(""+father.val);
		return father;
	}


	/*-----------------------------------------------------------------------------------------------*/

//	int findIndex(int[] nums,int target){
//		for(int i=0;i<nums.length;i++){
//			if(nums[i]==target)
//				return i;
//		}
//		return -1;
//	}
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		// 边界输入的检查，同时也可以作为递归终止条件
//		if(preorder.length<=0)
//			return null;
//		TreeNode father=new TreeNode(preorder[0]);
//		int midin=findIndex(inorder,preorder[0]);
//
//		// 构造左子树
//		if(midin==0)
//			father.left=null;
//		else {
//			int[] leftpre = new int[midin ];
//			System.arraycopy(preorder, 1, leftpre, 0, midin );
//			int[] leftin = new int[midin ];
//			System.arraycopy(inorder, 0, leftin, 0, midin );
//			father.left = buildTree(leftpre, leftin);
//		}
//		// 构造右子树
//		if(midin== preorder.length-1){
//			father.right=null;
//		}
//		else {
//			int[] rightpre = new int[preorder.length - midin-1];
//			System.arraycopy(preorder, midin + 1, rightpre, 0, preorder.length - midin-1);
//			int[] rightin = new int[preorder.length - midin-1];
//			System.arraycopy(inorder, midin + 1, rightin, 0, preorder.length - midin-1);
//			father.right = buildTree(rightpre, rightin);
//		}
//		//System.out.println(""+father.val);
//		return father;
//	}
	public void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + "->");
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
//		else
//			System.out.print("null->");
	}
}
public class JZoffer07 {
	public static void main(String []args) {
		int []pre= new int[]{1,2,3};
		//{3,9,5,20,15,7};
		int []in = new int[]{3,2,1};
		//{5,9,3,15,20,7};
		SolutionJZoffer07 sol= new SolutionJZoffer07();
		sol.preOrderTraverse1(sol.buildTree1(pre,in));
	}
}
