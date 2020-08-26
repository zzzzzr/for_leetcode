import java.util.*;


/*
这道题用摩尔投票法没有问题，问题在于没有必要在遍历一次之后就得到结果
可以通过第二次遍历确认两个数字是否满足大于长度/3的限制
这样做时间复杂度仍然在O(n)
 */
class Solution229 {
	List<Integer> lis = new LinkedList<>();
	public List<Integer> majorityElement(int[] nums) {
		int len = nums.length/3;
		int []ans = new int[2];
		ans[0]=-1;
		ans[1]=-1;
		int []vote = new int[2];

		for(int item : nums){

			if (vote[0]==0&&item!=ans[1]){
				ans[0]=item;
			}
			else if (vote[1]==0&&item!=ans[0]) {
				ans[1] = item;
			}

			if (item==ans[0])
				vote[0]++;
			else if (item==ans[1])
				vote[1]++;
			else {
				vote[0]--;
				vote[1]--;
			}

		}

		vote[0]=0;
		vote[1]=0;
		for(int item : nums){
			if (item== ans[0])
				vote[0]++;
			if (item== ans[1])
				vote[1]++;
		}

		if (vote[0]> len)
			lis.add(ans[0]);
		if (vote[1]> len)
			lis.add(ans[1]);

		return lis;
	}
}
public class Leetcode229 {
	public static void main(String []args) {
		int[] nums = new int[]{1,2,2,3,2,1,1,3};
		//{1,2,3,4};
		//{1,1,1,2,2,3,3,2};
		//{3,2,3};
		//{1,1,1,2,2,3};
		//{6, 6, 6, 7, 7};
		Solution229 sol = new Solution229();
		System.out.println(sol.majorityElement(nums));

	}
}
