package com.goodhealth.algorithm.DataStruct;

import java.util.Arrays;

public class GraphKruskal {
	public static void main(String[] args) {
		Graph graphKruskal = new Graph(10);
		graphKruskal.creatGraph();
		graphKruskal.Kruskal();
	}
}

/**
 * @author 24663
 * @date 2018年11月23日
 * @Description 以边为主的方式构建的图
 */
class Graph {
	private Edge[] edges;
	private int edgeSize;

	public Graph(int edgeSize) {
		this.edgeSize = edgeSize;
		edges = new Edge[edgeSize];

	}

	/**
	 * 
	 * @Description 克鲁斯卡尔算法解决图的最小生成树问题
	 * 克鲁斯卡尔算法的基本思想是以边为主导地位，始终选择当前可用（所选的边不能构成回路）的最小权植边。
	 * 所以Kruskal算法的第一步是给所有的边按照从小到大的顺序排序。
	 * 这一步可以直接使用库函数qsort或者sort。接下来从小到大依次考察每一条边（u，v）。
	 */
	public void Kruskal() {
		int m, n, sum = 0;
		int[] end = new int[edgeSize];//end里保存的是遍历过的边
		for (int i = 0; i < edgeSize; i++) {
			end[i] = 0;
		}
		for (int i = 0; i < edgeSize; i++) {
			n = getEnd(end, edges[i].begin);
			m = getEnd(end, edges[i].end);
			if (n != m) {//当n！=m表示加入这条边不会构成环
				end[n] = m;//一条边加入生成树
				System.out.println("顶点" + edges[i].begin + "----[" + edges[i].weight+"]---->"+ "顶点" + edges[i].end );
				sum += edges[i].weight;
			} else {
				//这条边被舍弃
			}
		}
		System.out.println("最小权值为"+sum);
	}

	/**
	 * @param parent
	 * @param f
	 * @return
	 * @Description   返回f顶点的终点
	 */
	public int getEnd(int[] end, int f) {
		while (end[f] > 0) {
			f = end[f];
		}
		return f;
	}

	public void creatGraph() {
		Edge edge0 = new Edge(1, 4, 5);
		Edge edge1 = new Edge(1, 3, 1);
		Edge edge2 = new Edge(1, 2, 6);
		Edge edge3 = new Edge(2, 5, 3);
		Edge edge4 = new Edge(2, 3, 5);
		Edge edge5 = new Edge(3, 5, 6);
		Edge edge6 = new Edge(3, 6, 4);
		Edge edge9 = new Edge(3, 4, 5);
		Edge edge7 = new Edge(4, 6, 2);
		Edge edge8 = new Edge(5, 6, 6);
		edges[0] = edge0;
		edges[1] = edge1;
		edges[2] = edge2;
		edges[3] = edge3;
		edges[4] = edge4;
		edges[5] = edge5;
		edges[6] = edge6;
		edges[7] = edge7;
		edges[8] = edge8;
		edges[9] = edge9;
		Arrays.sort(this.edges);
	}
}

/**
 * @author 24663
 * @date 2018年11月23日
 * @Description  图的边的抽象表示
 */
class Edge implements  Comparable<Edge>{
	public int begin;
	public int end;
	public int weight;

	public Edge(int begin, int end, int weight) {
		super();
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}

}
