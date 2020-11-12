package JZoffer;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.ListNode;

// https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
class SolutionJZoffer52 {
	public LeetcodeStructure.ListNode getIntersectionNode(LeetcodeStructure.ListNode headA, LeetcodeStructure.ListNode headB) {
		LeetcodeStructure.ListNode start1 = headA;
		ListNode start2 = headB;
		while(start1 != start2){
			if (start1!=null)
				start1=start1.next;
			else
				start1 = headB;

			if (start2!=null)
				start2=start2.next;
			else
				start2 = headA;
		}
		return start1;
	}
}
public class JZoffer52 {
}
