package JZoffer;

import java.util.*;
class SolutionJZoffer45 {
	public String minNumber(int[] nums) {
		String []str = new String[nums.length];
		for(int i=0;i< nums.length;i++){
			str[i] = String.valueOf(nums[i]);
		}
		// 用 valueof 比用 nums[i]+"" 快
		quicksort(str,0, nums.length-1);
		StringBuilder stb = new StringBuilder();
		for(String st:str)
			stb.append(st);
		return stb.toString();
		// 用 stringbuilder 比 用 join 快
//		return String.join("",str);
	}

	public void quicksort(String[]nums,int start,int end){
		System.out.println(Arrays.toString(nums));
		if (start>=end)
			return;
		String pivot=nums[start];
		int low=start,high=end;
		while(low<high){
			while(low<high&&greater(nums[high],pivot))
				high--;
			nums[low]=nums[high];
			while (low<high&&greater(pivot,nums[low]))
				low++;
			nums[high]=nums[low];
		}
		nums[low]=pivot;
		quicksort(nums, start, low-1);
		quicksort(nums, low+1, end);
	}
	public boolean greater(String p,String q){
		int len = Math.min(p.length(),q.length());
		int sign = p.substring(0,len).compareTo(q.substring(0,len));
		if (sign!=0)
			return sign>0;
		return (p+q).compareTo((q+p))>=0;
	}

}
public class JZoffer45 {
	public static void main(String[]args){
//		System.out.println("33".compareTo("3"));
		SolutionJZoffer45 sol = new SolutionJZoffer45();
		String[]str = {"123","124","122","22","1"};
		int []nums = new int[]{12,121};
		//{123,124,122,22,1};
//		System.out.println(sol.greater("124","12"));
		System.out.println(sol.minNumber(nums));
		//sol.quicksort(str,0,4);
//		System.out.println(Arrays.toString(str));
	}
}
