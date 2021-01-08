package Leetcode;

import java.util.*;
class Solution135 {
	public int candy4(int[] ratings) {
		int len = ratings.length;
		int ans=1;
		int increse_len=1;
		int decrease_len=0;
		int last =1;
		for (int i=1;i<len;i++){
			if (ratings[i] >= ratings[i-1]){
				decrease_len=0;
				if (ratings[i]==ratings[i-1])
					last=1;
				else
					last++;
				increse_len = last;
				ans += increse_len;
			}
			else {
				decrease_len++;
				if (decrease_len==increse_len)
					// 弥补前面递增数列时少加的那一份
					// 或者说，前面递增时累加的值是错的，现在值多加1，刚好和前面换了
					decrease_len++;
				ans += decrease_len;
				last=1;
			}
		}
		return ans;
	}

	public int candy3(int[] ratings) {
		int len = ratings.length;
		int []candy = new int[len];
		candy[0] = 1;
		for (int i=1;i<len;i++){
			if (ratings[i]>ratings[i-1]){
				candy[i]=candy[i-1]+1;
			}
			else
				candy[i]=1;
		}
		int temp=1;
		int ans=0;
		for (int i=len-1;i>=0;i--){
			if (i<len-1 && ratings[i]>ratings[i+1]){
				temp++;
			}
			else {
				temp =1;
			}
			ans+=Math.max(temp,candy[i]);
		}
		return ans;
	}

	public int candy2(int[] ratings) {
		if (ratings.length==1)
			return 1;
		int len = ratings.length;
		int []candy = new int[len];
		Set<Integer> bigindex = new HashSet<>();
		Set<Integer> smallindex = new HashSet<>();
		int []flags = new int[len];
		for (int i=1;i<len-1;i++){
			// 大于左 大于右
			if ( ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1]) {
				flags[i] = 1;
				bigindex.add(i);
			}
			// 大于左 小于右
			else if (ratings[i]>ratings[i-1] && ratings[i]<=ratings[i+1])
				flags[i]=2;
			// 小于左 大于右
			else if (ratings[i]<=ratings[i-1] && ratings[i]>ratings[i+1])
				flags[i]=3;
			// 小于左 小于右
			else {
				flags[i]=4;
				candy[i] = 1;
				smallindex.add(i);
			}
		}
		if (ratings[0]<=ratings[1]){
			flags[0]=4;
			candy[0] = 1;
			smallindex.add(0);
		}
		if (ratings[len-1]<=ratings[len-2]){
			flags[len-1]=4;
			candy[len-1] = 1;
			smallindex.add(len-1);
		}

		for (int i:smallindex){
			int left = i-1;
			int right = i+1;
			int temp = 1;
			while (left>0 && flags[left]==3){
				temp++;
				candy[left]=temp;
				left--;
			}
			temp = 1;
			while (right<len-1 && flags[right]==2){
				temp++;
				candy[right]=temp;
				right++;
			}
		}
		for (int i:bigindex)
			candy[i] = Math.max(candy[i-1],candy[i+1])+1;
		if (ratings[0]>ratings[1]){
			candy[0] = candy[1]+1;
		}
		if (ratings[len-1] > ratings[len-2]){
			candy[len-1] = candy[len-2]+1;
		}
		int res = 0;
		for (int candi:candy)
			res +=candi;
		return res;
	}

	public int candy(int[] ratings) {
		if (ratings.length==1)
			return 1;
		int []candy = new int[ratings.length];
		for (int i =1;i< ratings.length-1;i++){
			if (ratings[i]<=ratings[i+1] && ratings[i]<=ratings[i-1]) {
				candy[i] = 1;
			}
		}
		if (ratings[0]<=ratings[1])
			candy[0]=1;
		if (ratings[ratings.length-1]<=ratings[ratings.length-2])
			candy[ratings.length-1]=1;
		int moved=1;
		int tempvalue = 1;
		while (moved!=0) {
			moved = 0;
			for (int i = 1; i < ratings.length - 1; i++) {
				if (candy[i]!=0)
					continue;
				if (ratings[i] <= ratings[i + 1] && ratings[i] > ratings[i - 1] && candy[i-1] == tempvalue){
					candy[i] = tempvalue+1;
					moved++;
				}
				else if (ratings[i] > ratings[i + 1] && ratings[i] <= ratings[i - 1] && candy[i+1] == tempvalue){
					candy[i] = tempvalue+1;
					moved++;
				}
			}
			tempvalue++;
			System.out.println(Arrays.toString(candy));
		}
		for (int i = 1; i < ratings.length - 1; i++) {
			if (candy[i]==0)
				candy[i]=Math.max(candy[i-1],candy[i+1])+1;
		}
		if (ratings[0]>ratings[1])
			candy[0]=candy[1]+1;
		if (ratings[ratings.length-1] > ratings[ratings.length-2])
			candy[ratings.length-1]=candy[ratings.length-2]+1;
		int res = 0;
		for (int candi:candy)
			res +=candi;
		System.out.println(Arrays.toString(ratings));
		System.out.println(Arrays.toString(candy));
		return res;
	}
}
public class Leetcode135 {
	public static void main(String []args){
		int []rating = {29,51,87,87,72,12};
		// 1,3,4,5,2
		// 29,51,87,87,72,12
		// 1,3,2,2,1
		Solution135 sol = new Solution135();
		System.out.println(sol.candy4(rating));
	}
}
