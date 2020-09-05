package Leetcode;

class Solution60 {
	int []nums = {1,2,3,4,5,6,7,8,9};       // num i = i
	boolean []vis = new boolean[10];        // whether i is visited
	//int []fac = new int[10];                // fac i = i!
	int []fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	public String getPermutation(int n, int k) {
		StringBuilder strb = new StringBuilder();
		//setfac();

		int mod = k-1;
		int multi = n-1;
		while (multi>=0){
			int division = fac[multi];
			k = mod/division;
			mod = mod%division;
			strb.append(getnum(k+1,n));
			//System.out.println(division+" "+mod+" "+k+" ");
			//System.out.println(k+" "+getnum(k));
			multi--;
		}
		return strb.toString();
	}

	public int getnum(int i,int n){
		for (int j=0;j<n;j++){
			if (vis[j])
				continue;
			i--;
			if (i==0){
				vis[j]=true;
				return nums[j];
			}
		}
		return -1;
	}

//	public void setfac(){
//		fac[0]=1;
//		for(int i=1;i<10;i++)
//			fac[i]=fac[i-1]*i;
//	}

//	public int factorial(int n,int tail){
//		if (n==1)
//			return tail;
//		else
//			return factorial(n-1,tail*n);
//	}
}
public class Leetcode60 {
	public static void main(String []args){
		int n=4;
		int k =9;
		Solution60 sol = new Solution60();
		System.out.println(sol.getPermutation(n,k));
	}
}
