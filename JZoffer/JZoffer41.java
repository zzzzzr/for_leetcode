package JZoffer;

import java.util.*;


// Leetcode 295

// 用一个小顶堆一个大顶堆相互倒换数字，则两个堆顶的数字总是中间的数字
class MedianFinder {
	PriorityQueue<Integer> pq1;
	PriorityQueue<Integer> pq2;

	public MedianFinder() {
		pq1 = new PriorityQueue<>();
		pq2 = new PriorityQueue<>((x,y)->(y-x));
	}
	public void addNum(int num) {
		if (pq1.size()==pq2.size()){
			pq2.offer(num);
			pq1.offer(pq2.poll());
		}
		else{
			pq1.offer(num);
			pq2.offer(pq1.poll());
		}
//		System.out.println(pq1.toString());
//		System.out.println(pq2.toString());
	}
	public double findMedian() {
		if (pq1.size()==pq2.size()){
			return (double)(pq1.peek()+pq2.peek())/2;
		}
		else{
			return pq1.peek();
		}
	}
}

class MedianFinder1 {

	List<Integer> lis;
	//PriorityQueue<Integer> pq;
	/** initialize your data structure here. */
	public MedianFinder1() {
		lis = new LinkedList<>();
		//pq = new PriorityQueue<>();
	}

	public void addNum(int num) {
		int i=0;
		while (i<lis.size()&&lis.get(i)<=num)
			i++;
		lis.add(i,num);
//		lis.add(num);
		//pq.add(num);
	}

	public double findMedian() {
		//lis.sort(Comparator.comparingInt(Integer::intValue));
		//lis.sort((x,y)->(y-x));

		if (lis.size()%2==0)
			return (double)(lis.get(lis.size()/2)+ lis.get(lis.size()/2-1))/2;
		else
			return lis.get(lis.size()/2);
	}
}
public class JZoffer41 {
	public static void main(String []args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(5);
		//double param_2 = obj.findMedian();
		System.out.println(obj.findMedian());
		obj.addNum(4);
		//double param_2 = obj.findMedian();
		System.out.println(obj.findMedian());
		obj.addNum(1);
		//double param_2 = obj.findMedian();
		System.out.println(obj.findMedian());
		obj.addNum(3);
		//double param_2 = obj.findMedian();
		System.out.println(obj.findMedian());
		obj.addNum(2);
		//double param_2 = obj.findMedian();
		System.out.println(obj.findMedian());
	}
}
