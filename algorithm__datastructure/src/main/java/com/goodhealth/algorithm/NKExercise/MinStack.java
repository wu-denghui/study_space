
/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author 24663
 * @date 2018年8月26日
 * @Description 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 */
public class MinStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		Deque<Integer> satck = new ArrayDeque<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		int[] an = { 8, 3, 2, 7, 9, 4, 1 };
		int mini = Integer.MAX_VALUE;
		for (int i = 0; i < an.length; i++) {
			if (mini > an[i]) {
				mini = an[i];
			}
			satck.push(an[i]);
			min.push(mini);
		}
		minStack.printStack(satck);
		System.out.println(" ");
		System.out.println(" -----------------------");
		minStack.printS(min);
	}

	// 从栈底到栈顶遍历打印栈
	public void printS(Stack<Integer> stack) {
		for (int j=stack.size()-1; j >=0;j--) {
			System.out.println(stack.elementAt(j));
		}

	}

	// 从栈底到栈顶遍历打印栈
	public void printStack(Deque<Integer> stack) {
		System.out.println();
		Iterator<Integer> iterator = stack.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
