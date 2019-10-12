/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 24663
 * @date 2018年9月10日
 * @Description  克隆图
 */
public class TI_137 { 
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null) {
			return  null;
		}
		ArrayList<UndirectedGraphNode>  oldNodes=new ArrayList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode>  map=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		oldNodes.add(node);
		map.put(node, new UndirectedGraphNode(node.label));
		//复制节点
		int index=0;
		while(index<oldNodes.size()){
				UndirectedGraphNode temp=oldNodes.get(index++);
				for (int j = 0; j < temp.neighbors.size(); j++) {
					UndirectedGraphNode nod=temp.neighbors.get(j);
					if (!map.containsKey(nod)) {
						map.put(nod, new UndirectedGraphNode(nod.label));
						oldNodes.add(nod);
					}
			}
		}
		//复制边
		for (int i = 0; i < oldNodes.size(); i++) {
			UndirectedGraphNode newNode=map.get(oldNodes.get(i));
			for (int j = 0; j <oldNodes.get(i).neighbors.size(); j++) {
		       newNode.neighbors.add(map.get(oldNodes.get(i).neighbors.get(j)));
				}
			}
		return  map.get(node);
	}

}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}