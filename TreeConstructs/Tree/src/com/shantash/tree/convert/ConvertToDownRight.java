package com.shantash.tree.convert;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;
import com.shantash.tree.traversal.PreorderTraversal;

/*
                        1
                      /   \
                     2     3
                    /       \
                   4         5
                  /        /   \
                 6        7      8
                 
                  		to
                  		
                1
	            |
	            2 – 3
	                |
	                4 — 5
	                |   |
	                6   7 – 8
	                
	                 i.e.
	                 
	                 1
	                /
	               2
	                \
	                 3
	                /
	               4
	             /   \
	            6     5
	                 /
	                7
	                 \
	                  8
 * */
public class ConvertToDownRight {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.setLeft(new Node<Integer>(2));
		root.setRight(new Node<Integer>(3));
		root.getRight().setLeft(new Node<Integer>(4));
		root.getRight().setRight(new Node<Integer>(5));
		root.getRight().getLeft().setLeft(new Node<Integer>(6));
		root.getRight().getRight().setLeft(new Node<Integer>(7));
		root.getRight().getRight().setRight(new Node<Integer>(8));
		LevelOrderTraversal.printRecursiveLevelWise(root);
		root = convert(root);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		PreorderTraversal.printRecursiveOptimized(root);
	}

	private static Node<Integer> convert(Node<Integer> root) {
		if(root ==  null){
			return null;
		}
		Node<Integer> left = convert(root.getLeft());
		Node<Integer> right = convert(root.getRight());
		if(left!=null && right!=null){
			left.setRight(root.getRight());
			root.setRight(null);
		}
		return root;
	}
}
