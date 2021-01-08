package Leetcode;

import java.util.*;
class Solution860 {
	public boolean lemonadeChange(int[] bills) {
		int []count=new int[3];
		for (int bill : bills) {
			switch (bill) {
				case 5: {
					count[0]++;
					break;
				}
				case 10: {
					count[1]++;
					if (count[0] > 0) {
						count[0]--;
					} else {
						return false;
					}
					break;
				}
				case 20: {
					count[2]++;
					if (count[1] > 0 && count[0] > 0) {
						count[1]--;
						count[0]--;
					} else if (count[0] > 3) {
						count[0] -= 3;
					} else {
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
}
public class Leetcode860 {
}
