//Leetcode 96
class Solution96 {
    public int numTrees(int n) {
        if(n<=0){
            return 0;
        }
        int []dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=(i-1)/2;j++){
				
                if(j!=i-1-j){
                    dp[i]+=dp[j]*dp[i-1-j]*2;
                }
                else{
                    dp[i]+=dp[j]*dp[j];
				}
				
			}
			
		}
        return dp[n];
    }
}

public class Leetcode95{
	public static void main(String []args){
		int test=1;
		Solution96 tes=new Solution96();
		System.out.println(tes.numTrees(test));
	}
}