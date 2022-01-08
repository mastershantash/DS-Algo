package com.shantash.tree.util.checks;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.util.TreeUtil;

public class TreeChecker {

	public static boolean childrenSum(Node<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return true;
		boolean left = childrenSum(root.getLeft());
		boolean right = childrenSum(root.getRight());
		int leftData = root.getLeft() == null ? 0 : root.getLeft().getData();
		int rightData = root.getRight() == null ? 0 : root.getRight().getData();
		return root.getData() == leftData + rightData && left && right;
	}
	
	public static boolean isSumTree(Node<Integer> root) {
		if(root == null || TreeUtil.isLeaf(root))
			return true;
		if(TreeUtil.isLeaf(root.getLeft()) && TreeUtil.isLeaf(root.getRight())) {
			return true;
		} else if(TreeUtil.isLeaf(root.getLeft())) {
			return root.getData() == root.getRight().getData();
		} else if(TreeUtil.isLeaf(root.getLeft())) {
			return root.getData() == root.getLeft().getData();
		} else{
			int leftSum = TreeUtil.sum(root.getLeft());
			int rightSum = TreeUtil.sum(root.getRight());
			return (root.getData() == leftSum + rightSum) && isSumTree(root.getLeft()) && isSumTree(root.getRight());
		}
	}
}
