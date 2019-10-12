package com.goodhealth.algorithm.DataStruct;

import java.util.LinkedHashMap;


//                                    �����鷽������һ�����Ҷ�����
//                                     ��������������ѯ
//                                      ��������ɾ������ӽ�����

public class SearchBinaryTreeDemo {
	static TreeNode root;
	static int index = 0;
	static LinkedHashMap<Integer, TreeNode> map = new LinkedHashMap<>();// ������ű������
	static LinkedHashMap<Integer, TreeNode> map2 = new LinkedHashMap<>();// ������ű������

	public static void main(String[] args) {
		SearchBinaryTreeDemo searchBinaryTreeDemo = new SearchBinaryTreeDemo();
		int[] an = { 50, 30, 20, 15, 35, 49,60,25,34,27 };
		for (int i = 0; i < an.length; i++) {
			searchBinaryTreeDemo.put(an[i]);
			System.out.println(index);
		}
		searchBinaryTreeDemo.midOrder(root);
		System.out.println("-----------ʹ��map����index���ҽ��---------");
		searchBinaryTreeDemo.midOrder2(root);
		searchBinaryTreeDemo.midOrder3(root);
		System.out.println(map.size());
		System.out.println(map2.size());
		TreeNode aNode = searchBinaryTreeDemo.getNode(2);
		TreeNode aNode2 = searchBinaryTreeDemo.getNode2(50);
		System.out.println(aNode.toString());
		System.out.println(aNode2.toString());
		System.out.println("--------ʹ��search����data���ҽ��------------");
		TreeNode aNode3=searchBinaryTreeDemo.search(27);
		System.out.println(aNode3.toString());
		System.out.println("--------------------");
		searchBinaryTreeDemo.deleteNode(60);
		searchBinaryTreeDemo.midOrder(root);
		
	}
	//��������ɾ������

	// ����data���Ҳ����ؽ��
	public TreeNode search(int data) {
		TreeNode node = root;
		if (node == null) {
			return null;
		} else {
			while (node != null && node.data != data) {
				if (data > node.data) {
					node = node.rChild;
				} else {
					node = node.lChild;
				}
			}
		}
		return node;
	}
	
	//ɾ�����Ķ��ⷽ��
	public void deleteNode(int data) {
		TreeNode node=search(data);
		if (node==null) {
			System.out.println("δ�ҵ��˽��");
		}else {
			delete(node);
		}
		
	}
	// ɾ������ʵ�ַ���
	private void delete(TreeNode node) {
		TreeNode parent=node.parent;
		//��ɾ����������ҽ��
		if (node.lChild==null&&node.rChild==null) {
			if (parent.lChild==node) {
				parent.lChild=null;
			}else {
				parent.rChild=null;
			}
			//��ɾ��������ҽ��
		}else if (node.lChild==null&&node.rChild!=null) {
			if (parent.lChild==node) {
				parent.lChild=node.rChild;
			}else {
				parent.rChild=node.rChild;
			}
			//��ɾ�����������
		} else if (node.rChild==null&&node.lChild!=null) {
			if (parent.lChild==node) {
				parent.lChild=node.lChild;
			}else {
				parent.rChild=node.lChild;
			}
			//�����Һ���Ҳ������
			
		}else {
			TreeNode next=getNext(node);
			delete(next);
			node.data=next.data;
			
		}
		
	}
	
      //�ҵ���̽��
	public  TreeNode getNext(TreeNode next) {
		TreeNode node=null;
		if (next==null) {
			return null;
		}else {
			if (next.rChild!=null) {
				//�ҵ���С�ؼ��ֽ��
				return getMin(next.rChild);
			}else {
				TreeNode parent=next.parent;
				while(parent!=null&&parent.data<next.data){
					parent=parent.parent;
				}
				parent=parent.parent;
				parent=node;
			}
		}
		return node;
		
	}
	//�ҵ���С�ؼ��ֽ��
	private TreeNode getMin(TreeNode node) {
		if (node==null) {
			return null;
		}else {
			while (node.lChild!=null) {
				node=node.lChild;
			}
		}
	return node;
}
		

	// ����data��С��ӽ�㣬����һ�Ų��Ҷ�����
	public TreeNode put(int data) {
		TreeNode node = null;
		TreeNode parent = null;
		if (root == null) {
			node = new TreeNode(index, data);
			root = node;
			return node;
		} else {
			node = root;
			index++;
		}
		while (node != null) {
			parent = node;
			if (data > node.data) {
				node = node.rChild;
			} else if (data < node.data) {
				node = node.lChild;
			} else {
				return node;
			}
		}
		node = new TreeNode(index, data);
		if (data < parent.data) {
			parent.lChild = node;
		} else {
			parent.rChild = node;
		}
		node.parent = parent;
		return node;
	}

	
	
	// ������������
	public void midOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			midOrder(node.lChild);
			System.out.println("midOrder data:" + node.getData() + "     index:" + node.getIndex());
			midOrder(node.rChild);
		}

	}
    //
	//
	//
	// ���������㲢�Ž�һ��map���� keyΪindex
	public LinkedHashMap<Integer, TreeNode> midOrder2(TreeNode node) {
		map.put(node.index, node);
		if (node.lChild != null) {
			midOrder2(node.lChild);
		}
		if (node.rChild != null) {
			midOrder2(node.rChild);
		}
		return map;
	}

	// ����index���ؽ��
	public TreeNode getNode(int index) {
		TreeNode rTreeNode = map.get(index);
		return rTreeNode;
	}
	// ���������㲢�Ž�һ��map���� keyΪdata

	public LinkedHashMap<Integer, TreeNode> midOrder3(TreeNode node) {
		map2.put(node.data, node);
		if (node.lChild != null) {
			midOrder3(node.lChild);
		}
		if (node.rChild != null) {
			midOrder3(node.rChild);
		}
		return map2;
	}

	// ����data���ؽ��
	public TreeNode getNode2(int data) {
		TreeNode rTreeNode = map2.get(data);
		return rTreeNode;
	}

	class TreeNode {
		private int index;
		private int data;
		private TreeNode parent;
		private TreeNode lChild;
		private TreeNode rChild;

		public TreeNode(int index, int data) {
			super();
			this.index = index;
			this.data = data;
		}

		public TreeNode(int index, int data, TreeNode parent, TreeNode lChild, TreeNode rChild) {
			super();
			this.index = index;
			this.data = data;
			this.parent = parent;
			this.lChild = lChild;
			this.rChild = rChild;
		}

		public TreeNode(int index, int data, TreeNode lChild, TreeNode rChild) {
			super();
			this.index = index;
			this.data = data;
			this.lChild = lChild;
			this.rChild = rChild;
		}

		public TreeNode(int index, int data, TreeNode parent) {
			super();
			this.index = index;
			this.data = data;
			this.parent = parent;
		}

		int getIndex() {
			return index;
		}

		void setIndex(int index) {
			this.index = index;
		}

		int getData() {
			return data;
		}

		void setData(int data) {
			this.data = data;
		}

		TreeNode getParent() {
			return parent;
		}

		void setParent(TreeNode parent) {
			this.parent = parent;
		}

		TreeNode getlChild() {
			return lChild;
		}

		void setlChild(TreeNode lChild) {
			this.lChild = lChild;
		}

		TreeNode getrChild() {
			return rChild;
		}

		void setrChild(TreeNode rChild) {
			this.rChild = rChild;
		}

		@Override
		public String toString() {
			return "TreeNode index=" + index + ", data=" + data;
		}
	}
}
