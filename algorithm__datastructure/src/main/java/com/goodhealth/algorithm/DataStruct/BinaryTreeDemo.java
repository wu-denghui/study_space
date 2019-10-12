package com.goodhealth.algorithm.DataStruct;

//二叉树的构建及常用方法
public class BinaryTreeDemo {
	
	private TreeNode  root = null;
	
	 public BinaryTreeDemo(){
	
		root = new TreeNode(1, "A");
	}
	
	/**
	 *         A
	 *     B       C
	 * D      E        F
	 */
	 
	 
	public void createBinaryTree(){
		TreeNode nodeB = new TreeNode(2, "B");
		TreeNode nodeC = new TreeNode(3, "C");
		TreeNode nodeD = new TreeNode(4, "D");
		TreeNode nodeE = new TreeNode(5, "E");
		TreeNode nodeF = new TreeNode(6, "F");
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.rightChild = nodeF;
	}
	

	/**
	 * @return
	 * @Description    求二叉树的最高高度（层数)
	 */
	public int getHeight(){
		return getHeight(root);
	}
	
	/**
	 * @param node
	 * @return
	 * @Description    求某一节点的高度
	 */
	private int getHeight(TreeNode node) {
		if(node == null){
			return 0;
		}else{
			int i = getHeight(node.leftChild);
			int j = getHeight(node.rightChild);
			return (i<j)?j+1:i+1;
		}
	}


	/**
	 * @return
	 * @Description   求二叉树的最大节点数
	 */
	public int getSize(){
		return getSize(root);
	}
	
	
	/**
	 * @param node
	 * @return
	 * @Description     求二叉树以某一节点为根节点的子树的节点数
	 */
	private int getSize(TreeNode node) {
		if(node == null){
			return 0;
		}else{
			return 1+getSize(node.leftChild)+getSize(node.rightChild);
		}
	}



	/**
	 * @param node  根节点
	 * @Description   二叉树的先序遍历  根左右
	 */
	public void preOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			System.out.println("preOrder data:"+node.getData());
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	/**
	 * @param node  根节点
	 * @Description   中序遍历    左根右
	 */
	public void midOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			midOrder(node.leftChild);
			System.out.println("midOrder data:"+node.getData());
			midOrder(node.rightChild);
		}
	}
	

	/**
	 * @param node  根节点
	 * @Description  后序遍历   左右根
	 */
	public void postOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.println("postOrder data:"+node.getData());
		}
	}
	
	public class TreeNode{
		private int index;
		private String data;
		private TreeNode leftChild;
		private TreeNode rightChild;
		
	
		public int getIndex() {
			return index;
		}


		public void setIndex(int index) {
			this.index = index;
		}


		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public TreeNode(int index,String data){
			this.index = index;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	

}
