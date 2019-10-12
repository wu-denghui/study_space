package com.goodhealth.algorithm.LintCode_Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 24663
 * @date 2018年9月7日
 * @Description
 11. 二叉查找树中搜索区间
给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。
即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 */
public class TI_11 {
//    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
//    	List<Integer> list=new LinkedList<Integer>();
//    	if (root==null) {
//			return list;
//		}
//		return  search(root, list,k1, k2);
//    }
//
//	/**
//	 * @param root
//	 * @param list
//	 * @param k1
//	 * @param k2
//	 * @return
//	 * @Description 
//	 */
//	private List<Integer> search(TreeNode root, List<Integer> list, int k1, int k2) {
//		if (root.val>=k1&&root.val<=k2) {
//			list.add(root.val);
//		}
//		if (root.left!=null) {
//			search(root.left, list, k1, k2);
//		}
//		if (root.right!=null) {
//			search(root.right, list, k1, k2);
//		}
//		return list;
//	}
	 private List<Integer> list;
	 public List<Integer> searchRange(TreeNode root, int k1, int k2) {
	         list=new LinkedList<Integer>();
	    	if (root==null) {
				return list;
			}
			search(root,k1, k2);
			return list;
	    }

		/**
		 * @param root
		 * @param k1
		 * @param k2
		 * @return
		 * @Description 
		 */
		private void search(TreeNode root, int k1, int k2) {
		   if (root==null) {
				return ;
			}
			if (root.val>k1) {
				search(root.left,  k1, k2);
			}
			if (root.val>=k1&&root.val<=k2) {
				list.add(root.val);
			}
			if (root.val<k2) {
				search(root.right, k1, k2);
			}
			
		}
}
