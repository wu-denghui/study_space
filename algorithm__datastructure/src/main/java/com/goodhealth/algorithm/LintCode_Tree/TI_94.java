/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月5日
 * @Description            求二叉树任一节点到任一节点的路径最大长度
 */
public class TI_94 {
	 private class ResultType {
	        int singlePath, maxPath;
	        ResultType(int singlePath, int maxPath) {
	            this.singlePath = singlePath;
	            this.maxPath = maxPath;
	        }
	    }

	    private ResultType helper(TreeNode root) {
	        if (root == null) {
	            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
	        }
	        // Divide
	        ResultType left = helper(root.left);
	        ResultType right = helper(root.right);

	        // Conquer
	        int singlePath =
	            Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;

	        int maxPath = Math.max(left.maxPath, right.maxPath);
	        maxPath = Math.max(maxPath,
	                           Math.max(left.singlePath, 0) + 
	                           Math.max(right.singlePath, 0) + root.val);

	        return new ResultType(singlePath, maxPath);
	    }

	    public int maxPathSum(TreeNode root) {
	        ResultType result = helper(root);
	        return result.maxPath;
	    }

}
