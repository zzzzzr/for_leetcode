package Leetcode;

import java.util.*;
class Solution456 {
	public boolean find132pattern1(int[] nums) {
		int k = Integer.MIN_VALUE;
		Stack<Integer> sta = new Stack<>();
		for (int i=nums.length-1;i>=0;i--){
			if (sta.isEmpty()){
				sta.push(nums[i]);
			}
			else if (nums[i]<sta.peek()){
				if (nums[i]<k){
					return true;
				}
				else {
					sta.push(nums[i]);
				}
			}
			else if (nums[i]>sta.peek()){
				while (!sta.isEmpty() && nums[i]>sta.peek()){
					k = Math.max(sta.pop(),k);
				}
				sta.push(nums[i]);
			}
		}
		return false;
	}

	class Pair{
		int left;
		int right;
		public Pair(int down, int up){
			left = down;
			right = up;
		}
		public boolean contains(int down, int up){
			return left<=down && right>=up;
		}
		public boolean contains(Pair temp){
			return left<=temp.left && right>=temp.right;
		}
		public boolean contains(int mid){
			return left<mid && right>mid;
		}
		public String toString(){
			return "left: "+left+" right: "+right;
		}
	}
	public boolean find132pattern(int[] nums) {
		// int len = nums.length;
		List<Pair> lis = new ArrayList<>();
		int []sta = new int[2];
		//sta[0]=nums[0];
		int size=0;
//		int down,up=-1;
//		down = nums[0];
		// boolean flag=true;
		for (int num : nums) {
//			System.out.println(lis);
//			System.out.println(Arrays.toString(sta));
			for (Pair li : lis) {
				if (li.contains(num))
					return true;
			}
			if (size == 0) {
				sta[0] = num;
				size++;
			}
			else if (size == 1) {
				if (num < sta[0]) {
					sta[0] = num;
				} else if (num > sta[0]) {
					sta[1] = num;
					size++;
				}
			} else {
				if (num > sta[0] && num < sta[1]) {
					return true;
				} else if (num > sta[1]) {
					sta[1] = num;
				} else if (num <= sta[0]) {
					Pair now = new Pair(sta[0], sta[1]);
					lis.add(now);
					sta[0]=num;
					size = 1;
				}
			}
		}
		return false;
	}
}
public class Leetcode456 {
	public static void main(String []args){
		Solution456 sol = new Solution456();
		int []nums = new int[]{8,10,4,6,5};
		// {3,5,0,3,4};
		System.out.println(sol.find132pattern1(nums));
	}
}
