package com.goodhealth.algorithm.LintCode_Tree;

import java.util.*;

/**
 * @author 24663
 * @date 2018年9月5日
 * @Description 二叉树遍历
 */
public class BinaryTreeSearch {

	static TreeNode root;

	/**
	 * @return
	 * @Description 求二叉树的最高高度（层数)
	 */
	public int getHeight() {
		return getHeight(root);
	}

	/**
	 * @param node
	 * @return
	 * @Description 求某一节点的高度
	 */
	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int i = getHeight(node.left);
			int j = getHeight(node.right);
			return (i < j) ? j + 1 : i + 1;
		}
	}

	/**
	 * @return
	 * @Description 求二叉树的最大节点数
	 */
	public int getSize() {
		return getSize(root);
	}

	/**
	 * @param node
	 * @return
	 * @Description 求二叉树以某一节点为根节点的子树的节点数
	 */
	private int getSize(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getSize(node.left) + getSize(node.right);
		}
	}

	/**
	 * @param root
	 * @return
	 * @Description 利用栈后序遍历二叉树的非递归解法
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null; // previously traversed node
		TreeNode curr = root;

		if (root == null) {
			return result;
		}
		stack.push(root);
		while (!stack.empty()) {
			curr = stack.peek();
			if (prev == null || prev.left == curr || prev.left == curr) { // traverse
																			// down
																			// the
																			// tree
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.left != null) {
					stack.push(curr.left);
				}
			} else if (curr.left == prev) { // traverse up the tree from the
											// left
				if (curr.left != null) {
					stack.push(curr.left);
				}
			} else { // traverse up the tree from the right
				result.add(curr.val);
				stack.pop();
			}
			prev = curr;
		}

		return result;
	}

	/**
	 * @param root
	 * @return
	 * @Description 使用队列宽度优先搜索，层次遍历二叉树
	 */
	public List<List<Integer>> levelOrdern(TreeNode root) {
		List<List<Integer>> reslut = new LinkedList<List<Integer>>();
		if (root == null) {
			return reslut;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> temp = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			reslut.add(temp);
		}
		return reslut;
	}

	/**
	 * @param root
	 * @return
	 * @Description 利用栈中序遍历二叉树的非递归解法
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode curt = root;
		while (curt != null || !stack.empty()) {
			while (curt != null) {
				stack.add(curt);
				curt = curt.left;
			}
			curt = stack.pop();
			result.add(curt.val);
			curt = curt.right;
		}
		return result;
	}

	/**
	 * @param node
	 *            根节点
	 * @Description 利用栈宽度优先搜索，先序遍历二叉树的非递归解法
	 */
	public void nonRecOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			System.out.println("nonRecOrder val" + n.getData());
			if (n.right != null) {
				stack.push(n.right);

			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	/**
	 * @param node
	 *            根节点
	 * @Description 二叉树的先序遍历 根左右
	 */
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println("preOrder val:" + node.getData());
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * @param node
	 *            根节点
	 * @Description 中序遍历 左根右
	 */
	public void midOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			midOrder(node.left);
			System.out.println("midOrder val:" + node.getData());
			midOrder(node.right);
		}
	}

	/**
	 * @param node
	 *            根节点
	 * @Description 后序遍历 左右根
	 */
	public void postOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println("postOrder val:" + node.getData());
		}
	}

}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode getLeftChild() {
		return left;
	}

	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * @param i
	 */
	public TreeNode(int i) {
		// TODO Auto-generated constructor stub
	}

	public void setLeftChild(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRightChild() {
		return right;
	}

	public void setRightChild(TreeNode right) {
		this.right = right;
	}

	public Integer getData() {
		return val;
	}

	public void setData(Integer val) {
		this.val = val;
	}

}