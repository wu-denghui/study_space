/**
 * 
 */
package com.goodhealth.algorithm.DataStruct;

import java.util.*;

/**
 * @author 24663
 * @date 2018年8月26日
 * @Description
 */
public class StackDemo {

	public static void main(String[] args) {
		StackDemo stackDemo = new StackDemo();
		Deque<Integer> stack2=(Deque<Integer>) new ArrayList<Integer>();
		Deque<Integer> stack3=new ArrayDeque<Integer>();
		System.out.println("-------------------------------------");
		// 创建一个栈
		Stack<Integer> stack = new Stack<Integer>();
		// push(X) 将X入栈
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stackDemo.printStack(stack);
		// pop() 将栈顶元素出栈
		stack.pop();
		// peek() 得到栈顶元素 但是不出栈
		System.out.println(stack.peek());
		System.out.println("-------------------------------------");

	}
    //从栈底到栈顶遍历打印栈
	public void printStack(Stack<Integer> stack) {
		Iterator<Integer> iterator = stack.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
