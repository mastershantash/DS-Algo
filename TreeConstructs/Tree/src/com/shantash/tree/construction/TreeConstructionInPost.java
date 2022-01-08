package com.shantash.tree.construction;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionInPost {

	public static void main(String[] args) {
		String[] inOrder = {"D","B","E","A","F","C","G"};
		String[] postorder = {"D","E","B","F","G","C","A"};
		
		Node<String> root = constructTree(inOrder, postorder);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<String> constructTree(String[] inOrder, String[] postorder) {
		return construct(inOrder, 0, inOrder.length-1, postorder, 0, postorder.length-1);
	}

	private static Node<String> construct(String[] inOrder, int inStart, int inEnd, String[] postorder, int postStart, int postEnd) {
		System.out.println(inStart + " " + inEnd + " " + postStart + " " + postEnd);
		if(inStart==inEnd){
			return new Node(inOrder[inStart]);
		}
		if(inStart > inEnd){
			return null;
		}
		Node<String> root = new Node<String>(postorder[postEnd]);
		int rootLocInorder = -1;
		for(int i = 0; i < inOrder.length; i++){
			if(inOrder[i].equals(root.getData())){
				rootLocInorder = i;
				break;
			}
		}
		int leftSubtreeSize = rootLocInorder - inStart;
		root.setLeft(construct(inOrder, inStart, rootLocInorder-1, postorder, postStart, postEnd -1 - leftSubtreeSize));
		root.setRight(construct(inOrder, rootLocInorder+1, inEnd, postorder, postStart+leftSubtreeSize, postEnd-1));
		return root;
	}

	
}
