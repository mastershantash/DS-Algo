package com.shantash.tree.convert;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;
/*
 *     1
      / \
     2   3
    / \   \
   4   5   6
 *  To
 *    12
     / \
    6   3
   / \   \
  4   5   6
 * */
public class ConvertToLeftSumTree {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.setLeft(new Node<Integer>(2));
		root.setRight(new Node<Integer>(3));
		root.getLeft().setLeft(new Node<Integer>(4));
		root.getLeft().setRight(new Node<Integer>(5));
		root.getRight().setRight(new Node<Integer>(6));
		LevelOrderTraversal.printRecursiveLevelWise(root);
		root = convert(root);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<Integer> convert(Node<Integer> root) {
		convertTree(root);
		return root;
	}

	private static Integer convertTree(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftSum = convertTree(root.getLeft());
		int rightSum = convertTree(root.getRight());
		int data = root.getData();
		root.setData(data + leftSum);
		return leftSum + rightSum + data;
	}

}
