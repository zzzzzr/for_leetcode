package Leetcode;

import java.util.*;
class Solution556 {
	public int nextGreaterElement1(int n) {
		int []arr = new int[10];
		int len=0;
		while (n!=0){
			arr[len]=n%10;
			n=n/10;
			len++;
		}
//		System.out.println(Arrays.toString(arr));
		int i;
		for(i=0;i<len-1;i++){
			if(arr[i]>arr[i+1]){
				break;
			}
		}
//		System.out.println(i);
		if (i==len-1)
			return -1;
		int id=i;
		for(int j=i-1;j>=0;j--){
			if(arr[j]>arr[i+1] && arr[j]<arr[id]){
				id=j;
			}
		}
//		System.out.println(id);
		int temp = arr[i+1];
		arr[i+1] = arr[id];
		arr[id] = temp;
//		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr,0,i+1);
//		System.out.println(Arrays.toString(arr));
		for (int left = 0,right=i; left<right; left++,right--){
			temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		int ans=0;
		for (int j=len-1;j>=0;j--){
			if ((ans>Integer.MAX_VALUE/10) ||(Integer.MAX_VALUE-ans*10<arr[j])) {
				// System.out.println((Integer.MAX_VALUE-ans*10)+" "+arr[j]);
				return -1;
			}
			ans= ans*10+arr[j];
		}
		return ans;
	}

	public int nextGreaterElement(int n) {
		char []ch = (""+n).toCharArray();
		int len = ch.length;
		int i;
		for(i=len-1;i>0;i--){
			if(ch[i]>ch[i-1]){
				break;
			}
		}
		if (i==0)
			return -1;
		int id=i;
		for(int j=i+1;j<len;j++){
			if(ch[j]>ch[i-1] && ch[j]<ch[id]){
				id=j;
			}
		}
		char temp = ch[i-1];
		ch[i-1]=ch[id];
		ch[id]=temp;
		Arrays.sort(ch,i,len);
		int ans;
		try {
			ans = Integer.parseInt(new String(ch));
		}
		catch (Exception e){
			return -1;
		}
		if (ans==n)
			return -1;
		return ans;
	}

}
public class Leetcode556 {
	public static void main(String []args){
		Solution556 sol = new Solution556();
		int n =1999999999;
		//2147483476;
		System.out.println(sol.nextGreaterElement1(n));
	}
}
