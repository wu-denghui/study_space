/**
 * 
 */
package com.goodhealth.algorithm.DataStruct;

/**
 * @author 24663
 * @date 2018年11月13日
 * @Description 堆--基本数据结构之一，利用完全二叉树的结构来维护一组数据，然后进行相关操作，
 *              一般的操作进行一次的时间复杂度在O(1)~O(logn)之间。
 */
// 一个最大堆，即父节点的值大于子节点
public class Heap {
	
	public static void main(String[] args) {
		Heap heap=new Heap(8);
		heap.push(5);
		heap.push(2);
		heap.push(6);
		heap.push(9);
		heap.push(15);
		heap.push(17);
		heap.push(18);
		heap.push(25);
		heap.dispaly();
		System.out.println(heap.peek().getData());
		heap.pop();
		heap.dispaly();
	}

	// 底层是由数组实现
	public Node[] nodes;

	public int maxSize;

	public int currentSize;

	public Heap(int mx) {
		this.maxSize = mx;
		this.currentSize = 0;
		this.nodes = new Node[maxSize];
	}

	/**
	 * @param key
	 * @return
	 * @Description   向堆中加入一个元素
	 */
	public boolean push(int key) {
		if (currentSize == maxSize) {
			return false;
		}
		Node newNode = new Node(key);
		nodes[currentSize] = newNode;//将新加的元素放到数组的最后一个
		shiftUp(currentSize);//新加的元素向上寻找正确的位置
		currentSize++;
		return true;
	}
	
	/**
	 * @return
	 * @Description   删除堆的顶元素
	 */
	public boolean pop(){
		if (nodes.length!=0) {
			nodes[0]=nodes[currentSize-1]; //将堆的最后一个元素放到堆顶，原堆顶元素被删除
			currentSize--;
			shiftDown(0);//将新堆顶元素向下寻找正确位置
		}
		return false;
		
	}
	
	/**
	 * @param i
	 * @Description 将指定元素向下寻找正确位置
	 */
	private void shiftDown(int index) {
		Node current=nodes[index];
		int  maxC;//找到两个子节点中的最大的那个节点
		while(index<=currentSize/2){
			int left=index*2;
			int right=left+1;
			if (right<currentSize&&nodes[left].getData()>=nodes[right].getData()) {
				maxC=left;
			}else{
				maxC=right;
			}
			if (nodes[index].getData()<nodes[maxC].getData()) {//若父节点大于两个子节点，则表示找到了正确的位置，
				                                                                             //否则将最大子节点上升到父节点
				nodes[index]=nodes[maxC];
			}else{
				break;
			}
			index=maxC;
			
		}
		nodes[index]=current;
	}

	/**
	 * @return
	 * @Description  取出堆顶元素但不删除
	 */
	public Node peek(){
		if (nodes.length!=0) {
			return  nodes[0];
		}else{
			return  null;
		}
	}

	/**
	 * @param index
	 * @Description 将指定元素向上寻找到自己的位置
	 */
	private void shiftUp(int index) {
		int par = index / 2;
		Node parent = nodes[par];
		Node current = nodes[index];
		while (index > 0 && parent.getData() < current.getData()) {// 新加入的节点值大于父节点的值
			nodes[index] = nodes[par];
			index = par;
			par = par / 2;
		}
		nodes[index]=current;
	}
	
	public  void dispaly(){
		System.out.print("nodes"+" ");
		for (int i = 0; i < nodes.length; i++) {
			System.out.print(nodes[i].getData()+" ");
		}
	}
	
	
}

class Node {
	private int data;

	/**
	 * @param data
	 */
	public Node(int data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

}
