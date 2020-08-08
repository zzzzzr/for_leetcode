package JZoffer;

import java.util.Stack;

/**
 * 贪心算法
 * 思路：
 * 将pushed中的元素不断加入真正的栈中
 * 每当当前栈顶元素与popped中元素相等时
 * 弹出栈顶元素，并将指向popped数组的下标向后移
 * 直到所有元素都加入过栈中
 * 最后检查栈是否为空，为空则说明有popped描述的pop顺序
 */

// LeetCode 946
class SolutionJZoffer31 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> sta=new Stack<>();
		int index=0;
		for (int j : pushed) {
			sta.push(j);
			while (sta.peek() == popped[index]) {
				sta.pop();
				index++;
			}
		}
		return sta.isEmpty();
	}
}
public class JZoffer31 {
}
