package JZoffer;
// 题解2 单调栈算法 很深刻，对二叉搜索树的理解满分，值得看
// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/dan-diao-di-zeng-zhan-by-shi-huo-de-xia-tian/
class SolutionJZoffer33 {
	public boolean verifyPostorder(int[] postorder) {
		if(postorder.length<=0)
			return true;
		int index1=-2,index2=-2;
		int i=0,len= postorder.length;

		while(postorder[i]<postorder[len-1]){
			i++;
		}
		index1=i-1;
		// 0~index1 左子树
		while(postorder[i]>postorder[len-1]){
			i++;
		}
		index2=i-1;
		// index1+1~index2 右子树
		// 考虑多种情况：
		if(i!=len-1)
			// 不能按照二叉平衡树的规律区分左子树、右子树
			return false;
		if(index1==-1)
			// 左子树为空
			return verify(postorder,0,index2);
		else if(index2==index1)
			// 右子树为空
			return verify(postorder,0,index1);
		else
			return verify(postorder,0,index1)&&verify(postorder,index1+1,index2);
	}
	public boolean verify(int[]postorder,int start,int end){
		if(end-start==0||end-start==1)
			return true;
		int index1=-2,index2=-2;
		int i=start;
		while(postorder[i]<postorder[end]){
			i++;
		}
		index1=i-1;
		while(postorder[i]>postorder[end]){
			i++;
		}
		index2=i-1;
		System.out.println(""+index1+" "+index2);
		if(i!=end)
			return false;
		if(index1==start-1)
			return verify(postorder,start,index2);
		else if(index2==index1)
			return verify(postorder,start,index1);
		else
			return verify(postorder,start,index1)&&verify(postorder,index1+1,index2);
	}
}
public class JZoffer33 {
	public static void main(String []args){
		int []nums=new int[]{1,2,5,10,6,9,4,3};
		//{1,6,3,2,5};
		//{1,3,2,6,5};
		SolutionJZoffer33 sol=new SolutionJZoffer33();
		System.out.println(sol.verifyPostorder(nums));
		double x=Math.floorMod(5,3);
	}
}
