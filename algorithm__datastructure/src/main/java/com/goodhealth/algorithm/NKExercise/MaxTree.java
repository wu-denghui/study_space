/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;



/**
 * @author 24663
 * @date 2018年8月27日
 * @Description
 * 给定一个数组   组成值从大到小排列的二叉树
 * 
 * 列如 [2,5,6,0,3,1]   组成      6
 *                                       5        3
 *                                    2        0     1   
 * 
 */      
public class MaxTree {
	
	public static void main(String[] args) {
		MaxTree maxTree=new MaxTree();
		int[] an={2,5,6,0,3,1};
		maxTree.setTree(an);
	}
	public void setTree(int[] an){
		int   index=getMax(an, 0, an.length-1);
		Node root=new Node(an[index]);
		setChild(root, an, 0, index,an.length-1);
		midOrder(root);
	}
	public  void setChild(Node node, int[] an, int left, int max, int right){
		if (left==max) {
			
		}
		int leftmax=getMax(an, left, max-1);
		node.lchild=new Node(an[leftmax]);
		setChild(node.lchild, an, left, leftmax,max-1);
		int rightmax=getMax(an, max+1, right);
		node.rchild=new Node(an[rightmax]);
		setChild(node.rchild, an, max+1, leftmax,right);
	}
	public  void setRightChild(Node node, int[] an, int left, int right){
		int index=getMax(an, left, right);
		node.rchild=new Node(an[index]);
		setRightChild(node, an, index+1,right);
	}
	public int getMax(int[] an,int begin,int end){
		if (begin>0||end>an.length-1) {
			return Integer.MAX_VALUE;
		}
		if (begin==end) {
			return an[end];
		}
		int max=0;
		int index=0;
		for (int i = begin; i <= end; i++) {
			if (max<=an[i]) {
				max=an[i];
				index=i;
			}
		}
		return index;
	}
	
	public void midOrder(Node node){
		if(node == null){
			return;
		}else{
			midOrder(node.lchild);
			System.out.println("midOrder data:"+node.data);
			midOrder(node.rchild);
		}
	}

}

class Node{
	 int data;
	 Node lchild,rchild;
	 public Node(int data){
		 this.data=data;
	 }
	 
}