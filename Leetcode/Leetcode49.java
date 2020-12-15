package Leetcode;

import java.util.*;
class Solution49 {
	public List<List<String>> groupAnagrams3(String[] strs) {
		Map<String, List<String>> mapp=new HashMap<>();
		for (String str:strs){
			char []chars = str.toCharArray();
			Arrays.sort(chars);
			String newstrs= String.valueOf(chars);
			if(!mapp.containsKey(newstrs)){
				List<String> liss = new LinkedList<>();
				liss.add(str);
				mapp.put(newstrs,liss);
			}
			else{
				mapp.get(newstrs).add(str);
			}
		}
		return new LinkedList<>(mapp.values());
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> mapp=new HashMap<>();
		for (String str:strs){
			char []chars = str.toCharArray();
			Arrays.sort(chars);
			String newstrs= new String(chars);
			List<String> lis = mapp.getOrDefault(newstrs,new LinkedList<String>());
			lis.add(str);
			mapp.put(newstrs,lis);
		}
		return new LinkedList<>(mapp.values());
	}

	public List<List<String>> groupAnagrams1(String[] strs) {
		char [][]chars = new char[strs.length][];
		String []newstrs = new String[strs.length];
		for (int i=0;i< strs.length;i++) {
			chars[i] = strs[i].toCharArray();
			Arrays.sort(chars[i]);
			newstrs[i]= Arrays.toString(chars[i]);
		}
		boolean []used = new boolean[strs.length];
		List<List<String>> ans = new LinkedList<>();
		for (int i=0;i< used.length;i++){
			if (!used[i]){
				List<String> lisstr = new LinkedList<>();
				lisstr.add(strs[i]);
				used[i]=true;
				for (int j=i+1;j< used.length;j++){
					if (!used[j] && strs[i].length()==strs[j].length() && newstrs[i].equals(newstrs[j])){
						lisstr.add(strs[j]);
						used[j]=true;
					}
				}
				ans.add(lisstr);
			}
		}
		return ans;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		boolean []used = new boolean[strs.length];
		List<List<String>> ans = new LinkedList<>();

		for (int i=0;i< used.length;i++){
			if (!used[i]){
				List<String> lisstr = new LinkedList<>();
				lisstr.add(strs[i]);
				used[i]=true;
				for (int j=i+1;j< used.length;j++){
					if (!used[j] && strs[i].length()==strs[j].length() && compare(strs[i],strs[j])){
						lisstr.add(strs[j]);
						used[j]=true;
					}
				}
				ans.add(lisstr);
			}
		}
		return ans;
	}
	public boolean compare(String str1, String str2){
		char []arr1 = str1.toCharArray();
		char []arr2 = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i=0;i< arr1.length;i++)
			if (arr1[i]!=arr2[i])
				return false;
		return true;
	}
}
public class Leetcode49 {
	public static void main(String []args){
		String []strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Solution49 sol = new Solution49();
		for (List<String> lis:sol.groupAnagrams2(strs))
			System.out.println(lis);
	}
}
