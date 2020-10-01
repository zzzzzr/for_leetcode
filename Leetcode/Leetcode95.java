package Leetcode;
import LeetcodeStructure.*;
import java.util.*;
class Solution95 {
	public List<TreeNode> generateTrees(int n) {
		if(n==0)
			return new LinkedList<TreeNode>(){};
		return generateTrees(n,1);
	}
	public List<TreeNode> generateTrees(int n,int start){
		//System.out.println("generate"+n+" "+start);
		List<TreeNode> ans = new LinkedList<>();
		if (n==0){
			ans.add(null);
			return ans;
		}
		if (n==1){
			ans.add(new TreeNode(start));
			return ans;
		}
		for (int i = 0;i<=n-1;i++){
			// 所有左右节点数目不同的情况
			List<TreeNode> lis1 = generateTrees(i,start);
			List<TreeNode> lis2 = generateTrees(n-i-1,start+i+1);

			//System.out.println(" "+start+" "+(start+i)+" "+(start+i+1));
			for (TreeNode left:lis1){
				for (TreeNode right:lis2){
					// 把所有左子树的不同情况，右子树的不同情况，组合起来
					TreeNode mid = new TreeNode(start+i);
					mid.left=left;
					mid.right=right;
					ans.add(mid);
				}
			}
		}
		return ans;
	}

	public void bfs(TreeNode root,int n){
		if (root==null){
			return;

		}
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()&&n!=0){
			TreeNode temp = que.poll();
			if (temp!=null){
				System.out.print(" "+temp.val);
				n--;
				que.offer(temp.left);
				que.offer(temp.right);
			}
			else{
				System.out.print(" null");
			}
		}
		System.out.println();
	}

	public int numTrees(int n) {
		if(n<=0){
			return 0;
		}
		int []dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=0;j<=(i-1);j++){
				dp[i]+=dp[j]*dp[i-1-j];
			}
		}
		return dp[n];
	}
}
/*
* 构造一个函数，对给定的连续数组和节点数目，给出所有可能的子树结构
*/

public class Leetcode95 {
	public static void main(String []args){
		Solution95 sol = new Solution95();
		List<TreeNode> ans = sol.generateTrees(0);
		for (TreeNode temp:ans){
			sol.bfs(temp,0);
		}
		System.out.println(sol.numTrees(5));
	}
}
