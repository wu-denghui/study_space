/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月5日
 * @Description
 * 给定一个二叉树,确定它是高度平衡的。
 * 对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1
 */
public class TI_93 {

	
	 public boolean isBalanced(TreeNode root) {
	        return maxDepth(root) != -1;
	    }
	    private int maxDepth(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
	            return -1;
	        }
	        return Math.max(left, right) + 1;
	    }
}
