package Leetcode;//Leetcode 120
import java.lang.*;
import java.util.List;
/**
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 */
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int []dp=new int [m];
        for(int i=0;i<m;i++)
        {
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j]=Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
                //System.out.print(dp[j]+"\t");
            }
            //System.out.println();
        }
        return dp[0];
    } 
}


public class Leetcode120{
	public static void main(String []args){
		//int test[]= new int []{1,2,3,4,5};
        //List <List>triangle=new List<List<Integer>>;
		Solution120 tes=new Solution120();
		//System.out.println(tes.minimumTotal());
	}
}