package com.shantash.tree.convert;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

/*
 *   			 1 
              /     \
             2       3
           /   \    /  \ 
          4     5  6    7
 * */
public class ConvertToFlipTree {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.setLeft(new Node<Integer>(2));
		root.setRight(new Node<Integer>(3));
		root.getLeft().setLeft(new Node<Integer>(4));
		root.getLeft().setRight(new Node<Integer>(5));
		root.getRight().setLeft(new Node<Integer>(6));
		root.getRight().setRight(new Node<Integer>(7));
		LevelOrderTraversal.printRecursiveLevelWise(root);
		root = convert(root);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<Integer> convert(Node<Integer> root) {
		root = convertTree(root);
		return root;
	}

	private static <T> Node<T> convertTree(Node<T> root) {
		if (root == null) {
			return null;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return root;
		}
		Node<T> newRoot = convertTree(root.getLeft());
		root.getLeft().setLeft(root.getRight());
		root.getLeft().setRight(root);
		root.setLeft(null);
		root.setRight(null);
		return newRoot;
	}

}
