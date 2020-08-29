package Leetcode;

class Solution312 {
	//int max=0;


	// 没有完全理解，需要继续思考
	public int maxCoins(int[] nums) {
		int n=nums.length;
		int [][]dp=new int[n+2][n+2];
		int []value=new int[n+2];
		int multipal=1;
		System.arraycopy(nums, 0, value, 1, n);
		value[0]=1;
		value[n+1]=1;
		for(int i=n-1;i>=0;i--){
			for(int j=i+2;j<n+2;j++){
				for(int k=i+1;k<j;k++){
					multipal=value[i]*value[k]*value[j];
					multipal+=dp[i][k]+dp[k][j];
					dp[i][j]=Math.max(multipal,dp[i][j]);
				}
			}

		}
		return dp[0][n+1];
	}



	int maxrec=0;
	int num=0;
	int[]status;
	//深搜超时
	public int maxCoins_1(int[] nums) {
		if(nums.length<=0){
			return 0;
		}
		status=new int [nums.length];
		num=nums.length;
		int max=0;
		for(int i=0;i<nums.length;i++){
			max=0;
			num--;
			status[i]=1;
			balloon(i,status,num,nums,max);
			num++;
			status[i]=0;
		}
		return maxrec;
	}

	//戳破第i个气球，并在可选的气球中选一个戳破,statue[i]=1表示气球已被戳破
	public void balloon(int i,int []status,int num,int []nums,int max){
		if(num==0){
			max+=nums[i];
			if(max>maxrec)
				maxrec=max;
			//System.out.println();
			return;
		}
		//戳破
		//找到i左边的气球
		int left=1;
		if(i!=0)
		{
			for (int j = i - 1;j>=0;j--){
				if(status[j]==0){
					left=nums[j];
					break;
				}
			}
		}
		int right=1;
		if(i!=nums.length-1){
			for(int j=i+1;j<nums.length;j++){
				if(status[j]==0){
					right=nums[j];
					break;
				}
			}
		}
		max+=left*nums[i]*right;
		for(int j=0;j<nums.length;j++){
			if(status[j]==0){
				//System.out.println(j);
				num--;
				status[j]=1;
				balloon(j,status,num,nums,max);
				num++;
				status[j]=0;
			}
		}
		//return 0;
	}
}

public class Leetcode312 {
	public static void main(String []args){
		int []nums=new int []{7,9,8,0,7,1,3,5,5,2,3,3};
		//{3,1,5,8};
		//{1,2,3};
		Solution312 sol=new Solution312();
		System.out.println(sol.maxCoins(nums));
	}
}
