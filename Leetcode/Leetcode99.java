package Leetcode;
import LeetcodeStructure.*;
import java.util.*;
class Solution99 {
	int index=0;
	public void recoverTree(TreeNode root) {
		if(root==null)
			return;
		List<Integer> lis= new LinkedList<>();
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()){
			TreeNode temp=que.poll();
			lis.add(temp.val);
			if(temp.left!=null)
				que.offer(temp.left);
			if(temp.right!=null)
				que.offer(temp.right);
		}
		int []nums=new int[lis.size()];
		for(int i=0;i< lis.size();i++){
			nums[i]=lis.get(i);
		}
		Arrays.sort(nums);
		dfs(root,nums);
	}
	void dfs(TreeNode root,int []nums){
		if(root.left!=null){
			dfs(root.left,nums);
		}
		root.val=nums[index];
		index++;
		if(root.right!=null){
			dfs(root.right,nums);
		}
	}

	public void midvisit(TreeNode root){
		Stack<TreeNode> sta=new Stack<>();
		//sta.push(root);
		while(!sta.isEmpty()||root!=null){
			// 把当前节点的左节点以及左节点的左节点等等加入栈
			while(root!=null){
				sta.push(root);
				root=root.left;
			}
			// 已经到了最下层的左节点，取出该节点，访问之
			TreeNode temp=sta.pop();
			visit(temp);
			// 下面两行不能加
			// 弹出当前节点上一层的节点，访问之
			// 中序遍历顺序为 左中右，访问完左则访问中
//			temp=sta.pop();
//			visit(temp);
			// 根节点设置为 右，在下一次循环中不断加入栈中
			root=temp.right;
		}
	}
	public void visit(TreeNode root){
		System.out.println(root.val);
	}
}
class Solution99_1 {
	/*
	通过dfs中序遍历整个二叉树，将值存储到list中
	顺序遍历整个list，正确的搜索二叉树的中序遍历结果应该是递增数列
	找到其中不正常的位置的值
		如果是两个不相邻的位置，那么会产生2组异常的大小关系
			另 j,k=-1
			对于 a_i > a_i+1, a_l > a_l+1
			先遇到 a_i , a_i+1 的异常关系，将 a_i+1 赋值给 k，因为 j=-1，所以把 a_i 赋值给 j
			然后遇到 al , a_l+1 的异常关系，将 a_l+1 赋值给 k，因为j!=-1，所以直接脱离循环
			实际上2组异常的情况就是因为第一组异常里左值太大而第二组异常里右值太小
			这样做就刚好可以把两个异常值存储到 j, k 中
		如果是相邻的情况，则只会产生一组异常大小关系
			用刚才的方法刚好把异常关系里的后置赋值给了 k，而前值赋值给了 j
			后面的循环找不到第二组异常，到达边界，脱离循环
	 */
	public void recoverTree(TreeNode root) {
		if(root==null)
			return;
		List<Integer> lis= new LinkedList<>();
		dfs(root,lis);
		int []loc=findAbnormal(lis);
		backward(root,2,loc[0],loc[1]);
	}
	public void dfs(TreeNode root,List<Integer> list){
		if(root.left!=null)
			dfs(root.left,list);
		list.add(root.val);
		if(root.right!=null)
			dfs(root.right,list);
	}
	int []findAbnormal(List<Integer> list){
		int j=-1,k=-1;
		for(int i=0;i<list.size()-1;i++){
			if(list.get(i)>list.get(i+1)){
				k=list.get(i+1);
				if(j==-1)
					j=list.get(i);
				else
					break;
			}
		}
		return new int[]{j,k};
	}
	public void backward(TreeNode root,int times,int val1, int val2){
		if(root!=null){
			if(root.val==val1||root.val==val2){
				root.val=(root.val==val1? val2:val1);
				times--;
				if(times==0)
					return;
			}
			backward(root.left,times,val1,val2);
			backward(root.right,times,val1,val2);
		}
	}
}

class Solution99_2 {
	public void recoverTree(TreeNode root) {
		if(root==null)
			return;
		Stack<TreeNode> sta=new Stack<>();
		TreeNode x=null,y=null,pre=null;
		while(!sta.isEmpty()||root!=null){
			while(root!=null){
				sta.push(root);
				root=root.left;
			}
			root=sta.pop();
			if(pre!=null&&pre.val>root.val){
				y=root;
				if(x==null)
					x=pre;
				else
					break;
			}
			//visit(temp);
			pre=root;
			root=root.right;
		}

		swap(x,y);
	}
	public void swap(TreeNode x,TreeNode y){
		int temp=x.val;
		x.val=y.val;
		y.val=temp;
	}
}
public class Leetcode99 {
}
