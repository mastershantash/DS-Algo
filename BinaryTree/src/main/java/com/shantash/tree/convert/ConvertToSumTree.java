package com.shantash.tree.convert;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;
import com.shantash.tree.util.TreeUtil;
import com.shantash.tree.util.checks.TreeChecker;
/*
 *   			  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5
 *  To
 *  			  20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \ 
         0      0    0    0
 * */
public class ConvertToSumTree {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
		root.setLeft(new Node<Integer>(-2));
		root.setRight(new Node<Integer>(6));
		root.getLeft().setLeft(new Node<Integer>(8));
		root.getLeft().setRight(new Node<Integer>(-4));
		root.getRight().setLeft(new Node<Integer>(7));
		root.getRight().setRight(new Node<Integer>(5));
		LevelOrderTraversal.printRecursiveLevelWise(root);
		//System.out.println("isSumTree : "+TreeChecker.isSumTree(root));
		root = convert(root);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		System.out.println("isSumTree : "+TreeChecker.isSumTree(root));
	}

	private static Node<Integer> convert(Node<Integer> root) {
		convertTree(root);
		return root;
	}

	private static Integer convertTree(Node<Integer> root) {
		if(root ==  null){
			return 0;
		}
		Integer leftSum = convertTree(root.getLeft());
		Integer rightSum = convertTree(root.getRight());
		int data = root.getData();
		root.setData(leftSum + rightSum);
		return root.getData() + data;
	}

	
}
