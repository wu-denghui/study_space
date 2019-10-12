/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

import java.util.Stack;

/**
 * @author 24663
 * @date 2018年9月9日
 * @Description
 * 给定一棵具有不同节点值的二叉查找树，
 * 删除树中与给定值相同的节点。如果树中没有相同值的节点，就不做任何处理。
 * 你应该保证处理之后的树仍是二叉查找树。
 */
public class TI_87 {
    public TreeNode removeNode(TreeNode root, int value) {
        // 找到目标节点的父节点
    	TreeNode targetP=searchNode(root,value);
    	if (targetP==null) {
			return null;
		}
    	//找到目标节点的左子树的最大节点的父节点
    	TreeNode max=getMax(targetP,value);	
		if (targetP.left.val==value) {
			targetP.left=max.right;
			max.right=null;
			return targetP.left;
		}
		if (targetP.right.val==value) {
			targetP.right=max.right;
			max.right=null;
			return  targetP.right;
		}
		return root;
		
    }

   
	/**
	 * @param target
	 * @return
	 * @Description 
	 */
	private TreeNode getMax(TreeNode targetP,int value) {
		TreeNode temp = null;
		if (targetP.left.val==value) {
			temp=targetP.left;
		}
		if (targetP.right.val==value) {
			temp=targetP.right;
		}
		if (temp.left!=null) {
			//temp为目标节点的左节点
			temp=temp.left;
		}
		
		while (temp.right.right!=null) {
				temp=temp.right;
		}
		return temp;
	}


	/**
	 * @param root
	 * @param value
	 * @return
	 * @Description  前序遍历寻找节点
	 */
	private TreeNode searchNode(TreeNode node, int value) {
			if (node == null) {
				return   null;
			}
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(node);
			while (!stack.isEmpty()) {
				TreeNode n = stack.pop();
				if ((n.left.val==value&&n.right != null)||(n.right.val==value&&n.left != null)) {
					return  n;
				}
				if (n.right != null) {
					stack.push(n.right);

				}
				if (n.left != null) {
					stack.push(n.left);
				}
			}
		return null;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	/*思路
	若要删除一个BST的一个结点，需要考虑如下三种情况：
	需要删除的节点下并没有其他子节点
	需要删除的节点下有一个子节点（左或右）
	需要删除的节点下有两个子节点（既左右节点都存在）
	对这三种情况分别采取的措施是：
	直接删除此结点
	删除此结点，将此结点父节点连接到此结点左（右）子树
	找出此结点右子树中的最小结点，用以代替要删除的结点，然后删除此最小结点*/
	
	public TreeNode removeNode2(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
    
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}
