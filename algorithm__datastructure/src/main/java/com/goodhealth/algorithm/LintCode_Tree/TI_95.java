/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月6日
 * @Description 
 * 95. 验证二叉查找树(中序遍历是个递增的序列) 给定一个二叉树，判断它是否是合法的二叉查找树(BST) 
 * 一棵BST定义为：
 *   节点的左子树中的值要严格小于该节点的值。 
 *   节点的右子树中的值要严格大于该节点的值。 
 *   左右子树也必须是二叉查找树。
 *   一个节点的树也是二叉查找树。
 */
public class TI_95 {
    public boolean isValidBST(TreeNode root) {
			return BST(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	/**
	 * @param root
	 * @param max    左子树的最大值
	 * @param min   右子树的最小值
	 * @Description 
	 */
	private boolean BST(TreeNode root, long max, long min) {
		if (root==null) {
			return  true;
		}
		if (root.val<=max||root.val>=min) {
			return false;
		}
		return BST(root.left, max, Math.min(min, root.val))&&BST(root.right, Math.max(max, root.val), min);
				 
	}

}
