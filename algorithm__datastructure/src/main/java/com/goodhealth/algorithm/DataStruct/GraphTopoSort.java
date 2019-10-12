package com.goodhealth.algorithm.DataStruct;

import java.util.Stack;


public class GraphTopoSort {
	
	public static void main(String[] args) {
		GraphTP tp=new GraphTP(14);
		tp.createGraph();
		try {
			tp.topuSort();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class  GraphTP{
	private int numVertexes;
	private VertexNode []  adjList;
	public GraphTP(int numVertexes) {
		super();
		this.numVertexes = numVertexes;
	}
	
	
	class EdgeNode{
	private	   int  xbiao;
	private   EdgeNode  nextNode;
	private    int quan;
	
	
	public EdgeNode(int xbiao,EdgeNode nextNode, int quan) {
		super();
		this.xbiao = xbiao;
		this.nextNode = nextNode;
		this.quan = quan;
	}
	public EdgeNode(int i) {
		this.xbiao=i;
	}
	int getXbiao() {
		return xbiao;
	}
	void setXbiao(int xbiao) {
		this.xbiao = xbiao;
	}
	EdgeNode getNode() {
		return nextNode;
	}
	void setNode(EdgeNode nextNode) {
		this.nextNode = nextNode;
	}
	int getQuan() {
		return quan;
	}
	void setQuan(int quan) {
		this.quan = quan;
	}
		
	}
	
   class VertexNode{
	   private String data;
	   private int rdu;
	   private EdgeNode firstNode;
	   
	public VertexNode(String data, int rdu, EdgeNode nextnode) {
		super();
		this.data = data;
		this.rdu = rdu;
		this.firstNode = nextnode;
	}
	public VertexNode(int i, String string) {
		this.rdu = i;
		this.data = string;
	}
	String getData() {
		return data;
	}
	void setData(String data) {
		this.data = data;
	}
	int getRdu() {
		return rdu;
	}
	void setRdu(int rdu) {
		this.rdu = rdu;
	}
	EdgeNode getNode() {
		return firstNode;
	}
	void setNode(EdgeNode nextnode) {
		this.firstNode = nextnode;
	}
	   
   }
 public void createGraph(){
		VertexNode node0 = new VertexNode(0,"v0");
		VertexNode node1 = new VertexNode(0,"v1");
		VertexNode node2 = new VertexNode(2,"v2");
		VertexNode node3 = new VertexNode(0,"v3");
		VertexNode node4 = new VertexNode(2,"v4");
		VertexNode node5 = new VertexNode(3,"v5");
		VertexNode node6 = new VertexNode(1,"v6");
		VertexNode node7 = new VertexNode(2,"v7");
		VertexNode node8 = new VertexNode(2,"v8");
		VertexNode node9 = new VertexNode(1,"v9");
		VertexNode node10 = new VertexNode(1,"v10");
		VertexNode node11 = new VertexNode(2,"v11");
		VertexNode node12 = new VertexNode(1,"v12");
		VertexNode node13 = new VertexNode(2,"v13");
		adjList = new VertexNode[numVertexes];
		adjList[0] =node0;
		adjList[1] =node1;
		adjList[2] =node2;
		adjList[3] =node3;
		adjList[4] =node4;
		adjList[5] =node5;
		adjList[6] =node6;
		adjList[7] =node7;
		adjList[8] =node8;
		adjList[9] =node9;
		adjList[10] =node10;
		adjList[11] =node11;
		adjList[12] =node12;
		adjList[13] =node13;
		node0.firstNode = new EdgeNode(11);
		node0.firstNode.nextNode = new EdgeNode(5);
		node0.firstNode.nextNode.nextNode = new EdgeNode(4);
		node1.firstNode = new EdgeNode(8);
		node1.firstNode.nextNode = new EdgeNode(4);
		node1.firstNode.nextNode.nextNode = new EdgeNode(2);
		node2.firstNode = new EdgeNode(9);
		node2.firstNode.nextNode = new EdgeNode(6);
		node2.firstNode.nextNode.nextNode = new EdgeNode(5);
		node3.firstNode = new EdgeNode(13);
		node3.firstNode.nextNode = new EdgeNode(2);
		node4.firstNode = new EdgeNode(7);
		node5.firstNode = new EdgeNode(12);
		node5.firstNode.nextNode = new EdgeNode(8);
		node6.firstNode = new EdgeNode(5);
		node8.firstNode = new EdgeNode(7);
		node9.firstNode = new EdgeNode(11);
		node9.firstNode.nextNode = new EdgeNode(10);
		node10.firstNode = new EdgeNode(13);
		node12.firstNode = new EdgeNode(9);
	}

 public void topuSort(){
              Stack<Integer> stack =new Stack<>();
              int count=0;
              int k=0;
              for (int i = 0; i < adjList.length; i++) {
				if (adjList[i].rdu==0) {
					stack.push(i);
				}
			}
              while (!stack.isEmpty()) {
            	  int poNode=stack.pop();
            	  System.out.println(adjList[poNode].data);
            	  count++;
            	  for (EdgeNode node = adjList[poNode].firstNode;node!=null;node = node.nextNode) {
            		     k=node.xbiao;
            		     if (--adjList[k].rdu==0) {
							stack.push(k);
						}
				}
			}
              if (count<numVertexes) {
            	  //有环出现
			}
 }
 
}

