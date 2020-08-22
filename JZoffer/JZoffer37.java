package JZoffer;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.*;
// JZoffer 37
// leetcode 297
class Codec {



	public static class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	}


	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder strb = new StringBuilder("[");
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()){
			TreeNode temp = que.poll();
			if(temp==null)
				strb.append("null,");
			else {
				strb.append(temp.val);
				strb.append(",");
				que.offer(temp.left);
				que.offer(temp.right);
			}
		}
		for(int i=strb.length()-5;i>=0;i-=5){
			if (strb.charAt(i)!='n')
				break;
			strb.delete(i,i+6);
		}
		strb.deleteCharAt(strb.length()-1);

		strb.append("]");

		return strb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length()<=0||data.charAt(1)=='n')
			return null;

		StringBuilder strb = new StringBuilder(data);
		strb.deleteCharAt(0);
		strb.deleteCharAt(strb.length()-1);
		//strb.append(",");

		String []strarr = strb.toString().split(",");
//		for(String str:strarr){
//			System.out.println(str);
//		}


		Queue<TreeNode> que = new LinkedList<>();
		TreeNode head = new TreeNode(Integer.parseInt(strarr[0]));
		que.offer(head);
		int index =1;

		while(index< strarr.length){
			TreeNode temp = que.poll();
			if(strarr[index].charAt(0)=='n'){
				temp.left=null;
			}
			else{
				TreeNode left = new TreeNode(Integer.parseInt(strarr[index]));
				temp.left = left;
				que.offer(left);
			}
			index++;

			if(index>= strarr.length)
				break;
			if(strarr[index].charAt(0)=='n'){
				temp.right=null;
			}
			else{
				TreeNode right = new TreeNode(Integer.parseInt(strarr[index]));
				temp.right = right;
				que.offer(right);
			}
			index++;
		}


		return head;
	}

	public void dfs(TreeNode root){
		if(root==null) {
			System.out.println("null");
			return;
		}
		System.out.println(root.val);
		dfs(root.left);
		dfs(root.right);
	}
}
public class JZoffer37 {
	public static void main(String []args){
		Codec.TreeNode node1 = new Codec.TreeNode(1);
		Codec.TreeNode node2 = new Codec.TreeNode(2);
		Codec.TreeNode node3 = new Codec.TreeNode(3);
		Codec.TreeNode node4 = new Codec.TreeNode(4);
		Codec.TreeNode node5 = new Codec.TreeNode(5);

		node1.left=node2;
		node1.right=node3;
		node3.left=node4;
		node3.right=node5;

		Codec sol = new Codec();
		//System.out.println(sol.serialize(node1));

		//sol.dfs(sol.deserialize(sol.serialize(node1)));

		sol.dfs(sol.deserialize("[-1,0,1]"));

	}
}