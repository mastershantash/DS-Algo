package com.shantash.tree.construction;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionFullBnPrePost {

	public static void main(String[] args) {
		String[] preOrder = {"A","B","D","E","C","F","G"};
		String[] postOrder = {"D","E","B","F","G","C","A"};
		/*
		0 6 0 6
		2 3
		1 3 0 2
		0 1
		2 2 0 0
		3 3 1 1
		4 6 3 5
		3 1
		5 5 3 3
		6 6 4 4
		 */
		Node<String> root = constructTree(preOrder, postOrder);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<String> constructTree(String[] preOrder, String[] postOrder) {
		return construct(preOrder, 0, preOrder.length -1, postOrder, 0, postOrder.length -1);
	}

	private static Node<String> construct(String[] preOrder, int preStart, int preEnd, String[] postOrder, int postStart, int postEnd) {
		System.out.println(preStart+" "+preEnd+" "+postStart+" "+postEnd);
		/*if(preStart > preEnd){
			return null;
		}*/
		Node<String> root = new Node<String>(preOrder[preStart]);
		
		if(preStart == preEnd){
			return root;
		}
		
		int locOfLeftRootInPost = indexOf(postOrder, preOrder[preStart+1]);
		int sizeOfLeftSubtree = locOfLeftRootInPost - postStart + 1;
		System.out.println(locOfLeftRootInPost+" "+sizeOfLeftSubtree);
		
		Node<String> leftRoot = construct(preOrder, preStart + 1, preStart + sizeOfLeftSubtree, postOrder, postStart,
				postStart-1+sizeOfLeftSubtree);
		Node<String> rightRoot = construct(preOrder, preStart + sizeOfLeftSubtree + 1, preEnd, postOrder,
				postStart-1+sizeOfLeftSubtree + 1, postEnd - 1);
		root.setLeft(leftRoot);
		root.setRight(rightRoot);
		return root;
	}

	private static int indexOf(String[] seq, String string) {
		for(int i = 0; i < seq.length; i++){
			if(string != null && string.equals(seq[i]))
				return i;
		}
		return -1;
	}
}
