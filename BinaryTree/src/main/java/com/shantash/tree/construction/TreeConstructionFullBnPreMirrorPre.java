package com.shantash.tree.construction;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionFullBnPreMirrorPre {

	public static void main(String[] args) {
		String[] preOrder = {"A","B","D","E","C","F","G"};
		String[] preOrderOfMirror = {"A","C","G","F","B","E","D"};
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
		Node<String> root = constructTree(preOrder, preOrderOfMirror);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<String> constructTree(String[] preOrder, String[] preOrderOfMirror) {
		return construct(preOrder, 0, preOrder.length -1, preOrderOfMirror, 0, preOrderOfMirror.length -1);
	}

	private static Node<String> construct(String[] preOrder, int preStart, int preEnd, String[] preOrderOfMirror, int preStartofMirror, int preEndOfMirror) {
		System.out.println(preStart+" "+preEnd+" "+preStartofMirror+" "+preEndOfMirror);
		/*if(preStart > preEnd){
			return null;
		}*/
		Node<String> root = new Node<String>(preOrder[preStart]);
		
		if(preStart == preEnd){
			return root;
		}
		
		int locOfLeftRootInPost = indexOf(preOrderOfMirror, preOrder[preStart+1]);
		int sizeOfLeftSubtree = preEndOfMirror - locOfLeftRootInPost + 1;
		System.out.println(locOfLeftRootInPost+" "+sizeOfLeftSubtree);
		/*
			String[] preOrder = 		{"A","B","D","E","C","F","G"};
			String[] preOrderOfMirror = {"A","C","G","F","B","E","D"};
		 */
		Node<String> leftRoot = construct(preOrder, preStart + 1, preStart + sizeOfLeftSubtree, preOrderOfMirror, locOfLeftRootInPost,
				preEndOfMirror);
		Node<String> rightRoot = construct(preOrder, preStart + sizeOfLeftSubtree + 1, preEnd, preOrderOfMirror,
				preStartofMirror + 1, preEndOfMirror-sizeOfLeftSubtree);
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
