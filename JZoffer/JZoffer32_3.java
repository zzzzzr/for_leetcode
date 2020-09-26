package JZoffer;
import java.util.*;
import LeetcodeStructure.*;
class SolutionJZoffer32_3 {

	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> lis=new LinkedList<>();
		if(root==null)
			return lis;
		Deque<TreeNode> deque=new LinkedList<>();
		deque.offer(root);
		List<Integer> templis;
		TreeNode temp;
		boolean flag=true;
		int size;

		while(!deque.isEmpty()){
			templis=new LinkedList<>();
			size=deque.size();
			if(flag){
				for(int j=0;j<size&&!deque.isEmpty();j++){
					temp=deque.pollFirst();
					templis.add(temp.val);
					if (temp.left != null) {
						deque.offerLast(temp.left);
					}
					if (temp.right != null) {
						deque.offerLast(temp.right);
					}
				}
			}
			else{
				for(int j=0;j<size&&!deque.isEmpty();j++){
					temp=deque.pollLast();
					templis.add(temp.val);
					if (temp.right != null) {
						deque.offerFirst(temp.right);
					}
					if (temp.left != null) {
						deque.offerFirst(temp.left);
					}
				}
			}
			flag=!flag;
			lis.add(templis);
		}
		return lis;
	}



	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lis=new LinkedList<>();
		if(root==null)
			return lis;
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		List<Integer> templis;

		int index1=1,index2=0;
		boolean flag=true;
		TreeNode temp;
		int size;

		while(!que.isEmpty()){
			templis=new LinkedList<>();
			size= que.size();
			for(int i=0;i<size&&!que.isEmpty();i++){
				temp=que.poll();
				templis.add(temp.val);
				if (temp.left != null) {
					que.offer(temp.left);
				}
				if (temp.right != null) {
					que.offer(temp.right);
				}
			}
			if(!flag)
				lis.add(reverse(templis));
			else
				lis.add(templis);
			flag=!flag;
		}
		return lis;
	}
	public List<Integer> reverse(List<Integer> lis){
		//List<Integer> ans=new LinkedList<>();
		int start=0,end=lis.size()-1;
		int p;
		while(start<end){
			p=lis.get(start);
			lis.set(start,lis.get(end));
			lis.set(end,p);
			start++;
			end--;
		}
		return lis;
	}
}
public class JZoffer32_3 {
}
