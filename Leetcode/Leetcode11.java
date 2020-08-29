package Leetcode;

class Solution11 {
	public int maxArea_1(int[] height) {
		if(height.length<=0){
			return 0;
		}
		int []area=new int[height.length];
		for(int i=1;i<height.length;i++){
			for(int j=0;j<height.length-i;j++){
				//System.out.println(""+j+i);
				area[j]=Math.max(Math.min(height[j],height[j+i])*i,area[j]);
				area[j]=Math.max(area[j],area[j+1]);
			}
//			for(int j=0;j<height.length-1;j++){
//				System.out.print("\t"+area[j]);
//			}
//			System.out.println();
		}
		return area[0];
	}
	//双指针法
	public int maxArea(int []height){
		if(height.length<=1){
			return 0;
		}
		int l=0;
		int r=height.length-1;
		int max=0;
		int area;
		while (l<r){
			area=Math.min(height[l],height[r])*(r-l);
			max=Math.max(max,area);
			if(height[l]<=height[r]){
				l++;
			}
			else
				r--;
		}
		return max;
	}
}
public class Leetcode11 {
	public static void main(String []args){
		int []numrows=new int[]{7,3,8,4,5,2,6,8,1};
		//{1,8,6,2,5,4,8,3,7}
		//{7,3,8,4,5,2,6,8,1}
		Solution11 sol=new Solution11();
		System.out.println(sol.maxArea(numrows));
	}
}
