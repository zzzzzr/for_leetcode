import java.util.*;
class Solution4 {
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int len = nums1.length+nums2.length;

		int []merge = new int[len/2+1];
		int index1=0;
		int index2=0;
		int index=0;
		while (index1< nums1.length && index2< nums2.length &&index<=len/2){
			if (nums1[index1] <= nums2[index2]){
				merge[index]=nums1[index1];
				index1++;
				index++;
			}
			else {
				merge[index]=nums2[index2];
				index2++;
				index++;
			}
		}
		while (index<=len/2){
			if (index1== nums1.length){
				merge[index]=nums2[index2];
				index2++;
				index++;
			}
			else if (index2== nums2.length){
				merge[index]=nums1[index1];
				index1++;
				index++;
			}
		}
		//System.out.println(Arrays.toString(merge));
		if (len%2==1)
			return merge[len/2];
		else {
			return (merge[len/2]+merge[len/2-1])/2.0;
		}
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length+nums2.length;

		int []merge = new int[len];
		int index1=0;
		int index2=0;
		int index=0;
		while (index1< nums1.length && index2< nums2.length){
			if (nums1[index1] <= nums2[index2]){
				merge[index]=nums1[index1];
				index1++;
				index++;
			}
			else {
				merge[index]=nums2[index2];
				index2++;
				index++;
			}
		}
		if (index1== nums1.length){
			while (index<len){
				merge[index]=nums2[index2];
				index2++;
				index++;
			}
		}
		else if (index2== nums2.length){
			while (index<len){
				merge[index]=nums1[index1];
				index1++;
				index++;
			}
		}
		//System.out.println(Arrays.toString(merge));
		if (len%2==1)
			return merge[len/2];
		else {
			return (merge[len/2]+merge[len/2-1])/2.0;
		}
	}
}
public class Leetcode4 {
	public static void main(String []args){
		int []num1={1,2};
		int []num2 = {3,4};
		Solution4 sol = new Solution4();
		System.out.println(sol.findMedianSortedArrays1(num1,num2));
	}
}
