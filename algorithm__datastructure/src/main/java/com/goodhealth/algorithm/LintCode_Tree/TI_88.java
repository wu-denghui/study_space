/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;



/**
 * @author 24663
 * @date 2018年9月6日
 * @Description      找出两个节点的最近父节点
 */
public class TI_88 {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
    	if (root==null||A==null||B==null) {
			return null;
		}
		if(!isChild(root, A)||!isChild(root, B)){
		    return null;
		}
    	TreeNode result = null;
    	while (isChild(root, A)&&isChild(root, B)) {
    		          TreeNode temp=root;
    		          result=root;
			          root=root.left;
		    if (!isChild(root, A)||!isChild(root, B)) {
			    root=temp.right;
				}
		}
		return result;
    }
  public  boolean  isChild(TreeNode node,TreeNode target){
    	boolean bo1;
    	boolean bo2;
    	if (node==null) {
			return false;
		}
    	if (node.val==target.val) {
			return true;
		}else{
			bo1=isChild(node.left, target);
			bo2=isChild(node.right, target);
		}
		return bo1||bo2;
    }
}
