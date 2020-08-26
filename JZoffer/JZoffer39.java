package JZoffer;
import java.util.*;

// 同时也是 LeetCode169
class SolutionJZoffer39 {
	public int majorityElement1(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int item:nums){
			if(!map.containsKey(item)){
				map.put(item,1);
			}
			else{
				map.put(item,map.get(item)+1);
			}
		}
		for(int item: map.keySet()){
			if (map.get(item)>=(nums.length+1)/2)
				return item;
		}

		return -1;
	}


	// 摩尔投票法
	public int majorityElement(int[] nums) {
		int vote = 0;
		int target =0;
		for(int item :nums){
			if (vote==0)
				target = item;
			vote+=(item==target? 1:-1);
		}
		return target;
	}

	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

}
public class JZoffer39 {
	public static void main(String []args){
		int []nums = new int[]{6,6,6,7,7};
		//{1};
		//{1, 2, 3, 2, 2, 2, 5, 4, 2};
		SolutionJZoffer39 sol = new SolutionJZoffer39();
		System.out.println(sol.majorityElement(nums));
	}
}
