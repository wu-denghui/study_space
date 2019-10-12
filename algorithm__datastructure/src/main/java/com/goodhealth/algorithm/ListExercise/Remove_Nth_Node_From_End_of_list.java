package com.goodhealth.algorithm.ListExercise;

/**
 * @author 24663
 * @date 2018年8月29日
 * @Description     给定一个链表，删除链表中倒数第n个节点，返回链表的头节点
 */
class ListNode{
	 int  val;
     ListNode next;
	public ListNode(int val) {
		this.val=val;
	}
}

public class Remove_Nth_Node_From_End_of_list {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        //dummy为设点的头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // preDelete 双指针中的慢指针  head为快指针
        ListNode preDelete = dummy;
        //快指针比慢指针领先n+1个节点 （原本就领先一个节点，走完for之后又多走了n个节点）
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        //两个指针一起往前推进 知道head为null，即haed到指针null节点，此时perdelete到了倒数n+1个节点
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        //删除倒数第n个节点
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
