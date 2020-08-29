package Leetcode;//Leetcode 122
import java.lang.*;
class Solution122 {    
    public int maxProfit(int [] prices){
		if(prices.length==0||prices==null){
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
        int valley = prices[0];
        int peak = prices[0];
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
		int test[]= new int []{1,2,3,4,5};
        //{7,6,4,3,1};
        //{1,2,3,4,5};
		//{7,1,5,3,6,4};
		Solution122 tes=new Solution122();
		System.out.println(tes.maxProfit(test));
	}
}