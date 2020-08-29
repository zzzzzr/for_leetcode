package Leetcode;

class Solution7 {
	public int reverse_1(int x) {
		int rev=0;
		//long int rev;
		int sign=x>0?1:-1;
		int orig=x;
		x=Math.abs(x);
		while(x!=0){
			int mod=x%10;
			rev=rev*10+mod;
			x=x/10;
			if(x>0&&x<10){
				orig=x;
			}
		}
		if(rev%10==orig){
			return sign*rev;
		}

		return 0;
	}
	public int reverse(int x) {
		int rev=0;
		int sign=x>0?1:-1;
		x=Math.abs(x);
		while(x!=0){
			if ((rev * 10) / 10 != rev) {
				rev = 0;
				break;
			}
			int mod=x%10;
			rev=rev*10+mod;
			x=x/10;
		}
		return sign*rev;
	}
}
/*
* if ((ans * 10) / 10 != ans) {
			ans = 0;
			break;
		}
		* */
public class Leetcode7 {
	public static void main(String []args){
		int test=1201451313;
		Solution7 tes=new Solution7();
		System.out.println(tes.reverse(test));
	}
}
