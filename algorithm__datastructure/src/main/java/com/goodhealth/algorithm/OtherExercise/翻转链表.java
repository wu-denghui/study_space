package com.goodhealth.algorithm.OtherExercise;

public class 翻转链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public ListNode reverse(ListNode head) {
    ListNode temp;
    ListNode move = head;
    head = null;
    while (move.next!=null){
        temp = move;
        move = move.next;
        temp.next = head;
        head = temp;
    }
    move.next = head;
    head = move;
    return head;
}

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode previous =head ;
        ListNode end = head;
        ListNode start = head;
        ListNode next = head;
        int  index = 1;
        while (next.next!=null){
            next = next.next;
            index++;
            if (index==n+1){
                break;
            }
            if (index<m){
                previous = previous.next;
            }
            if (index<=n){
                end = end.next;
            }
            if (index<=m){
                start = start.next;
            }
        }
        previous.next = null;
        end.next = null;
        reverse(start);
        previous.next = end;
        start.next = next;
        return head;
    }
}
