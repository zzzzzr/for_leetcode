package Leetcode;

import LeetcodeStructure.Node;

class Solution116 {

	// 方法2 巧妙的利用了已经连接好的父节点，这些父节点的 next 指针已经指向了正确的位置
	// 那么他们的next指针的左节点即为当前父节点的右节点的next所指
	// 而当前父节点的左节点指向的则是当前父节点的右节点，这是显然的
	public LeetcodeStructure.Node connect2(LeetcodeStructure.Node root) {
		if (root==null)
			return null;

		root.left.next = root.right;
		root.right.next = root.next.left;

		connect2(root.left);
		connect2(root.right);

		return root;
	}

	public LeetcodeStructure.Node connect(LeetcodeStructure.Node root) {
		if (root == null)
			return null;
		LeetcodeStructure.Node leftchild = root.left;
		LeetcodeStructure.Node rightchild = root.right;
		while (leftchild != null && rightchild != null) {
			leftchild.next = rightchild;

			leftchild = leftchild.right;
			rightchild = rightchild.left;
		}

		connect(root.left);
		connect(root.right);

		return root;
	}

	public void prt(Node root){
		if (root==null) {
			System.out.println("null");
			return;
		}
		System.out.print(root.val+" ");//root.left.val+root.right.val+root.next.val
		if (root.left==null)
			System.out.print("null ");
		else System.out.print(root.left.val+" ");

		if (root.right==null)
			System.out.print("null ");
		else System.out.print(root.right.val+" ");

		if (root.next==null)
			System.out.print("null ");
		else System.out.print(root.next.val+" ");
		System.out.println();

		prt(root.left);
		prt(root.right);
	}
}
public class Leetcode116 {
	public static void main(String []args){

		LeetcodeStructure.Node node7 = new LeetcodeStructure.Node(7);

		LeetcodeStructure.Node node6 = new LeetcodeStructure.Node(6);

		LeetcodeStructure.Node node5 = new LeetcodeStructure.Node(5);

		LeetcodeStructure.Node node4 = new LeetcodeStructure.Node(4);

		LeetcodeStructure.Node node3 = new LeetcodeStructure.Node(3,node6,node7,null);

		LeetcodeStructure.Node node2 = new LeetcodeStructure.Node(2,node4,node5,null);

		LeetcodeStructure.Node node1 = new LeetcodeStructure.Node(1,node2,node3,null);

		Solution116 sol = new Solution116();
		sol.connect2(node1);
		sol.prt(node1);
	}
}
