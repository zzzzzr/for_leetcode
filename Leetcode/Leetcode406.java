package Leetcode;

import java.util.*;
// https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode-sol/

class Solution406_1 {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]!=o2[0])
					return o1[0]-o2[0];
				else
					return o2[1]-o1[1];
			}
		});
		int len = people.length;
		int [][] ans = new int[len][];
		for (int []arr:people){
			int pre = arr[1]+1;
			for (int i=0;i<len;i++){
				if (ans[i] == null)
					pre--;
				if (pre==0){
					ans[i] = arr;
					break;
				}
			}
		}
		return ans;
	}
}

class Solution406 {
	public int[][] reconstructQueue(int[][] people) {
		int [][] arr = mergesortbinary(people, 0, people.length);
//		for (int []ar:arr){
//			System.out.println(Arrays.toString(ar));
//		}
		for (int i=arr.length-1; i>=0; i--){
			// 判断当前数字放在这里是否合适，他前面的大于等于他的元素是否符合
			int pre = checkpre(arr, i);
//			System.out.println(pre);
			// 符合
			if (pre == arr[i][1])
				continue;
			// 否则，向后找到第一个满足的下标
			int id = findnxt(arr,i,arr[i][1]-pre);
			// 做替换
			int []temp = arr[i];
			int j=i;
			while (j<id){
				arr[j] = arr[j+1];
				j++;
			}
			arr[id] = temp;
		}
		return arr;
	}

	public int findnxt(int [][]arr, int i, int target){
		int j, count;
		for (j=i+1, count=0; count<target && j<arr.length; j++){
			if (arr[j][0]>=arr[i][0])
				count++;
		}
		return j-1;
	}

	// 返回 arr0 到 arr i-1 中大于等于 arr i 的元素数目
	public int checkpre(int [][]arr, int i){
		int count=0;
		for (int j=0;j<i;j++){
			if (arr[j][0]>=arr[i][0])
				count++;
		}
		return count;
	}

	public int [][] mergesortbinary(int [][]num, int start, int end){
		if (end-start==1){
			return new int[][]{{num[start][0],num[start][1]}};
		}
		int mid = (start+end)/2;
		int [][]target1 = mergesortbinary(num, start, mid);
		int [][]target2 = mergesortbinary(num, mid, end);
		int [][]ret = new int[end-start][2];
		int i=0, j=0, k=0;
		while (i<mid-start && j<end-mid){
			if (target1[i][0] < target2[j][0]){
				ret[k] = target1[i];
				i++;
				k++;
			}
			else if(target1[i][0] > target2[j][0]){
				ret[k] = target2[j];
				j++;
				k++;
			}
			else {
				if (target1[i][1] < target2[j][1]){
					ret[k] = target1[i];
					i++;
					k++;
				}
				else if(target1[i][1] > target2[j][1]){
					ret[k] = target2[j];
					j++;
					k++;
				}
			}
		}
		while (i<mid-start){
			ret[k]=target1[i];
			i++;
			k++;
		}
		while (j<end-mid){
			ret[k]=target2[j];
			j++;
			k++;
		}
		return ret;
	}
}

public class Leetcode406 {
	public static void main(String []args){
		Solution406_1 sol = new Solution406_1();
		int [][] num = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
//		{
//				{7,0},
//				{4,4},
//				{7,1},
//				{5,0},
//				{6,1},
//				{5,2}
//		};
		for (int []arr:sol.reconstructQueue(num)){
			System.out.println(Arrays.toString(arr));
		}
	}
}
