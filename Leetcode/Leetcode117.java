package Leetcode;

import java.util.*;

import LeetcodeStructure.Node;
/*
在每一层开始时先给出第一个节点，然后再在数目内继续给出其他节点，依次相连

 */

/*
[
				0,
		2                   ,4,
	1,      null,       3,      -1,
 5,    1,           null, 6,  null, 8
 ]
 */

class Solution117 {

	/*
	执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
	内存消耗：38.7 MB, 在所有 Java 提交中击败了22.90%的用户
	*/
	LeetcodeStructure.Node temp ;
	LeetcodeStructure.Node start ;

	public LeetcodeStructure.Node connect3(LeetcodeStructure.Node root) {

		temp = root;

		if (root.left!=null)
			start=root.left;
		else if (root.right!=null)
			start = root.right;
		else
			return root;


		while(temp!=null) {
			findnextside(temp, start);
			findnextlevel(start);
		}

		return root;
	}

	// 在当前一层已经连接好以后，依次查找每一个节点，查看他是否有子节点，返回第一个非空子节点
	public void findnextlevel(LeetcodeStructure.Node root){
		while(root!=null){
			if (root.left!=null) {
				start= root.left;
				temp=root;
				return;
			}
			if (root.right!=null) {
				start = root.right;
				temp = root;
				return;
			}

			root = root.next;
		}
		temp=null;
		start=null;
	}

	public void findnextside(LeetcodeStructure.Node root, LeetcodeStructure.Node lastnode){
		if (root!=null)
			System.out.print(root.val+" ");
		else System.out.print("null ");

		if (lastnode!=null)
			System.out.println(lastnode.val+" ");
		else System.out.println("null ");


		if (root.left ==lastnode&&root.right!=null) {
			lastnode.next = root.right;
			findnextside(root,root.right);
		}
		else {
			root = root.next;
			while(root!=null){
				if (root.left!=null) {
					lastnode.next= root.left;
					findnextside(root,root.left);
					return;
				}
				else if (root.right!=null) {
					lastnode.next= root.right;
					findnextside(root,root.right);
					return;
				}
				root = root.next;
			}
		}
	}

	/*------------------------------------------------------------------*/

	public LeetcodeStructure.Node connect(LeetcodeStructure.Node root) {
		if (root==null)
			return null;
		Queue<LeetcodeStructure.Node> que = new LinkedList<>();
		que.offer(root);
		int oldnum,newnum=1;
		while(!que.isEmpty()){
			oldnum = newnum;
			newnum = 0;

			LeetcodeStructure.Node lastnode = que.poll();
			if (lastnode.left!=null) {
				que.offer(lastnode.left);
				newnum++;
			}
			if (lastnode.right!=null) {
				que.offer(lastnode.right);
				newnum++;
			}

			for (int i=0;i<oldnum-1;i++){
				LeetcodeStructure.Node temp = que.poll();
				if (temp.left!=null) {
					que.offer(temp.left);
					newnum++;
				}
				if (temp.right!=null) {
					que.offer(temp.right);
					newnum++;
				}

				lastnode.next=temp;
				lastnode=temp;
			}
			lastnode.next = null;

		}
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
public class Leetcode117 {
	public static void main(String []args){

		LeetcodeStructure.Node node10 = new LeetcodeStructure.Node(8);
		LeetcodeStructure.Node node9 = new LeetcodeStructure.Node(6);
		LeetcodeStructure.Node node8 = new LeetcodeStructure.Node(1);
		LeetcodeStructure.Node node7 = new LeetcodeStructure.Node(5);
		LeetcodeStructure.Node node6 = new LeetcodeStructure.Node(-1,null,node10,null);
		LeetcodeStructure.Node node5 = new LeetcodeStructure.Node(3,null,node9,null);
		LeetcodeStructure.Node node4 = new LeetcodeStructure.Node(1,node7,node8,null);
//		Node node3 = new Node(3,node6,node7,null);
		LeetcodeStructure.Node node3 = new LeetcodeStructure.Node(4,node5,node6,null);
		LeetcodeStructure.Node node2 = new LeetcodeStructure.Node(2,node4,null,null);
		LeetcodeStructure.Node node1 = new LeetcodeStructure.Node(1,node2,node3,null);

		Solution117 sol = new Solution117();
		sol.connect3(node1);
		System.out.println();
		sol.prt(node1);
		System.out.println();
		System.out.println(node4.next.val);
	}
}
