package JZoffer;
import java.util.*;
import LeetcodeStructure.*;

// 同时也是LeetCode113
class SolutionJZoffer34 {
	List<List<Integer>> lis = new LinkedList<>();
	List<Integer> templis= new LinkedList<>();


	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null)
			return new LinkedList<>();

		//templis.add(root.val);
		dfs(root,sum, 0);

		return lis;
	}

	public void dfs(TreeNode root,int sum,int tempsum){
		if(root==null)
			return;
		if(root.left==null&&root.right==null){
			if(sum==tempsum+ root.val) {
				templis.add(root.val);
				lis.add(new LinkedList<>(templis));
				templis.remove(templis.size()-1);
			}
			return;
		}
		// 在列表中加入当前节点的值，意为访问过该节点
		templis.add(root.val);
		tempsum+= root.val;

		dfs(root.left,sum,tempsum);
		dfs(root.right,sum,tempsum);

		templis.remove(templis.size()-1);
	}



	public List<List<Integer>> pathSum1(TreeNode root, int sum) {
		if(root==null)
			return new LinkedList<>();

		templis.add(root.val);
		dfs(root,sum, root.val);

		return lis;
	}
	public void dfs1(TreeNode root,int sum,int tempsum){
		// 节点是叶子节点
		if(root.left==null&&root.right==null){
			if(sum==tempsum)
				lis.add(new LinkedList<>(templis));
			return;
		}

		// 不是叶子节点，则继续向下
		if(root.left!=null) {
			tempsum+=root.left.val;
			templis.add(root.left.val);
			dfs1(root.left, sum, tempsum);
			tempsum-=root.left.val;
			templis.remove(templis.size()-1);
		}
		if(root.right!=null) {
			tempsum+=root.right.val;
			templis.add(root.right.val);
			dfs1(root.right, sum, tempsum);
			tempsum-=root.right.val;
			templis.remove(templis.size()-1);
		}

	}


}
public class JZoffer34 {
	public static void main(String []args){
		TreeNode root1=new TreeNode(5);
		TreeNode root2=new TreeNode(4);
		TreeNode root3=new TreeNode(8);
		TreeNode root4=new TreeNode(11);
//		TreeNode root5=new TreeNode();
		TreeNode root6=new TreeNode(13);
		TreeNode root7=new TreeNode(4);
		TreeNode root8=new TreeNode(7);
		TreeNode root9=new TreeNode(2);
//		TreeNode root10=new TreeNode();
//		TreeNode root11=new TreeNode();
//		TreeNode root12=new TreeNode();
//		TreeNode root13=new TreeNode();
		TreeNode root14=new TreeNode(5);
		TreeNode root15=new TreeNode(1);

		root1.left=root2;
		root1.right=root3;
	}
}
