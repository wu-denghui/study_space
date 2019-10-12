package com.goodhealth.algorithm.NKExercise;

import java.util.Stack;

public class StockHeapExercise {
	/**
	 * 两个数组pPush和pPop分别存储了压栈序列和出栈序列，如何判断出栈序列是否正确，假设元素不重复。
	 * 
	 * @param stackIn
	 * @param stackOut
	 * @return
	 */
	public boolean isStackOutRight(int[] stackIn, int[] stackOut) {
		Stack<Integer>stackData=new Stack<>();
		for (int i = 0,j=0; i <stackIn.length; i++) {// 遍历整个出栈序列
			stackData.push(stackIn[i]);
			while(!stackData.empty() && stackOut[j]== stackData.peek()){
				// 辅助栈不空，而且遍历出栈数组的元素是辅助栈的top元素，需要弹出操作
				  stackData.pop();
                  j++;
				}
		}
		return stackData.size()==0;
	}

	public static void main(String[] args) {
		int[] stackIn = { 1,2,3,4,5 };
		int[] stackOut = { 4,5,3,2,1};
		StockHeapExercise stockHeapExercise = new StockHeapExercise();
		System.out.println(stockHeapExercise.isStackOutRight(stackIn, stackOut));
	}

}
