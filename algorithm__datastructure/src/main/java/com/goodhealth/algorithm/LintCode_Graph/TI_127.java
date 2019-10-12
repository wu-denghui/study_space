/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 24663
 * @date 2018年9月13日
 * @Description 有向图的拓扑排序
 */
public class TI_127 {

	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// 返回拓扑排序后的序列
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		// map用于存储每一节点的入度
		HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
		// 存储每一个节点的入度
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neightbor : node.neighbors) {
				if (map.containsKey(neightbor)) {
					map.put(neightbor, map.get(neightbor) + 1);
				} else {
					map.put(neightbor, 1);
				}
			}
		}
		// 将入度为0的节点加入到队列queue和result中
		Queue<DirectedGraphNode> queue = new LinkedList<>();
		for (DirectedGraphNode node : graph) {
			if (!map.containsKey(node)) {
				result.add(node);
				queue.add(node);
			}
		}
		//入度为0的节点出队列，并将他们的下一节点的入度减一，如减一后入度为0，则将其加入队列queue和result中
		while (!queue.isEmpty()) {
			DirectedGraphNode temp = queue.poll();
			for (DirectedGraphNode node : temp.neighbors) {
				map.put(node, map.get(node) - 1);
				if (map.get(node) == 0) {
					result.add(node);
					queue.add(node);
				}
			}
		}
		return result;
	}

}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}
