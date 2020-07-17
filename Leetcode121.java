//package Leetcode121;
import java.lang.*;
class Solution121 {
	public int maxProfit_1(int [] prices){
		if(prices.length<=1||prices==null){
			return 0;
		}
		int n=prices.length;
		int dp1=0,dp2=0;
		for(int i=0;i<n;i++){
			dp1=0;
			for(int j=i+1;j<n;j++){
				dp1=Math.max(dp1, prices[j]-prices[i]);
			}
			dp2=Math.max(dp2, dp1);
		}
		return dp2;
	}
	public int maxProfit_2(int [] prices){
		if(prices.length<=1||prices==null){
			return 0;
		}
		int n=prices.length;
		int dp2=0;
		int min[]=new int [n],max[]=new int [n];
		min[0]=prices[0];
		for(int i=1;i<n;i++){
			min[i]=Math.min(min[i-1], prices[i]);
		}
		max[n-1]=prices[n-1];
		for(int i=n-2;i>=0;i--){
			max[i]=Math.max(max[i+1], prices[i]);
		}
		for(int i=0;i<n;i++){
			dp2=Math.max(dp2, max[i]-min[i]);
		}
		return dp2;
	}
	public int maxProfit(int [] prices){
		if(prices.length<=1||prices==null){
			return 0;
		}
		int n=prices.length;
		//int dp2=0;
		int minprice=prices[0],maxprofit=0;
		for(int i=0;i<n;i++){
			if(minprice>prices[i]){
				minprice=prices[i];
			}
			if(maxprofit<prices[i]-minprice){                
				maxprofit=prices[i]-minprice;
			}
			//System.out.println(minprice);
		}
		return maxprofit;
	}

}
public class Leetcode121{
	public static void main(String []args){
		int test[]= new int []{7,6,4,3,1};
		//{7,6,4,3,1};
		//{7,1,5,3,6,4};
		Solution121 tes=new Solution121();
		// int res=tes.maxProfit(test);
		// System.out.println(res);
		System.out.println(tes.maxProfit(test));
	}
}

/**
 * 
 */