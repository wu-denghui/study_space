package com.goodhealth.algorithm.DataStruct;

import java.util.LinkedList;


public class TreeDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeNode<String>[] one = new TreeNode[10];
		one[0] = new TreeNode<String>("A", -1);
		one[1] = new TreeNode<String>("B", 0);
		one[2] = new TreeNode<String>("C", 0);
		one[3] = new TreeNode<String>("D", 1);
		one[4] = new TreeNode<String>("E", 2);
		one[5] = new TreeNode<String>("F", 2);
		one[6] = new TreeNode<String>("G", 3);
		one[7] = new TreeNode<String>("H", 3);
		one[8] = new TreeNode<String>("I", 3);
		one[9] = new TreeNode<String>("J", 4);
		int an = one[8].getParent();
		System.out.println(one[8].getData() + "�ĸ������" + one[an].getData());
		System.out.println("-----------------------------");
		BinaryTreeNode<String> A, B = null, C = null, D = null, E = null, F = null,
				G = null, H = null, I = null,J = null;
		J = new BinaryTreeNode<String>("J", null, null);
		H = new BinaryTreeNode<String>("H", null, null);
		I = new BinaryTreeNode<String>("I", null, null);
		G = new BinaryTreeNode<String>("G", null, null);
		F = new BinaryTreeNode<String>("F", null, null);
		E = new BinaryTreeNode<String>("E", J, null);
		D = new BinaryTreeNode<String>("D", H, I);
		C = new BinaryTreeNode<String>("C", F, G);
		B = new BinaryTreeNode<String>("B", D, E);
		A = new BinaryTreeNode<String>("A", B, C);
		System.out.println(A);
		System.out.println(D);
		System.out.println("-----------------------------");
		J = new BinaryTreeNode<String>("J");
		H = new BinaryTreeNode<String>("H");
		I = new BinaryTreeNode<String>("I");
		G = new BinaryTreeNode<String>("G");
		F = new BinaryTreeNode<String>("F");
		E = new BinaryTreeNode<String>("E");
		D = new BinaryTreeNode<String>("D");
		C = new BinaryTreeNode<String>("C");
		B = new BinaryTreeNode<String>("B");
		A = new BinaryTreeNode<String>("A");
		A.setLeftChild(B);
		A.setRightChild(C);
		B.setLeftChild(D);
		B.setRightChild(E);
		C.setLeftChild(F);
		C.setRightChild(G);
		D.setLeftChild(H);
		D.setRightChild(I);
		E.setLeftChild(J);
		System.out.println("-----------------------------");
		BinaryTreeArrayNode<String>[] three = new BinaryTreeArrayNode[10];
		three[0] = new BinaryTreeArrayNode<String>("A", 1, 2);
		three[1] = new BinaryTreeArrayNode<String>("B", 3, 4);
		three[2] = new BinaryTreeArrayNode<String>("C", 5, 6);
		three[3] = new BinaryTreeArrayNode<String>("D", 7, 8);
		three[4] = new BinaryTreeArrayNode<String>("E", 9, -1);
		three[5] = new BinaryTreeArrayNode<String>("F", -1, -1);
		three[6] = new BinaryTreeArrayNode<String>("G", -1, -1);
		three[7] = new BinaryTreeArrayNode<String>("H", -1, -1);
		three[8] = new BinaryTreeArrayNode<String>("I", -1, -1);
		three[9] = new BinaryTreeArrayNode<String>("J", -1, -1);
		System.out.println(three[1].getLeftChild());
		System.out.println(three[4].getRightChild());
		System.out.println("-----------------------------");

	}

}

class TreeNode<T> {

	private T Data; 
	private int Parent; 

	public TreeNode(T data, int parent) {
		Data = data;
		Parent = parent;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

	public int getParent() {
		return Parent;
	}

	public void setParent(int parent) {
		Parent = parent;
	}

	@Override
	public String toString() {
		return "TreeNode [mData=" + Data + ", mParent=" + Parent + "]";
	}

}

class LinkedTreeNode<T> {

	private T mData; 
	private LinkedTreeNode<T> mParents;
	private LinkedList<LinkedTreeNode<T>> mChild;

	public LinkedTreeNode<T> getmParents() {
		return mParents;
	}

	public void setmParents(LinkedTreeNode<T> mParents) {
		this.mParents = mParents;
	}

	public LinkedTreeNode(T data, LinkedTreeNode<T> parent, LinkedTreeNode<T> Parents,
                          LinkedList<LinkedTreeNode<T>> list) {
		mData = data;
		mParents = parent;
		mChild = list;
	}

	public Object getData() {
		return mData;
	}

	public void setData(T data) {
		mData = data;
	}

	public LinkedList<LinkedTreeNode<T>> getChild() {
		return mChild;
	}

	public void setChild(LinkedList<LinkedTreeNode<T>> child) {
		mChild = child;
	}

	@Override
	public String toString() {
		return "LinkedTreeNode:" + " mData=" + mData;
	}
}

class BinaryTreeNode<T> {

	private T mData;
	private BinaryTreeNode<T> mLeftChild;
	private BinaryTreeNode<T> mRightChild;

	public BinaryTreeNode(T mData) {
		super();
		this.mData = mData;
	}

	public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		mData = data;
		mLeftChild = leftChild;
		mRightChild = rightChild;
	}

	public T getData() {
		return mData;
	}

	public void setData(T data) {
		mData = data;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return mLeftChild;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		mLeftChild = leftChild;
	}

	public BinaryTreeNode<T> getRightChild() {
		return mRightChild;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		mRightChild = rightChild;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [mData=" + mData + ", mLeftChild=" + mLeftChild.getData() + ", mRightChild="
				+ mRightChild.getData() + "]";
	}

}

class BinaryTreeArrayNode<T> {

	private T mData;
	private int mLeftChild;
	private int mRightChild;

	public BinaryTreeArrayNode(T string, int i, int j) {
		this.mData = string;
		this.mLeftChild = i;
		this.mRightChild = j;

	}

	public T getData() {
		return mData;
	}

	public void setData(T data) {
		mData = data;
	}

	public String getLeftChild() {
		String str = null;
		if (mLeftChild == -1) {
			str = "������û�����ӽ��";
		} else {
			str = Integer.toString(mLeftChild);
		}
		return str;
	}

	public void setLeftChild(int leftChild) {
		mLeftChild = leftChild;
	}

	public String getRightChild() {
		String str = null;
		if (mRightChild == -1) {
			str = "������û���Һ��ӽ��";
		} else {
			str = Integer.toString(mRightChild);
		}
		return str;
	}

	public void setRightChild(int rightChild) {
		mRightChild = rightChild;
	}

	@Override
	public String toString() {
		return "BinaryTreeArrayNode [mData=" + mData + ", mLeftChild=" + mLeftChild + ", mRightChild=" + mRightChild
				+ "]";
	}

}
