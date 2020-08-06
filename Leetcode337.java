import java.util.*;
//  https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
class Solution337 {

	public int rob(TreeNode root) {
		int len=0;
		return dfs(root);
	}
	int dfs(TreeNode root){
		// 这里dfs指搜索参数treenode自身，得到的结果是当前节点的最优结果
		if(root==null)
			return 0;
		int value=root.val;
		if(root.left!=null){
			value+=dfs(root.left.left)+dfs(root.left.right);
		}
		if(root.right!=null){
			value+=dfs(root.right.left)+dfs(root.right.right);
		}
		return Math.max(dfs(root.left)+dfs(root.right),value);
	}

	Map<TreeNode,Integer> memory= new HashMap<>();
	int dfs1(TreeNode root){
		if(root==null)
			return 0;
		if(memory.containsKey(root))
			return memory.get(root);
		int value=root.val;
		if(root.left!=null){
			value+=dfs1(root.left.left)+dfs1(root.left.right);
		}
		if(root.right!=null){
			value+=dfs1(root.right.left)+dfs1(root.right.right);
		}
		int ans= Math.max(dfs1(root.left)+dfs1(root.right),value);
		memory.put(root,ans);
		return ans;
	}


}
public class Leetcode337 {
}
