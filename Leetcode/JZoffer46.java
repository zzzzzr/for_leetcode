package Leetcode;

class SolutionJZoffer46 {
	/*
	执行结果：通过 显示详情
	执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
	内存消耗：35.2 MB, 在所有 Java 提交中击败了89.86%的用户
	 */
	public int translateNum(int num) {
		char []nums = String.valueOf(num).toCharArray();
		int []dp = new int[nums.length];
		dp[dp.length-1]=1;
		for (int i=dp.length-2;i>=0;i--){
			int sum = (nums[i]-'0')*10+(nums[i+1]-'0');
			//System.out.println(sum);
			if (i==dp.length-2) {
				if (sum>25||(nums[i]=='0'))
					dp[i]=1;
				else
					dp[i]=2;
			}
			else {
				if (sum>25||(nums[i]=='0'))
					dp[i]=dp[i+1];
				else
					dp[i]=dp[i+2]+dp[i+1];
			}
		}
		//System.out.println(Arrays.toString(dp));
		return dp[0];
	}
}
/*
0-25 : a-z
12258
1 2 2 5 8
1 22 5 8
1 2 25 8
12 2 5 8
12 25 8
2*2*1
 */
public class JZoffer46 {
	public static void main(String[]args){
		int num=262417;
		//12617261;
		SolutionJZoffer46 sol = new SolutionJZoffer46();
		System.out.println(sol.translateNum(num));
	}
}
