package Leetcode;

class Solution134 {
	// https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/
	// 用到了数字分析
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int len = gas.length;
		int index=0;
		while(index<len){
			int subsum=0;
			int offset = 0;
			while (offset <len){
				int loc = (index+offset)%len;
				subsum=subsum+gas[loc]-cost[loc];
				if (subsum<0)
					break;
				offset++;
			}
			if (offset==len)
				return index;
			else {
				index = index+offset+1;
			}
		}
		return -1;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
//		for (int i=0;i<len;i++)
//			gas[i] = gas[i]-cost[i];
		for (int i=0;i<len;i++)
			if (gas[i]>=0) {
				if (check(gas,cost, i, len))
					return i;
			}
		return -1;
	}
	public boolean check(int[]gas,int[]cost,int i,int len){
		int subsum = 0;
		for (int j=0;j<len;j++){
			int loc = (j+i)%len;
			subsum+=gas[loc]-cost[loc];
			if (subsum<0)
				return false;
		}
		return true;
	}
}
public class Leetcode134 {
	public static void main(String []args){
		int []gas = {1,2,3,4,5};
		int []cost = {3,4,5,1,2};
		Solution134 sol = new Solution134();
		System.out.println(sol.canCompleteCircuit1(gas,cost));
		/*
		gas  = [1,2,3,4,5]
		cost = [3,4,5,1,2]
		gas  = [2,3,4]
		cost = [3,4,3]
		 */
	}
}
