package JZoffer;
import java.util.*;
// 也是LeetCode102

/**
 * 也可以直接在每层遍历之前用一个值记录当前队列的长度，这一长度就是该层的节点数目
 * 则只要依次取出与长度对应的前N个节点即可
 */
class SolutionJZoffer32_2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lis=new LinkedList<>();
		if(root==null)
			return lis;
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		List<Integer> templis=new LinkedList<>();
		int index1=1,index2=0;
		TreeNode temp;
		while(!que.isEmpty()){
			while(index1>0&&!que.isEmpty()) {
				temp = que.poll();
				index1--;
				templis.add(temp.val);
				if (temp.left != null) {
					que.offer(temp.left);
					index2++;
				}
				if (temp.right != null) {
					que.offer(temp.right);
					index2++;
				}
			}
			index1=index2;
			index2=0;
			lis.add(templis);
			templis=new LinkedList<>();
		}
		return lis;
	}
}
public class JZoffer32_2 {
}
