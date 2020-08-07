package JZoffer;
class SolutionJZoffer21 {
	public int[] exchange(int[] nums) {
		int i=0,j= nums.length-1,temp;
		while (i<j){
			// 找到靠左的偶数
			while(i<j&&nums[i]%2==1){
				i++;
			}
			// 找到靠右的奇数
			while(i<j&&nums[j]%2==0){
				j--;
			}
			if(i>=j)
				break;
			//交换
			temp=nums[j];
			nums[j]=nums[i];
			nums[i]=temp;
			i++;
			j--;
		}
		return nums;
	}
}
public class JZoffer21 {
}
