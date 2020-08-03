import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public void flatten_1(TreeNode root) {
		if(root==null)
			return ;

		Queue<Integer> que=new LinkedList<>();
		dfs_1(que,root);
		root= new TreeNode(que.poll());
		TreeNode start=root;
		root.left=null;
		//que.poll();
		while(!que.isEmpty()){
			start.right=new TreeNode(que.poll());
			start=start.right;
		}
		return;

	}
	void dfs_1(Queue<Integer> que, TreeNode root){
		if(root==null)
			return ;
		que.add(root.val);
		dfs_1(que,root.left);
		dfs_1(que,root.right);
		return ;
	}
// [1,2,5,3,4,null,6]





	public void flatten(TreeNode root) {
		if(root==null)
			return ;

		Queue<TreeNode> que=new LinkedList<>();
		dfs(que,root);
		TreeNode start=root;
		que.poll();
		root.left=null;
		while(!que.isEmpty()){
			start.right=que.poll();
			start=start.right;
		}
		return;

	}
	void dfs(Queue<TreeNode> que, TreeNode root){
		if(root==null)
			return ;
		que.add(root);
		dfs(que,root.left);
		dfs(que,root.right);
		return ;
	}
}
public class Leetcode114 {
}
/*
java.lang.ClassCastException: class TreeNode cannot be cast to class java.lang.Comparable (TreeNode is in unnamed module of loader 'app';
java.lang.Comparable is in module java.base of loader 'bootstrap')
  at line 642, java.base/java.util.PriorityQueue.siftUpComparable
  at line 638, java.base/java.util.PriorityQueue.siftUp
  at line 329, java.base/java.util.PriorityQueue.offer
  at line 35, Solution.dfs
  at line 22, Solution.flatten
  at line 54, __DriverSolution__.__helper__
  at line 84, __Driver__.main
 */