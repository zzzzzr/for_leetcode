import com.sun.deploy.util.ArrayUtil;
import java.util.stream.*;
import java.lang.reflect.Array;
import java.util.*;
class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans=new ArrayList<>();
		if(nums.length<=2){
			return ans;
		}
		Arrays.sort(nums);
		// 让整个数组有序
		for(int i=0;i<nums.length-2;i++){
			// 固定第一个数字
			if(i>0&&nums[i]==nums[i-1]){
				continue;
			}
			int j=i+1;
			int k=nums.length-1;
			while(j<k){
				// 寻找剩下两个数字
				if(nums[j]+nums[k]+nums[i]==0){
					List<Integer> temp=new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					ans.add(temp);
					j++;
					k--;
					while(j<k&&nums[j]==nums[j-1]){
						j++;
					}
					while(j<k&&nums[k]==nums[k+1]){
						k--;
					}
				}
				else if(nums[j]+nums[k]<-nums[i]){
					j++;
				}
				else {
					k--;
				}
			}
		}
		return ans;
	}
	// 这种题目考察的就是对性能的压缩
	/*
	* 贸然用DFS必然会导致超时，而且DFS连优化的空间都没有
	* 越是这种题目越要从基础的解法做起
	* 比如三重循环加优化，本身三重循环就不比DFS更差，加上优化后就能提升很多
	* 还是要仔细思考，不能想到一种做法就猛冲
	* */


	List<List<Integer>> lis=new ArrayList<>();
	public List<List<Integer>> threeSum_1(int[] nums) {
		if(nums.length<=2){
			return null;
		}
		Arrays.sort(nums);
		//int len=nums.length;
		//List<List<Integer>> lis=new ArrayList<>();
//		List<Integer> temp=new ArrayList<>();
		int []temp=new int[3];
		int count=0;        //temp中元素个数
		int index=-1;        //遍历到的nums的下标
		int tempsum=0;      //当前temp的和

		dfs(count,nums,index,temp,tempsum);
		//lis.sort();
		//System.out.println(lis.size());
//		for(int i=0;i< lis.size()-1;i++){
//			for(int j=i+1;j<lis.size();j++) {
//				//System.out.println(lis.get(i)+""+lis.get(j));
//				if(lis.get(i).equals(lis.get(j))){
//					lis.remove(j);
//				}
//			}
//		}
		//System.out.println(lis.size());
		//System.out.println((List) lis.stream().distinct().collect(Collectors.toList()));
		// [[-3, 1, 2], [-1, -1, 2], [-1, 0, 1]]
		return  lis.stream().distinct().collect(Collectors.toList());
	}

	public void dfs(int count,int[] nums,int index,int[] temp,int tempsum){
		// count:temp中元素个数
		// index:遍历到的nums的下标
		// tempsum:当前temp的和
		if(count==3){
			if(tempsum==0){
				lis.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
				//System.out.println(Arrays.stream(temp).boxed().collect(Collectors.toList()));
				//System.out.println(lis);
			}
			return ;
		}
		if(tempsum>0){
			return ;
		}
		if(index>=nums.length-1){
			return ;
		}
		index++;

		temp[count]=nums[index];
		tempsum+=nums[index];
		count++;
		dfs(count,nums,index,temp,tempsum);

		count--;
		temp[count]=0;
		tempsum-=nums[index];
		dfs(count,nums,index,temp,tempsum);
	}
}
public class Leetcode15 {
	public static void main(String []args){
		int []test=new int []{1,2,-1,0,-1,-1,-1,-1,2,2,-3};
		//{-1, 0, 1, 2, -1, -4};
		//{1,2,-1,0,-1};
		Solution15 sol=new Solution15();
		System.out.println(sol.threeSum(test));
	}
}
