package algorithm_datastructure;
import java.util.*;
class binary_search_tree{
	class TreeNode{
		public TreeNode parent;
		public TreeNode left;
		public TreeNode right;
		public int key;
		public TreeNode(int k){
			this.key = k;
			this.parent  =null;
			this.left = null;
			this.right = null;
		}
	}

	TreeNode tree;

	TreeNode search(TreeNode root,int key){
		while (root != null && root.key!=key){
			if (root.key>key)
				root = root.left;
			else
				root = root.right;
		}
		return root;
	}

	TreeNode get_min(TreeNode root){
		if (root == null)
			return null;
		if (root.left == null)
			return root;
		while(root.left!=null)
			root = root.left;
		return root;
	}

	TreeNode get_max(TreeNode root){
		if (root == null)
			return null;
		if (root.right == null)
			return root;
		while(root.right!=null)
			root = root.right;
		return root;
	}

	TreeNode get_prior(TreeNode root){
		if (root==null)
			return null;
		if (root.left!=null){
			root = root.left;
			while (root!=null){
				root=root.right;
			}
			return root;
		}
		else{
			TreeNode pre = root;
			root = root.parent;
			while (root != null && root.left == pre){
				pre = root;
				root = root.parent;
			}
			return root;
		}
	}

	TreeNode get_next(TreeNode root){
		if (root==null)
			return null;
		if (root.right!=null){
			root = root.right;
			while (root!=null){
				root=root.left;
			}
			return root;
		}
		else {
			TreeNode pre = root;
			root = root.parent;
			while (root != null && root.right == pre) {
				pre = root;
				root = root.parent;
			}
			return root;
		}
	}

	void insert(TreeNode root, int key){
		TreeNode par = null;
		while (root !=null){
			par = root;
			if (root.key>key)
				root = root.left;
			else
				root = root.right;
		}
		TreeNode temp = new TreeNode(key);
		temp.parent = par;
		if (key< par.key)
			par.left=temp;
		else
			par.right = temp;
	}

	/*
	对节点z的删除分3种情况
	如果z没有孩子结点，那么只是简单地将它删除，并修改它的父结点，用null作为孩子来替换z。
	如果z只有一个孩子结点，那么将这个孩子提升到树中z的位置上，并修改它的父结点，用z的孩子来替换z。
	如果z有两个孩子结点，那么找z的后继（一定在z的右子树中）y，并让y占据树中z的位置。z的原来右子树部分成为y的新的右子树，z的原来左子树部分成为y的新的左子树。
	 */
	void delete(TreeNode tar){
		// 有一个子树为空，则直接把另一个移到现在的位置即可
		if (tar.left==null)
			transplant(tar,tar.right);
		else if (tar.right==null)
			transplant(tar,tar.left);
		// 左右子树为空的3种情况已解决
		// 接下来解决左右子树都存在的情况
		else {
			TreeNode transnode = get_min(tar.right);
			if (transnode.parent != tar){
				transplant(transnode,transnode.right);
				transnode.right = tar.right;
				tar.right.parent = transnode;
			}
			transplant(tar,transnode);
			transnode.left = tar.left;
			tar.left.parent = transnode;
		}

	}

	// 用新子树代替旧子树
	void transplant(TreeNode oldnode,TreeNode newnode){
		if (oldnode.parent ==null) {
			tree = newnode;
			return;
		}
		// 把原节点的父节点的对应左/右子树指针指向新节点
		if (oldnode.parent.left==oldnode)
			oldnode.parent.left = newnode;
		else if (oldnode.parent.right == oldnode)
			oldnode.parent.right = newnode;
		// 把新节点的父节点指针指向原节点的父节点
		if (newnode!=null)
			newnode.parent = oldnode.parent;
	}

}
public class BST {
}
