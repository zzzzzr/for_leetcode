import java.util.*;

// 没做出来，用到了求欧拉回路的方法
// 还是逆序dfs，暂时先不放代码

class Solution332 {
	//List<List<String>> ans =new LinkedList<>();
	List<String> ans1= new LinkedList<>();
	boolean []used;
	int len;

	public List<String> findItinerary(List<List<String>> tickets) {
		len = tickets.size();
		used = new boolean[len];

		List<String> temp = new LinkedList<>();
		temp.add("JFK");

		dfs(tickets,temp,used,0);

//		for (List<String>lis:ans){
//			System.out.println(lis);
//		}
//		System.out.println();

//		temp = ans.get(0);
//		for(int i=1;i<ans.size();i++){
//			if (ans.get(i).toString().compareTo(temp.toString())<0)
//				temp=ans.get(i);
//		}
		// YG5H2-ANZ0H-M8ERY-TXZZZ-YKRV8 UG5J2-0ME12-M89WY-NPWXX-WQH88 UA5DR-2ZD4H-089FY-6YQ5T-YPRX6
		return ans1;
	}

	public void dfs(List<List<String>>tickets,List<String>temp,boolean[]used,int templen){
//		System.out.print(templen);
//		System.out.println(temp.get(temp.size()-1));

		if (templen>=len){
			if (ans1==null)
				ans1=new LinkedList<>(temp);
			else if (ans1.toString().compareTo(temp.toString())>0)
				ans1=new LinkedList<>(temp);

//			ans.add(new LinkedList<>(temp));
			return;
		}
		for(int i=0;i<len;i++){
			if(!used[i]&&tickets.get(i).get(0).equals(temp.get(templen))){
				temp.add(tickets.get(i).get(1));
				used[i]=true;
				dfs(tickets,temp,used,templen+1);
				used[i]=false;
				temp.remove(temp.size()-1);
			}
		}
	}
}
public class Leetcode332 {
	public static void main(String []args){
		Solution332 sol = new Solution332();

		List<String> lis1 = new LinkedList<>();
		List<String> lis2 = new LinkedList<>();
		List<String> lis3 = new LinkedList<>();
		List<String> lis4 = new LinkedList<>();
		List<String> lis5 = new LinkedList<>();

		List<List<String>> lis = new LinkedList<>();
// [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
		// ["JFK","ATL","JFK","SFO","ATL","SFO"]

		//[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
		// ["JFK", "MUC", "LHR", "SFO", "SJC"]

//		lis1.add("JFK");
//		lis1.add("SFO");
//
//		lis2.add("JFK");
//		lis2.add("ATL");
//
//		lis3.add("SFO");
//		lis3.add("ATL");
//
//		lis4.add("ATL");
//		lis4.add("JFK");
//
//		lis5.add("ATL");
//		lis5.add("SFO");

		lis1.add("MUC");
		lis1.add("LHR");
		lis2.add("JFK");
		lis2.add("MUC");
		lis3.add("SFO");
		lis3.add("SJC");
		lis4.add("LHR");
		lis4.add("SFO");


		lis.add(lis1);
		lis.add(lis2);
		lis.add(lis3);
		lis.add(lis4);
//		lis.add(lis5);

		System.out.println(sol.findItinerary(lis));
	}
}
