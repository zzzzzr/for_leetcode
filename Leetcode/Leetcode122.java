package Leetcode;//Leetcode 122
import java.lang.*;
class Solution122 {
	// 这里用贪心的思想会更简单
	// 反正只能经手一笔交易，那就只算两天价格的差价即可
	// 有价格的增加即卖出，否则不动
	// 如果价格有连续增加，那么连续的相减最后也等价于最末减最初
	// 取0和两天之差的最大值也保证了我们不会买入过大的股票以至于卖不出去，因为一开始这支股票就是不值得购入的
	public int maxProfit2(int [] prices){
		if(prices.length==0)
			return 0;
		int ans=0;
		for(int i=1;i<prices.length;i++){
			ans += Math.max(0,prices[i]-prices[i-1]);
		}
		return ans;
	}

    public int maxProfit(int [] prices){
		if(prices.length==0){
            return 0;
        }
		int n=prices.length;
        int dp0=-prices[0],dp1=0;        
        int temp0,temp1;        
		for(int i=1;i<n;i++){
			temp0=Math.max(dp0, dp1-prices[i]);
			temp1=Math.max(dp1, dp0+prices[i]);
			dp0=temp0;
			dp1=temp1;			
		}
        return dp1;
    }
    
    public int maxProfit_1(int[] prices) {
        int i = 0;
        int valley ;
        int peak ;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
    

}

public class Leetcode122{
	public static void main(String []args){
		int []test= new int []{1,2,3,4,5};
        //{7,6,4,3,1};
        //{1,2,3,4,5};
		//{7,1,5,3,6,4};
		Solution122 tes=new Solution122();
		System.out.println(tes.maxProfit(test));
	}
}