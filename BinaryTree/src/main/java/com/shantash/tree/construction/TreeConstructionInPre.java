package com.shantash.tree.construction;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionInPre {

	public static void main(String[] args) {
		String[] inOrder = {"D","B","E","A","F","C","G"};
		String[] preOrder = {"A","B","D","E","C","F","G"};
		/*
		0 5 0 5
		0 2 1 3
		0 0 2 2
		2 2 3 3
		4 5 4 5
		4 4 5 5
		*/
		Node<String> root = constructTree(inOrder, preOrder);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<String> constructTree(String[] inOrder, String[] preOrder) {
		return construct(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1);
	}
	
	private static Node<String> construct(String[] inOrder, int inStart, int inEnd, String[] preOrder, int preStart, int preEnd){
		System.out.println(inStart+" "+inEnd+" "+preStart+" "+preEnd);
		if(inEnd == inStart){
			return new Node<String>(inOrder[inStart]);
		}
		Node<String> root = new Node<String>(preOrder[preStart]);
		int rootLocIn = -1;
		for(int i = inStart; i<=inEnd; i++){
			if(root.getData().equals(inOrder[i])){
				rootLocIn = i;
				break;
			}
		}
		
		String rootPredecessorIn = inOrder[rootLocIn-1];
		int preLocOfPredecessor = -1;
		for(int i = preStart; i<=preEnd; i++ ){
			if(rootPredecessorIn.equals(preOrder[i])){
				preLocOfPredecessor = i;
				break;
			}
		}
		
		Node<String> leftRoot = null;
		Node<String> rightRoot = null;
		
		if(rootLocIn -1 > -1 && preStart+1 < preOrder.length)
		leftRoot = (Node<String>) construct(inOrder, inStart, rootLocIn-1, preOrder, preStart+1, preLocOfPredecessor);
		if(rootLocIn+1 <inOrder.length && preLocOfPredecessor+1 < preOrder.length)
		rightRoot = (Node<String>) construct(inOrder, rootLocIn+1, inEnd, preOrder, preLocOfPredecessor+1, preEnd);
		
		root.setLeft(leftRoot);
		root.setRight(rightRoot);
		
		return root;
	}

}
