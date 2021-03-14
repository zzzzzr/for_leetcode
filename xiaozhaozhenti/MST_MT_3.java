package xiaozhaozhenti;

import java.util.*;
class Solution_mt3{
	public void zhongshu(){
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int offset = sc.nextInt();
		int []arr = new int[len];
		for (int i=0;i<len;i++){
			arr[i] = sc.nextInt();
		}
		Map<Integer,Integer> mapp = new HashMap<>();
		mapp.put(arr[0],1);
		int biggest = arr[0];
		for (int i=1;i<offset;i++){
			int tempval = mapp.getOrDefault(arr[i],0)+1;
			if (tempval>mapp.get(biggest) ||(tempval==mapp.get(biggest) &&arr[i]<biggest )){
				biggest=arr[i];
			}
			mapp.put(arr[i], tempval);
		}
		System.out.println(biggest);
		for (int i=offset;i<len;i++){
			mapp.put(arr[i],mapp.getOrDefault(arr[i],0)+1);
			mapp.put(arr[i-offset],mapp.get(arr[i-offset])-1);
			// System.out.println(mapp);
			if (arr[i-offset]==biggest){
				int temp = i;
				for (int j=i-offset+1;j<i;j++){
					if (mapp.get(arr[j])>mapp.get(arr[temp]) || (mapp.get(arr[j])==mapp.get(arr[temp])&& arr[j]<arr[temp])){
						temp = j;
					}
				}
				biggest = arr[temp];
			}
			System.out.println(biggest);
		}
	}
}
public class MST_MT_3 {
	public static void main(String []args){
		Solution_mt3 sol = new Solution_mt3();
		sol.zhongshu();
	}
}
