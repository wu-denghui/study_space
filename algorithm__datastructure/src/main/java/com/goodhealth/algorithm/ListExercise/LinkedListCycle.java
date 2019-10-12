/**
 * 
 */
package com.goodhealth.algorithm.ListExercise;

/**
 * @author 24663
 * @date 2018年8月29日
 * @Description    
 */
public class LinkedListCycle {
	/**
	 * @param head
	 * @return
	 * @Description   给定一个链表，判断它是否有环。
	 */
	public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快指针比慢指针领先一个字节
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        //快指针走两步 慢指针走一步 如果快指针和慢指针走到一起，说明肯定有环
        while (fast != slow) {
            if(fast==null || fast.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }
	/**
	 * @param head
	 * @return
	 * @Description  给定一个链表，判断它是否有环，并返回环的入口
	 */
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }
     // 快指针比慢指针领先一个字节
        ListNode fast, slow;
        fast = head.next;
        slow = head;
      //快指针走两步 慢指针走一步  直到快慢指针相遇
        while (fast != slow) {
        	//如果快指针走到了null  肯定没有环
            if(fast==null || fast.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //上个while走完head与fast走在一个位置
        //head指针往前走 直到走到慢指针的下一个节点 此时head为环的入口
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
