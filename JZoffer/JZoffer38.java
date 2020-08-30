package JZoffer;

import java.util.*;
class SolutionJZoffer38 {
	List<String> ans = new LinkedList<>();
	public String[] permutation(String s) {
		if (s==null||s.length()<=0)
			return null;
		char[]ch = s.toCharArray();
		Arrays.sort(ch);
		boolean []vis = new boolean[s.length()];
		StringBuilder temp = new StringBuilder();
		dfs(ch,vis,temp);
		String[]ret = new String[ans.size()];
		ans.toArray(ret);
		return ret;
	}
	public void dfs(char[]ch,boolean[]vis,StringBuilder temp){
		if (temp.length()== ch.length)
			ans.add(temp.toString());
		char last = '$';
		for (int i=0;i<ch.length;i++){
			if ((!vis[i]&&last=='$')||(!vis[i]&&ch[i]!=last)){
				temp.append(ch[i]);
				vis[i]=true;
				dfs(ch,vis,temp);
				vis[i]=false;
				temp.deleteCharAt(temp.length()-1);
				last = ch[i];
			}
		}
	}
}
public class JZoffer38 {
	public static void main(String []args){
		SolutionJZoffer38 sol = new SolutionJZoffer38();
		String s = "aaa";
		System.out.println(Arrays.toString(sol.permutation(s)));
	}
}
