package JZoffer;
import java.util.*;
class CQueue {
	//  JZoffer09
	public CQueue() {
		nor=new Stack<>();
		trans=new Stack<>();
		len=0;
		sta = true;
	}

	Stack<Integer> nor;
	Stack<Integer> trans;
	int len;
	boolean sta;

	// 方法1
	public void appendTail(int value) {
		nor.push(value);
		len++;
	}

	public int deleteHead() {
		if(len==0)
			return -1;
		int temp;
		for(int i=0;i<len-1;i++){
//			temp=nor.pop();
//			trans.push(temp);
			trans.push(nor.pop());
		}
		temp=nor.pop();
		len--;
		for(int i=0;i<len;i++){
			nor.push(trans.pop());
		}
		return temp;
	}

	// 方法2

}
public class JZoffer09 {
}
