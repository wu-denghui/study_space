/**
 * 
 */
package com.goodhealth.algorithm.DataStruct;

import java.util.LinkedList;

/**
 * @author 24663
 * @date 2018年11月20日
 * @Description
 */
public class GraphTest {

	public static void main(String[] args) {
		GraphTest myGraph = new GraphTest(6);
		for (int i = 65; i <= 65 + 6; i++) {
			myGraph.addVertex((char) i);
		}
		int[][] matrix = { { 0, 1, 12, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT },
				{ MAX_WEIGHT, 0, 9, 3, MAX_WEIGHT, MAX_WEIGHT },
				{ MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT, 5, MAX_WEIGHT }, { MAX_WEIGHT, MAX_WEIGHT, 4, 0, 13, 15 },
				{ MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, 4 },
				{ MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 }, };
		myGraph.setMatrix(matrix);
		myGraph.SPFA();
		// int[] an= { 0, 1,12,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
		// System.out.println(myGraph.getMin(an));

	}

	public final static int MAX_WEIGHT = 99999;
	/**
	 * @Fields 图允许的最大顶点数
	 */
	public final int maxSize = 10;

	/**
	 * @Fields 创建图时预设的顶点数，不得大于maxSize
	 */
	public int size;

	/**
	 * @Fields 当前图中含有的顶点数，不得大于size
	 */
	public int current;

	public char[] vertex;

	public int[][] matrix;

	public boolean[] visit;

	public GraphTest(int size) {
		if (size > 0 && size <= maxSize) {
			this.size = size;
			this.current = 0;
			vertex = new char[size];
			matrix = new int[size][size];
			visit = new boolean[size];
		}
	}

	/*
	 * 打印矩阵队列图
	 */
	public void printGraph() {
		System.out.printf("Martix Graph:\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.printf("%d ", matrix[i][j]);
			System.out.printf("\n");
		}
	}
	
	
	
	/**
	 * 
	 * @Description 用SPFA算法，求顶点vo到其他顶点的最短路径
	 */
	public void  SPFA(){
		boolean[]  isContain=new boolean[size];//当顶点在队列里时不能再加入队列
		LinkedList<Integer> queue=new  LinkedList<>();
		int[] min=new int[size];
		for (int i = 1; i < min.length; i++) {
			min[i]=MAX_WEIGHT;
		}
		queue.push(0);
		isContain[0]=true;
		while (!queue.isEmpty()) {
			int v=queue.pop();
			isContain[v]=false;//出队列，改变属性
			for (int i = 0; i < min.length; i++) {
				if (matrix[v][i]!=0&&matrix[v][i]!=MAX_WEIGHT) {
					min[i]=Math.min(min[i], min[v]+matrix[v][i]);//
				}
				if (!isContain[i]&&matrix[v][i]!=0&&matrix[v][i]!=MAX_WEIGHT) {
					queue.push(i);//将顶点v的临接顶点加入队列
					isContain[i]=true;
				}
			}
		}
		for (int i = 0; i < min.length; i++) {
			System.out.println(min[i]);
		}
	}

	/**
	 * 
	 * @Description 用floyd（佛洛依德）算法，求任意两个顶点的最短路径 Floyd算法的时间复杂度为O(N3)，空间复杂度为O(N2)。
	 *              从任意节点i到任意节点j的最短路径不外乎2种可能，一是直接从i到j，二是从i经过若干个节点k到j。
	 *              所以，我们假设Dis(i,j)为节点u到节点v的最短路径的距离， 对于每一个节点k，我们检查Dis(i,k) +
	 *              Dis(k,j) < Dis(i,j)是否成立，
	 *              如果成立，证明从i到k再到j的路径比i直接到j的路径短，我们便设置Dis(i,j) = Dis(i,k) +
	 *              Dis(k,j)， 这样一来，当我们遍历完所有节点k，Dis(i,j)中记录的便是i到j的最短路径的距离。
	 */
	public void floyd(int[][] edge) {
		
		for (int k = 1; k < size; k++)
			for (int i = 1; i < size; i++)
				for (int j = 1; j < size; j++)
					if (edge[i][k] != MAX_WEIGHT && edge[k][j] != MAX_WEIGHT && edge[i][j] > edge[i][k] + edge[k][j])
						edge[i][j] = edge[i][k] + edge[k][j];

	}

