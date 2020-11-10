
import java.util.*;
class Solution973 {
	public int[][] kClosest1(int[][] points, int K) {
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] point1, int[] point2) {
				return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
			}
		});
		return Arrays.copyOfRange(points, 0, K);
	}


	public int[][] kClosest(int[][] points, int K) {
		int []dis = new int[points.length];
		for (int i=0;i< points.length;i++)
			dis[i] = points[i][0]*points[i][0]+points[i][1]*points[i][1];
		// 快速选择
		quicksort(dis,K,points,0,points.length-1);
		int [][]ans = new int[K][2];
		System.arraycopy(points,0,ans,0,K);
		return ans;
	}
	public void quicksort(int[]dis,int k,int[][]points,int start,int end){
		if (start>end)
			return;
		int low=start;
		int high = end;
		int pivot = dis[low];
		int []point = points[low];
		while(low<high){
			while(low<high&&dis[high]>=pivot)
				high--;
			dis[low]=dis[high];
			points[low]=points[high];
			while(low<high&&dis[low]<pivot)
				low++;
			dis[high]=dis[low];
			points[high]=points[low];
		}
		dis[low]=pivot;
		points[low]=point;

		if (low==k-1)
			return;
		else if (low>k-1)
			quicksort(dis, k, points, start, end-1);
		else
			quicksort(dis, k, points, low+1, end);
	}
}
public class Leetcode973 {
	public static void main(String[]args){
		Solution973 sol = new Solution973();
		int [][]points = {{3,3},{5,-1},{-2,4}};
		int k =2;
		int [][]ans = sol.kClosest(points,k);
		for (int []arr:ans)
			System.out.println(Arrays.toString(arr));
	}
}
