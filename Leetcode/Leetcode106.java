package Leetcode;

import LeetcodeStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
 */
class Solution106 {
	int findIndexArr(int[] nums,int target,int start,int end){
		//System.out.println(target);
		for(int i=start;i<end;i++){
			if(nums[i]==target)
				return i;
		}
		return -1;
	}

	public TreeNode buildTree1(int[] inorder, int[] postorder) {
		Map<Integer,Integer> mapp = new HashMap<>();
		for (int i=0;i<inorder.length;i++){
			mapp.put(inorder[i],i);
		}
		return buildTreeArr(inorder,postorder,0,inorder.length,0,inorder.length,mapp);
	}

	// 像通常的数组一样，左闭右开区间
	public TreeNode buildTreeArr(int[]inorder, int[]postorder, int start1, int end1, int start2, int end2,Map<Integer,Integer>mapp){
		System.out.println(start1+" "+end1+" "+ start2+" "+end2);
		if (start1>=end1)
			return null;
		if (start1+1==end1)
			return new LeetcodeStructure.TreeNode(postorder[end2-1]);

		TreeNode father=new LeetcodeStructure.TreeNode(postorder[end2-1]);
//		int midin=findIndexArr(inorder,postorder[end2-1],start1,end1);
		int midin=mapp.get(postorder[end2-1]);
		System.out.println(midin);

		father.left = buildTreeArr(inorder,postorder,start1,midin,start2,start2+midin-start1,mapp);

		father.right = buildTreeArr(inorder,postorder,midin+1,end1,start2+midin-start1,end2-1,mapp);

		//System.out.println(""+father.val);
		return father;
	}

	/*-----------------------------------------------------------------------------------------------*/
	int findIndex(int[] nums,int target){
		System.out.println(target);
		for(int i=0;i<nums.length;i++){
			if(nums[i]==target)
				return i;
		}
		return -1;
	}
	public LeetcodeStructure.TreeNode buildTree(int[] inorder, int[] preorder) {
		// 边界输入的检查，同时也可以作为递归终止条件
		if(preorder.length<=0)
			return null;
//		TreeNode father=new TreeNode(preorder[0]);
		LeetcodeStructure.TreeNode father=new LeetcodeStructure.TreeNode(preorder[preorder.length-1]);
		//int midin=findIndex(inorder,preorder[0]);
		int midin=findIndex(inorder,preorder[preorder.length-1]);
		System.out.println(midin);

		// 构造左子树
		if(midin==0)
			father.left=null;
		else {
			int[] leftpre = new int[midin ];
			//System.arraycopy(preorder, 1, leftpre, 0, midin );
			System.arraycopy(preorder, 0, leftpre, 0, midin );
			int[] leftin = new int[midin ];
			//System.arraycopy(inorder, 0, leftin, 0, midin );
			System.arraycopy(inorder, 0, leftin, 0, midin );
			father.left = buildTree(leftin,leftpre);
		}
		// 构造右子树
		if(midin== preorder.length-1){
			father.right=null;
		}
		else {
			int[] rightpre = new int[preorder.length - midin-1];
			//System.arraycopy(preorder, midin + 1, rightpre, 0, preorder.length - midin-1);
			System.arraycopy(preorder, midin , rightpre, 0, preorder.length - midin-1);
			int[] rightin = new int[preorder.length - midin-1];
			//System.arraycopy(inorder, midin + 1, rightin, 0, preorder.length - midin-1);
			System.arraycopy(inorder, midin + 1, rightin, 0, preorder.length - midin-1);
			father.right = buildTree(rightin,rightpre);
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
public class Leetcode106 {
	public static void main(String []args){
		int []inorder ={4,2,5,1,8,6,9,3,7};
		//{1,2,3,4};
		//{4,2,5,1,8,6,9,3,7} ;
		//{9,3,15,20,7};
		int []beorder = {4,5,2,8,9,6,7,3,1};
		//{3,4,2,1};
		//{4,5,2,8,9,6,7,3,1};
		//{9,15,7,20,3};
		Solution106 sol = new Solution106();
		sol.preOrderTraverse1(sol.buildTree1(inorder,beorder));
	}
}
