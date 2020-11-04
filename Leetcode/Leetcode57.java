package Leetcode;

import java.util.*;
class Solution57 {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		// interval n*2
		// newinterval 1*2
		if (intervals.length<=0)
			return new int[][]{{newInterval[0],newInterval[1]}};

		if (intervals[intervals.length-1][1]<newInterval[0]){
			int [][]ans = new int[intervals.length+1][2];
			System.arraycopy(intervals,0,ans,0,intervals.length);
			ans[intervals.length] = newInterval;
			return ans;
		}

		if (intervals[0][0]>newInterval[1]){
			int [][]ans = new int[intervals.length+1][2];
			System.arraycopy(intervals,0,ans,1,intervals.length);
			ans[0] = newInterval;
			return ans;
		}

		List<int[]> lis =new LinkedList<>();
		int index=0;
		for (;index<intervals.length;index++){
			if (intervals[index][1]<newInterval[0])
				lis.add(intervals[index]);
			else
				break;
		}

		int start = Math.min(intervals[index][0],newInterval[0]);
		for (;index<intervals.length;index++){
			if (intervals[index][0]>newInterval[1])
				break;
		}
		int end = Math.max(intervals[index-1][1],newInterval[1]);
		lis.add(new int[]{start,end});

		for (;index<intervals.length;index++){
			lis.add(intervals[index]);
		}

		int [][]ans = new int[lis.size()][2];
		for (int i=0;i<lis.size();i++)
			ans[i]=lis.get(i);
		return ans;
	}
}
public class Leetcode57 {
}
