/**
 * 
 */
package com.goodhealth.algorithm.DataStruct;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 24663
 * @date 2019年2月17日
 * @Description
 */
public class StackAndDeque {
public static void main(String[] args) {
	LinkedList<Integer>  stack=new LinkedList<>();
    stack.addFirst(1);   //进栈
    stack.addFirst(2);
    stack.addFirst(3);
    stack.addFirst(4);
    stack.addFirst(5);
    stack.removeFirst();   //出栈  先进后出
    System.out.println(stack);
    LinkedList<Integer>  queue=new LinkedList<>();
    queue.addFirst(1);  
    queue.addFirst(2);  
    queue.addFirst(3);  
    queue.addFirst(4);  
    queue.addFirst(5);  
    queue. removeFirst();
    System.out.println(queue);
    Deque<Integer>  dqueue=new LinkedList<>();
    dqueue.addFirst(1);  // 进队列
    dqueue.addFirst(2);
    dqueue.addFirst(3);
    dqueue.addFirst(4);
    dqueue.addFirst(5);
    dqueue.removeLast();  //出队列   先进先出
    System.out.println(dqueue.peekLast());
    System.out.println(dqueue);
}
}
