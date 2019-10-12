package com.goodhealth.algorithm.LintCode_Stack;

import java.util.Stack;

public class 两个栈实现队列 {

    public static void main(String[] args){
        MyQueue q = new MyQueue();
        q.push(1);
        System.out.println(q.pop());
        q.push(2);
        q.push(3);
        System.out.println(q.top());
        System.out.println(q.pop());
    }



}

class MyQueue {

    private  static Stack<Integer> stackInto = new Stack<>();
    private  static Stack<Integer> stackOut = new Stack<>();

    public MyQueue() {

    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stackInto.clear();
        // write your code here
        while (!stackOut.empty()){
            stackInto.push(stackOut.pop());
        }
        stackInto.push(element);
        while (!stackInto.empty()){
            stackOut.push(stackInto.pop());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        return stackOut.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stackOut.peek();
    }
}