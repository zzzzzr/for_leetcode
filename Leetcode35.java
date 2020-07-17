//Leetcode 35
class Solution35 {
	public int searchInsert(int[] nums, int target) {
		if(nums.length<=0||nums==null){
			return 0;
		}
		if(target<nums[0]){
			return 0;
		}
		if(target>nums[nums.length-1]){
			return nums.length;
		}
		int end=nums.length;
		int start=0;
		int mid=0;
		while(start<end){
			if(end-start==1){
				if(nums[start]==target){
					return start;
				}
				return end;
			}
			mid=(start+end)/2;
			if(nums[mid]==target){
				return mid;
			}
			else if(nums[mid]>target){
				end=mid;
			}
			else{
				start=mid;
			}
		}
		//int loc=binarysearch(nums,target,0,n);
		return 0;
	}
	// public int binarysearch(int []nums,int target,int start,int end){
	// 	if(end-start==1){
	// 		if(nums[start]==target){
	// 			return start;
	// 		}
	// 		return end-1;
	// 	}
	// 	int startint=nums[start];
	// 	endint=nums[end-1];
	// 	midint=nums[(start+end)/2];
	// 	if(midint==target)
	// 	return 0;
	// }
}
public class Leetcode35{
	public static void main(String []args){
		int []test=new int[]{1,3,5,6};
		int target=0;
		Solution35 tes=new Solution35();
		System.out.println(tes.searchInsert(test,target));
	}
}