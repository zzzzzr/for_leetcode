import java.util.*;

// 这一题用条件判断避免了重复情况，这一点值得注意
class Solution491 {
	List<List<Integer>> ans = new LinkedList<>();
	List<Integer> lis = new LinkedList<>();

	public List<List<Integer>> findSubsequences1(int[] nums) {
		dfs1(nums,Integer.MIN_VALUE,0);
		return ans;
	}

	public void dfs1(int[]nums,int pre, int now){
		if (now>= nums.length){
			if (lis.size()>=2){
				ans.add(new LinkedList<>(lis));
			}
			return;
		}

		if (nums[now]>=pre){
			lis.add(nums[now]);
			dfs1(nums,nums[now],now+1);
			lis.remove(lis.size()-1);
		}

		//System.out.println(" "+nums[now]+" "+pre);
		// 下面的判断是在深搜到树的最底层后才会执行的语句
		// 数字的重复被默认已经发生
		// 所以要用当前的数字和前一个数字比较
		if (nums[now]!=pre){                     // 如果当前位置数字和上一个数字不重复，才替换数字，否则整个串会与上一个串重复
			//System.out.println(" "+nums[now]+" "+pre);
			dfs1(nums,pre,now+1);           // 把当前位置的数字换成数字中的下一个数字
		}
	}




	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums.length<=1)
			return null;

		for (int i=0;i< nums.length-1;i++){
			List<Integer> lis = new LinkedList<>();
			lis.add(nums[i]);
			dfs(nums,lis,i);
		}
		return ans;
	}
	public void dfs(int[]nums,List<Integer> lis, int i){
		if (i>= nums.length-1)
			return;
		for (int j=i+1;j< nums.length;j++){
			if(nums[i]<=nums[j]){
				lis.add(nums[j] );
				if (lis.size()>=2&&!ans.contains(lis))
					ans.add(new LinkedList<>(lis));
				dfs(nums,lis,j);
				lis.remove(lis.size()-1);
			}
		}
	}
}
public class Leetcode491 {
	public static void main(String []args){
		Solution491 sol = new Solution491();
		int []nums = new int[]{4, 6, 7, 7};
		//{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		//{4, 6, 7, 7};
		List<List<Integer>> ans = sol.findSubsequences1(nums);
		for(List<Integer> lis:ans){
//			for (Integer in:lis){
//				System.out.print(" "+in);
//			}
			System.out.println(lis);
		}
	}
}
