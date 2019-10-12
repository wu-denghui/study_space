/**
 * 
 */
package com.goodhealth.algorithm.ListExercise;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 24663
 * @date 2018年8月30日
 * @Description 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 *              给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
 */
public class MergeKSortedLists {
	
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			return left.val - right.val;
		}
	};

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.add(lists.get(i));
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap.add(head.next);
			}
		}
		return dummy.next;
	}
}
