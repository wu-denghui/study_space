/**
 * 
 */
package com.goodhealth.algorithm.ListExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 24663
 * @date 2018年9月12日
 * @Description
105. 复制带随机指针的链表
给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。
返回一个深拷贝的链表
 */
public class LC_105 {

    public RandomListNode copyRandomList(RandomListNode head) {
		if (head==null) {
			return  null;
		}
		ArrayList<RandomListNode>  oldNodes=new ArrayList<>();
		Map<RandomListNode, RandomListNode>  map=new HashMap<RandomListNode, RandomListNode>();
		oldNodes.add(head);
		map.put(head, new RandomListNode(head.label));
		//复制next节点
		int index=0;
		while(true){
				RandomListNode nod=oldNodes.get(index++).next;
				if (nod==null) {
					break;
				}
				if (!map.containsKey(nod)) {
						map.put(nod, new RandomListNode(nod.label));
						oldNodes.add(nod);
			}
		}
		//复制random节点
		for (int i = 0; i +1< oldNodes.size(); i++) {
			RandomListNode newNode=map.get(oldNodes.get(i));
			newNode.next=map.get(oldNodes.get(i+1));
				}
		for (int i = 0; i < oldNodes.size(); i++) {
			RandomListNode newNode=map.get(oldNodes.get(i));
			newNode.random=oldNodes.get(i).random;
			
		}
		return  map.get(head);
        // write your code here
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
