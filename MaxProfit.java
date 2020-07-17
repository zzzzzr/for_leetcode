// 309
import java.lang.*;
class Solution309 {
    public int maxProfit_1(int[] prices) {
        if(prices.length==0||prices==null){
            return 0;
        }
        int n=prices.length;
        
        int dp[][] = new int [n][n];
        //1天内，没有操作
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        //2天内，买入卖出或不操作
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=Math.max(prices[i+1]-prices[i],0);
        }
        //3天内，4种选择：开始买入结束卖出，中间两天进行买入卖出的2种情况，不操作
        for(int i=0;i<n-2;i++){
            dp[i][i+2]=Math.max(dp[i][i+1], 0);
            dp[i][i+2]=Math.max(dp[i][i+2], dp[i+1][i+2]);
            dp[i][i+2]=Math.max(dp[i][i+2], prices[i+2]-prices[i]);
        }
        //4天内
        for(int i=0;i<n-3;i++){
            dp[i][i+3]=Math.max(0, prices[i+3]-prices[i]);
            dp[i][i+3]=Math.max(dp[i][i+3], dp[i][i+2]);
            dp[i][i+3]=Math.max(dp[i][i+3], dp[i+1][i+3]);
        }
        //大于等于5天
        for(int j=4;j<n;j++){
            for(int i =0;i+j<n;i++){
				dp[i][i+j]=Math.max(prices[i+j]-prices[i],0);
				//System.out.println(dp[i][i+j]);
				dp[i][i+j]=Math.max(dp[i][i+j], dp[i][i+j-1]);
				dp[i][i+j]=Math.max(dp[i][i+j], dp[i+1][i+j]);
				for(int k=i+2;k<=i+j-2;k++){
					dp[i][i+j]=Math.max(dp[i][i+j], dp[i][k-1]+dp[k+1][i+j]);
				}
            }
		}
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
        return dp[0][n-1];
	}
	
	public int maxProfit_2(int [] prices){
		if(prices.length==0||prices==null){
            return 0;
        }
		int n=prices.length;
		int dp[][]=new int[n][3];
		dp[0][0]=-prices[0];
		dp[0][1]=0;
		dp[0][2]=0;
		for(int i=1;i<n;i++){
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
			dp[i][1]=dp[i-1][0]+prices[i];
			dp[i][2]=Math.max(dp[i-1][1], dp[i-1][2]);
		}
		return Math.max(dp[n-1][1], dp[n-1][2]);
	}

	public int maxProfit(int [] prices){
		if(prices.length==0||prices==null){
            return 0;
        }
		int n=prices.length;
		int dp0=-prices[0],dp1=0,dp2=0;
		int temp0,temp1,temp2;
		for(int i=1;i<n;i++){
			temp0=Math.max(dp0, dp2-prices[i]);
			temp1=dp0+prices[i];
			temp2=Math.max(dp1, dp2);
			dp0=temp0;
			dp1=temp1;
			dp2=temp2;
		}
		return Math.max(dp1, dp2);
	}
}
public class MaxProfit {
	public static void main(String[] args) {

		int test[]= new int []{6,1,3,2,4,7};
		
		Solution309 tes=new Solution309();

		System.out.println(tes.maxProfit_1(test));
	}

//	private static void test(int ito) {
//		Solution solution = new Solution();
//		int rtn;
//		long begin = System.currentTimeMillis();
//		rtn = solution.numTrees(ito);
//		long end = System.currentTimeMillis();
//		System.out.println(ito + ": rtn=" + rtn);
//		System.out.println();
//		System.out.println("耗时：" + (end - begin) + "ms");
//		System.out.println("-------------------");
//	}
}
/**
i
0	  0 0 2 2 3 5
1		0 2 2 3 0
2		  0 0 2 5
3			0 2 5
4			  0 3
5				0

j     0 1 2 3 4 5
 */

/**
  * 
 * 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]f[i][0]；

 * 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]f[i][1]；

 * 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]f[i][2]。

*/