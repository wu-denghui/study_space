/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

import java.util.Stack;

/**
 * @author 24663
 * @date 2018年9月8日
 * @Description       一个查找二叉树的迭代器
 */

public class TI_86 {
	 private Stack<TreeNode> stack = new Stack<>();
	    TreeNode next = null;
	    void AddNodeToStack(TreeNode root) {
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	    }

	    

	    //@return: True if there has next node, or false
	    public boolean hasNext() {
	        if (next != null) {
	            AddNodeToStack(next);
	            next = null;
	        }
	        return !stack.isEmpty();
	    }
	    
	    //@return: return next node
	    public TreeNode next() {
	        if (!hasNext()) {
	            return null;
	        }
	        TreeNode cur = stack.pop();
	        next = cur.right;
	        return cur;
	    }

}
