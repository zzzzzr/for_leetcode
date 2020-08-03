package JZoffer;
class SolutionJZoffer11 {
	public int minArray(int[] numbers) {
		if(numbers.length<=0)
			return -1;
		int len=numbers.length;
		for(int i=0;i<len-1;i++){
			if(numbers[i]>numbers[i+1])
				return numbers[i+1];

		}
		return numbers[0];
	}
	public int minArray_1(int[] numbers) {
		// 用二分法加快查找
		if(numbers.length<=0)
			return -1;
		int left=0,right=numbers.length-1;
		while (left<right){
			// 用这种方法能够避免某些整型溢出的情况
			int mid=left+(right-left)/2;
			// 由于数组是半非严格单调递增的，所以比右侧数字小的数字只可能在被移过来的序列中，则将右侧边界左移到 mid
			if(numbers[mid]<numbers[right]){
				right=mid;
			}
			else if(numbers[mid]>numbers[right]){
				left=mid+1;
			}
			else {
				right--;
			}
		}
		return numbers[left];
	}
}
public class JZoffer11 {
}
