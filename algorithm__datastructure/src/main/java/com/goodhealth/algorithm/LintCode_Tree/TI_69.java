/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author 24663
 * @date 2018年9月6日
 * @Description  层次遍历一个二叉树
 */
public class TI_69 {

	/**
	 * @param root
	 * @return
	 * @Description    深度优先遍历  递归
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }
        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            results.add(level);
            maxLevel++;
        }
        return results;
    }


    private void dfs(TreeNode root,List<Integer> level,int curtLevel,int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
    
    /**
     * @param root
     * @return
     * @Description   使用队列宽度优先搜索
     */
    public List<List<Integer>> levelOrdern(TreeNode root) {
    	List<List<Integer>> reslut=new LinkedList<List<Integer>>();
    	if (root==null) {
			return reslut;
		}
    	Queue<TreeNode>  queue=new LinkedList<>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
			List<Integer> temp=new LinkedList<>();
			int size=queue.size();
			for (int i = 0; i < size; i++) {
			TreeNode node=queue.poll();
			temp.add(node.val);
			if (node.left!=null) {
				queue.offer(node.left);
			}
			if (node.right!=null) {
				queue.offer(node.right);
			}
			}
			reslut.add(temp);
		}
		return reslut;
    }
}
