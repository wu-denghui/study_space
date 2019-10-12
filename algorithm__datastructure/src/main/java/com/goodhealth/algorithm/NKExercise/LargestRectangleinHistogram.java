/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

import java.util.Stack;

/**
 * @author 24663
 * @date 2018年8月27日
 * @Description
 * 描述  给出的n个非负整数表示每个直方图的高度，每个直方图的宽均为1，在直方图中找到最大的矩形面积。
 * 样例  给出 height = [2,1,5,6,2,3]，返回 10
 */
public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		LargestRectangleinHistogram lr=new LargestRectangleinHistogram();
		//暴力破解法 时间复杂度O(n^2)
		int[] an={2,1,7,6,2,3};
		int size=0;
		for (int i = 0; i < an.length-1; i++) {
			int minheights=Integer.MAX_VALUE;
			for (int j = i; j < an.length; j++) {
				minheights=Math.min(minheights, an[j]);
				int temp=(j-i+1)*minheights;
				size=Math.max(size, temp);
			}
		}
              System.out.println(size);
	}
	 /**
	 * @param heights
	 * @return
	 * @Description  利用栈  时间复杂度O(n)
	 * 思路: 主要是使用一个栈来保存数组元素的下标，注意是保存‘下标’。
    // 入栈和出栈的规则如下:
    //    (1) 当栈为空，或者以栈顶元素tp为下标查到的heights[tp] <= heights[i]时(i为当前遍历的索引)，入栈
    //    (2) 当栈顶元素tp对应的heights[tp] > heights[i]时，出栈，同时计算以heights[tp]为高，能得到的最大矩形面积
    //    (3) 当遍历完整个heights数组后，若栈不为空，则依次弹栈，同时以栈顶元素tp对应的heights[tp]为高，
     * 计算能得到的最大矩形面积
	 */
	public int largestRectangleArea(int[] heights) {
	        if (heights == null || heights.length == 0) {
	            return 0;
	        }
	        Stack<Integer> stack = new Stack<Integer>();
	        int maxSize = 0;
	        int i = 0;
	        for (; i < heights.length; i++) {
	            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
	                stack.push(i);
	            } else {
	                // 当前遍历元素heights[i] 比栈顶元素tp对应的heights[tp]小, 栈顶元素出栈
	                int tp = stack.pop();
	                int beginIndex = stack.empty() ? -1 : stack.peek(); // 当栈为空时，说明最大矩形的长度从下标0开始
	                                                                    // 所以将beginIndex设置为-1
	                maxSize = max(maxSize, heights[tp] * (i-1 - beginIndex));
	                i--; // 由于heights[i]元素还在栈外等候，还需要继续和栈顶元素进行比较，所以i--
	            }
	        }
	        
	        while (!stack.empty()) {
	            // 栈还不为空，对每个栈顶元素tp 计算以heights[tp]为高的矩形的最大面积, 并将栈顶元素出栈
	            int tp = stack.pop();
	            int beginIndex = stack.empty() ? -1 : stack.peek(); // 当栈为空时，说明最大矩形的长度从下标0到下标n-1，
	                                                                // 所以将beginIndex设置为-1
	            maxSize = max(maxSize, heights[tp] * (i-1 - beginIndex));
	        }
	        
	        return maxSize;
	    }
	    
	    private int max(int a, int b) {
	        return a > b ? a : b;
	    }

}


