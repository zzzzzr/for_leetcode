package Leetcode;//Leetcode 123
import java.lang.*;
class Solution123 {    
    
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices==null){
            return 0;
        }
        int n=prices.length;
        int [][][]dp=new int[n][3][2];      //第n天，进行了k次买卖，手中是否有股票
        dp[0][0][0]=0;
        dp[0][1][0]=-999;
        dp[0][0][1]=-999;
        dp[0][1][1]=-prices[0];
        dp[0][2][0]=-999;
        dp[0][2][1]=-999;
        for(int i=1;i<n;i++){
            for(int j=1;j<=2;j++){
                dp[i][j][1]=Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
                dp[i][j][0]=Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
            }
            
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<3;j++){
        //         for(int k=0;k<2;k++){
        //             System.out.print(dp[i][j][k]+"\t");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        return Math.max(Math.max(dp[n-1][2][0],dp[n-1][1][0]),dp[n-1][0][0]);
    }


    public int maxProfit_1(int[] prices) {
        if(prices.length==0||prices==null){
            return 0;
        }
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int profit[]=new int [prices.length/2+1];
        int index=0;
        int j=0,k=1;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            profit[index] = peak - valley;
            index++;
        }
        if(index==0){
            return 0;
        }
        if(index==1){
            return profit[0];
        }
        for(i=2;i<index;i++){
            if(profit[j]<profit[i]){
                profit[j]=profit[i];
                j=i;
                continue;
            }
            if(profit[k]<profit[i]){
                profit[k]=profit[i];
                k=i;
                continue;
            }
        }
        return profit[j]+profit[k];
    }    
}

public class Leetcode123{
	public static void main(String []args){
        int test[]= new int []{1,2,4,2,5,7,2,4,9,0};
        //{1,2,4,2,5,7,2,4,9,0};
        //{3,3,5,0,0,3,1,4};
        //{7,6,4,3,1};
        //{1,2,3,4,5};
		//{7,1,5,3,6,4};
		Solution123 tes=new Solution123();
		System.out.println(tes.maxProfit(test));
	}
}

/**
 * 
0       -999    
-999    -1      
0       0       

0       0       
1       -1      
2       0

0       0
2       -1
3       0

0       0
3       -1
4       0

0       0
4       -1
5       0
 */