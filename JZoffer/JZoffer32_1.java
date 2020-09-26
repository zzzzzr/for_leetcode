package JZoffer;
import java.util.*;
import LeetcodeStructure.*;
class SolutionJZoffer32_1 {
	public int[] levelOrder(TreeNode root) {
		if(root==null)
			return new int[]{};
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		List<Integer> lis=new LinkedList<>();
		//lis.add(root.val);

		TreeNode temp;
		while(!que.isEmpty()){
			temp=que.poll();
			lis.add(temp.val);
			if(temp.left!=null)
				que.offer(temp.left);
			if(temp.right!=null)
				que.offer(temp.right);
		}
		return lis.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
}
public class JZoffer32_1 {
}
