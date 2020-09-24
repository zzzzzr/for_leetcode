package Leetcode;

import java.util.*;

import LeetcodeStructure.TreeNode;

/*
因为这棵树是一个二叉搜索树，所以尽管这不是一个遵循严格升序排列的二叉搜索树
使用中序遍历仍是最好的遍历他的方式，这一点要记住
 */
class Solution501 {

	int tempval=0;
	int count=0;
	int maxcount=0;
	List<Integer> lis = new LinkedList<>();

	public int[] findMode1(LeetcodeStructure.TreeNode root) {
		inordertraverse(root);
		int []ans = new int[lis.size()];
		int index=0;
		for (int i:lis) {
			ans[index] = i;
			index++;
		}
		return ans;
	}

	public void inordertraverse(LeetcodeStructure.TreeNode root){
		if (root==null)
			return;

		inordertraverse(root.left);

		if (root.val==tempval)
			count++;
		else {
			tempval=root.val;
			count=1;
		}
		if (count==maxcount){
			lis.add(root.val);
		}
		else if (count>maxcount){
			maxcount=count;
			lis.clear();
			lis.add(root.val);
		}

		inordertraverse(root.right);
	}



	// ----------------------------------------------------------------

	int max;
	Map<Integer,Integer> mapp ;

	public int[] findMode(LeetcodeStructure.TreeNode root) {
		if (root==null)
			return new int[]{};

		max = Integer.MIN_VALUE;
		mapp = new HashMap<>();

		dfs(root,mapp);

		System.out.println(mapp.toString());
		System.out.println(max);

		int count=0;
		for (int i:mapp.keySet())
			if (mapp.get(i)==max)
				count++;

		int []ans = new int[count];
		int index=0;
		for (int i:mapp.keySet())
			if (mapp.get(i)==max){
				ans[index]=i;
				index++;
			}
		return ans;
	}

	public void dfs(TreeNode root, Map<Integer,Integer> lis){
		if (root==null)
			return;

		// visit
		lis.put(root.val, lis.getOrDefault(root.val, 0)+1);
		max= Math.max(max,lis.get(root.val));
		//System.out.println(root.val+" "+lis.get(root.val)+" "+max);

		dfs(root.left,lis);
		dfs(root.right,lis);
	}
}
public class Leetcode501 {
	public static void main(String[]args){
		Solution501 sol = new Solution501();
		LeetcodeStructure.TreeNode node1 = new LeetcodeStructure.TreeNode(1);
		LeetcodeStructure.TreeNode node2 = new LeetcodeStructure.TreeNode(2);
//		TreeNode node3 = new TreeNode(2);

		node1.right = node2;
//		node2.left = node3;

		System.out.println(Arrays.toString(sol.findMode1(node1)));
	}
}
