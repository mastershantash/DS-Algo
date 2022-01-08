package com.shantash.tree.convert;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;
/*
 *   			  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5
**/
public class MirrorTree {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
		root.setLeft(new Node<Integer>(-2));
		root.setRight(new Node<Integer>(6));
		root.getLeft().setLeft(new Node<Integer>(8));
		root.getLeft().setRight(new Node<Integer>(-4));
		root.getRight().setLeft(new Node<Integer>(7));
		root.getRight().setRight(new Node<Integer>(5));
		LevelOrderTraversal.printRecursiveLevelWise(root);
		root = convert(root);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static<T> Node<T> convert(Node<T> root) {
		if(root == null)
		return null;
		Node<T> left = convert(root.getLeft());
		Node<T> right = convert(root.getRight());
		root.setLeft(right);
		root.setRight(left);
		return root;
	}
}