	/**
	 * 
	 * @Description 用Dijkstra（迪杰斯特拉）算法，求顶点vo到其他顶点的最短路径
	 *              这个算法的时间复杂度是O(N2)。其中每次找到离1号顶点最近的顶点的时间复杂度是O(N)。
	 */
	public void Dijkstra() {
		int[] min = new int[size];// 保存了顶点vo到其他顶点的最短路经的猜测
		boolean[] isShort = new boolean[size];// 是否vo到其他顶点i的最短路径已确定
		isShort[0] = true;
		for (int i = 0; i < min.length; i++) {
			min[i] = matrix[0][i];// 对min数组初始化，到每一点最短路径为边的权值，不存在边则为Integer.MaxValue
		}
		// 以下为算法的核心
		// ---------------------------------------------
		int count = 0;
		while (count < size) {
			int v = getMin(min, isShort);// 选取未确定最短路径的顶点中到v0路径最短的顶点v（已经确定的顶点不再考虑）
			isShort[v] = true;// v的最短路径已知
			for (int i = 1; i < min.length; i++) {
				if (!isShort[i]) {//根据v0到v 去更新min数组
					// 已经确定的顶点不再考虑
					min[i] = Math.min(min[v] + matrix[v][i], min[i]);
					// 顶点vo到其他顶点的最短路径是在直接到达与以顶点v为转点两种方法取小
				}
			}
			count++;
		}
		// ----------------------------------------
		for (int i = 0; i < isShort.length; i++) {
			System.out.println(min[i]);
		}
	}

