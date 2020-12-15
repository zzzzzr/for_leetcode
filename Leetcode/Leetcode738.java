package Leetcode;

class Solution738 {
	public int monotoneIncreasingDigits1(int N) {
		int []numarr = new int[10];
		int len=0;
		while (N!=0){
			numarr[len]=N%10;
			N=N/10;
			len++;
		}
		int i;
		for (i=len-2;i>=0;i--){
			if (numarr[i]<numarr[i+1])
				break;
		}
		if (i>=0) {
			int j;
			for (j = i + 1; j < len - 1; j++) {
				if (numarr[j] > numarr[j + 1]) {
					break;
				}
			}
			numarr[j]--;
			for (int k = 0; k < j; k++)
				numarr[k] = 9;
			if (numarr[j] == 0 && j == len - 1)
				len--;
		}
		int ans=0;
		for (i=len-1;i>=0;i--){
			ans*=10;
			ans+=numarr[i];
		}
		return ans;
	}

	public int monotoneIncreasingDigits(int N) {
		int []numarr = new int[10];
		int len=0;
		while (N!=0){
			numarr[len]=N%10;
			N=N/10;
			len++;
		}
		for (int i=len-2;i>=0;i--){
			// 满足单调递增，不做改变
			if (numarr[i]>=numarr[i+1])
				continue;
			// 否则，向前寻找一个可以变化的位，将值减一
			int j;
			for (j=i+1;j<len-1;j++){
				if (numarr[j]>numarr[j+1]){
					break;
				}
			}
			numarr[j]--;
			for (int k=0;k<j;k++)
				numarr[k]=9;
			if (numarr[j]==0 && j==len-1)
				len--;


		}
		int ans=0;
		for (int i=len-1;i>=0;i--){
			ans*=10;
			ans+=numarr[i];
		}
		return ans;
	}
}
public class Leetcode738 {
	public static void main(String []args){
		int n=1234;
		Solution738 sol = new Solution738();
		System.out.println(sol.monotoneIncreasingDigits1(n));
	}
}
