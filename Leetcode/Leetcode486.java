package Leetcode;

class Solution486 {
	int [][]dp;

	public boolean PredictTheWinner(int[] nums) {
		if (nums.length<=2)
			return true;

		dp = new int[nums.length][nums.length];

		for (int i=0;i< nums.length;i++){
			dp[i][i] = nums[i];
		}


		for (int i =0;i< nums.length-1;i++){
			dp[i][i+1] = Math.min(nums[i], nums[i+1])-Math.max(nums[i], nums[i+1]);
		}
		//printf();

		int signal=1;
		for (int i=2;i<= nums.length-1;i++){
			for (int j=0;j< nums.length-i;j++){
				if (signal == 1) {
					dp[j][j + i] =Math.max(dp[j][j+i-1]+nums[j+i],dp[j+1][j+i]+nums[j]);
				}
				else {
					dp[j][j+i] = Math.min((dp[j][j+i-1]-nums[j+i]),
							(dp[j+1][j+i]-nums[j]));
				}
			}
			signal = -1*signal;
		}
		//printf1();
		printf();

		if (nums.length%2==1)
			return dp[0][nums.length-1]>=0;
		else
			return dp[0][nums.length-1]<=0;
	}

	/*
	首先，如果nums长度为偶数，则一定是先手的获胜。
	对于这个长度为偶数的数组，他的所有偶数位的数字的和和所有奇数位数字的和的大小关系是确定的
	那么先手的人只需要选择和更大的一方，每次都从那一方取走数字即可。
	比如，奇数方更大，先手方先取1，则对后手方而言只有2 n（为偶数）两取法
	而后手方取完后，不论取的是哪一个位置，先手方都可以继续取奇数位置的数字，而先手方取完后又只有偶数位上的数字留给后手方。。。依次类推
	则对于偶数数字的情况，奇数位 偶数位数字和的大小关系可以确定，则先手方总可以选择一个对自己更有利的取法，先手方必胜

	数组长度为奇数时则不然，只能用标准的dp

	dp[i][j]表示从i到j的最优情况，初始情况dp[i][i]=nums[i]
	甲乙两人先后选取数字，则可认为，其中一人最后选择了某个数字，这个数字应该越大越好
	而另一方的在他前面一次的选择则与之相悖，他希望自己的选择比对方更好，即自己的选择与对方的选择的差越大越好

	实际上，这一想法是普适的，任何一方的想法都是让自己的选择比对方的更好，即自己选择的和与对方选择的和的差越大越好
	而这一点（(a1+a2+...)-(b1+b2+...)）可以被转化为另一个形式：((a1-b1)+(a2-b2)+...)
	刚才的两个式子中的a和b调换位置则是另一方的想法
	于是实际上dp[][]=num[]-dp[][]的状态转移方程即可得到：每一次都是让这次取值和之前对方得到的最大差值作差，得到的即是己方的最大差值
	而后对方又用同样的式子计算对方得到的最大差值，循环往复

	另外，对取值的选取是不定的，可能是已选取数字序列的左边一个，也可以是已选取数字序列的右边一个，所以要用dp对两边的取值方式作比较，得到最大的一个
	因为事实上两个每次得到的都是“自己的”最大差值，他们都希望这个值尽可能的大，所以每次dp都取最大值就可以了

	另，不用考虑数组的奇偶数目对于先后的影响
	可以这么想：每次做完nums[]-dp[][]后的值都是当前一方的最优选择
	而先手方就意味着先选，反过来说就是最后作差的是先手方
	所以最后结果是否>=0其实就决定了先手方和是否大于后手方和，
	而且不论nums为奇或偶，先手方总不会少选，只有多选或选择次数一样的差别
	偶数时，最开始的情况属于后手方，然后不断相互作差
	奇数时，最开始的情况属于先手方，然后...
	 */

	public boolean PredictTheWinner1(int[] nums) {
		if (nums.length<=2||nums.length%2==0)
			return true;

		dp = new int[nums.length][nums.length];

		for (int i=0;i< nums.length;i++){
			dp[i][i] = nums[i];
		}
		for (int i=1;i<= nums.length-1;i++) {
			for (int j = 0; j < nums.length - i; j++) {
				dp[j][j+i] = Math.max(nums[j]-dp[j+1][j+i], nums[j+i]-dp[j][j+i-1]);
			}
		}
		return dp[0][nums.length-1]>=0;
	}



	public void printf(){
		for (int i=0;i< dp.length;i++){
			for (int j=0;j< dp.length-i;j++){
				System.out.printf("%6d",dp[j][j+i]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printf1(){
		for (int []arr:dp){
			for (int i:arr){
				System.out.printf("%6d",i);
			}
			System.out.println();
		}
		System.out.println();
	}

//	public int dfs(int i,int j,int len){
//		int num1 ,num2;
//		if (dp[i+1][j]==0)
//			dp[i+1][j] = dfs(i+1,j  );
//		else
//			num1=dfs()
//		if (dp[i][j-1]!=0)
//			num2=dp[i][j-1];
//
//	}


//	public boolean predict(int[]nums,int start,int end,int tempsum){
//		if (end-start==0) {
//			tempsum += nums[start];
//			return tempsum >= 0;
//		}
//		if (end-start==1){
//			tempsum+=Math.max(nums[start],nums[end] )-Math.min(nums[start],nums[end] );
//			return tempsum>=0;
//		}
//		System.out.println(" "+(tempsum+nums[start]-nums[start+1])+" "+(tempsum+nums[end]-nums[end-1])+" "+(tempsum+Math.max(nums[start],nums[end] )-Math.min(nums[start],nums[end] )));
//		return predict(nums,  start+2, end, tempsum+nums[start]-nums[start+1])||
//				predict(nums,  start, end-2, tempsum+nums[end]-nums[end-1])||
//				predict(nums,  start+1, end-1, tempsum+Math.max(nums[start],nums[end] )-Math.min(nums[start],nums[end] ));
//	}
}
public class Leetcode486 {
	public static void main(String []args){
		Solution486 sol = new Solution486();
		int []nums = new int[]{1, 2, 3,4,5};
		System.out.println(sol.PredictTheWinner1(nums));
	}
}