	/**
	 * @param
	 * @Description
	 */
	public int getMin(int[] an, boolean[] bool) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < an.length; i++) {
			if (!bool[i] && an[i] != 0 && an[i] < min) {
				min = an[i];
				result = i;
			}
		}
		return result;
	}

	/**
	 * 
	 * @Description 图的拓扑排序
	 */
	public void topoSort() {
		LinkedList<Integer> stack = new LinkedList<>();
		int[] chudu = getChudu();
		for (int i = 0; i < chudu.length; i++) {
			if (chudu[i] == 0) {
				stack.push(i);
				visit[i] = true;
			}
		}
		while (stack.size() < size) {
			int v = stack.peek();
			change(v, chudu);
			// System.out.println("顶点:"+vertex[v]);
			for (int i = 0; i < chudu.length; i++) {
				if (visit[i] == false && chudu[i] == 0) {
					stack.push(i);
					visit[i] = true;
					break;
				}
			}
		}
		for (int i = 0; i < chudu.length; i++) {
			System.out.print(vertex[stack.pop()] + " ");
		}
	}

	/**
	 * @param v
	 * @param chudu
	 * @Description
	 */
	public void change(int v, int[] chudu) {
		for (int i = 0; i < chudu.length; i++) {
			if (matrix[i][v] != 0) {
				chudu[i]--;
			}
		}
	}

	/**
	 * @return
	 * @Description 得到所有顶点的初始出度，即从chudu[i]顶点出发可以到达的下一顶点的个数
	 */
	public int[] getChudu() {
		int[] chudu = new int[size];
		for (int i = 0; i < size; i++) {
			int count = 0;
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] != 0) {
					count++;
				}
			}
			chudu[i] = count;
		}
		return chudu;
	}

	/**
	 * 
	 * @Description 最小生成树之普利姆算法
	 */
	public void prim() {
		int[] minW = new int[size];// 数组minW储存从当前顶点往下走时，到下一节点的权值
		for (int i = 0; i < minW.length; i++) {
			minW[i] = matrix[0][i];
		}
		int count = 0;// 当count为8的时候，已经遍历完所有的顶点了
		int sum = 0;
		int current = 0;
		System.out.print("顶点:" + vertex[0]);
		visit[0] = true;
		int temp;
		while (count < size) {
			temp = getMinWeight(current, minW);
			System.out.print("----[" + minW[temp] + "]---->顶点:" + vertex[temp]);
			sum += minW[temp];
			// 对minW数组进行更新
			// -----------------------------------------------
			minW[temp] = 0;
			for (int i = 1; i < minW.length; i++) {
				if (matrix[temp][i] != 0) {
					minW[i] = Math.min(minW[i], matrix[temp][i]);
					// 权值数组里的权值是节点temp去其他顶点与current节点去往temp节点兄弟顶点的权值相比取小值
				}
			}
			// --------------------------------------------------
			// 这一段是算法的核心，最小生成树拉直时不一定是一条线，也能中途有分岔出现
			current = temp;
			count++;
		}
		System.out.println();
		System.out.println("最小权值为" + sum);
	}

	/**
	 * @param index
	 * @Description 得到从顶点vertex[index]出发的话想要是最小权值的话下一个顶点应该选取哪个顶点
	 */
	public int getMinWeight(int index, int[] minw) {
		int min = Integer.MAX_VALUE;
		int minVertex = index;
		for (int i = 0; i < size; i++) {
			if (visit[i] == false && minw[i] != 0 && minw[i] < min) {
				min = minw[i];
				minVertex = i;
			}
		}
		visit[minVertex] = true;
		return minVertex;
	}

	/**
	 * 
	 * @Description 图的深度优先遍历
	 */
	public void DFS() {
		LinkedList<Integer> stack = new LinkedList<>();
		visit[0] = true;
		System.out.println("顶点:" + vertex[0]);
		stack.push(0);
		while (stack.size() != 0) {
			int n = getFirstNextVertex(stack.getFirst());
			if (n != -1) {
				visit[n] = true;
				System.out.println("顶点:" + vertex[n]);
				stack.push(n);
			} else {
				stack.removeFirst();
			}
		}
		for (int i = 0; i < size; i++) {
			visit[i] = false;
		}
	}

	/**
	 * @param index
	 * @return
	 * @Description 找到第一个与顶点vertex[index]相邻的顶点
	 */
	public int getFirstNextVertex(int index) {
		for (int i = 0; i < size; i++) {
			if (visit[i] == false && matrix[index][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @Description 图的广度优先遍历
	 */
	public void BFS() {
		LinkedList<Integer> queue = new LinkedList<>();
		visit[0] = true;
		System.out.println("顶点:" + vertex[0]);
		queue.push(0);
		while (queue.size() != 0) {
			getNextVertex(queue.getLast(), queue);
			queue.removeLast();
		}

	}

	/**
	 * @param index
	 * @param queue
	 * @Description 得到顶点vertex[index]的所有相邻顶点
	 */
	public void getNextVertex(int index, LinkedList<Integer> queue) {
		for (int i = 0; i < size; i++) {
			if (visit[i] == false && matrix[index][i] == 1) {
				System.out.println("顶点:" + vertex[i]);
				visit[i] = true;
				queue.push(i);
			}
		}
	}

	public boolean addVertex(char c) {
		if (current < this.size) {
			this.vertex[current++] = c;
			return true;
		}
		return false;
	}

	/**
	 * @return the vertex
	 */
	public char[] getVertex() {
		return vertex;
	}

	/**
	 * @param vertex
	 *            the vertex to set
	 */
	public void setVertex(char[] vertex) {
		this.vertex = vertex;
	}

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix
	 *            the matrix to set
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * @return the visit
	 */
	public boolean[] getVisit() {
		return visit;
	}

	/**
	 * @param visit
	 *            the visit to set
	 */
	public void setVisit(boolean[] visit) {
		this.visit = visit;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return current;
	}

	public int maxSize() {
		return maxSize;
	}

}
