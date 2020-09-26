package JZoffer;
import LeetcodeStructure.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
// 同时也是LeetCode101
class SolutionJZoffer28 {
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return isSymme(root.left,root.right);
	}
	public boolean isSymme(TreeNode p,TreeNode q){
		if(p==null&&q==null)
			return true;
		if(p==null||q==null)
			return false;
		if(p.val!=q.val)
			return false;
		return isSymme(p.left,q.right)&&isSymme(p.right,q.left);
	}

	// leetcode101要求的迭代做法
	public boolean isSymmetric1(TreeNode root) {
		if(root==null)
			return true;
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root.left);
		que.offer(root.right);
		TreeNode temp1,temp2;
		while(!que.isEmpty()){
			temp1=que.poll();
			temp2=que.poll();
			if(temp1==null&&temp2==null)
				continue;
			if(temp1==null||temp2==null)
				return false;
			if(temp1.val!=temp2.val)
				return false;
			que.offer(temp1.left);
			que.offer(temp2.right);
			que.offer(temp1.right);
			que.offer(temp2.left);
		}
		return true;
	}
}
public class JZoffer28 {
}
