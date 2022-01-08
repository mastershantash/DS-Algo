package com.shantash.tree.construction;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionInLevel {

	public static void main(String[] args) {
		String[] inOrder = {"D","B","E","A","F","C"};
		String[] level = {"A","B","C","D","E","F"};
		Node<String> root = constructTree(inOrder, level);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<String> constructTree(String[] inOrder, String[] level) {
		return construct(inOrder, 0, inOrder.length-1, level);
	}
	
	private static Node<String> construct(String[] inOrder, int inStart, int inEnd, String[] levelOrder){
		//System.out.println(inStart+" "+inEnd);
		if(inEnd == inStart){
			return new Node<String>(inOrder[inStart]);
		} else if(levelOrder.length == 0){
			return null;
		}
		Node<String> root = new Node<String>(levelOrder[0]);
		int rootLoc = -1;
		for(int i = inStart; i<=inEnd; i++){
			if(inOrder[i].equals(root.getData())){
				rootLoc = i;
				break;
			}
		}
		int leftTreeInStart = inStart;
		int leftTreeInEnd = rootLoc-1;
		int rightTreeInStart = rootLoc+1;
		int rightTreeInEnd = inEnd;
		System.out.println(root.getData()+" "+rootLoc+" "+leftTreeInStart+" "+leftTreeInEnd+" "+rightTreeInStart+" "+rightTreeInEnd);
		String[] levelOrderOfLeft = new String[leftTreeInEnd-leftTreeInStart+1];
		int index = 0;
		for (String s : levelOrder) {
			for (int i = leftTreeInStart; i <= leftTreeInEnd; i++) {
				if (s.equals(inOrder[i])) {
					levelOrderOfLeft[index] = s;
					index++;
				}
			}
		}
		String[] levelOrderOfRight = new String[rightTreeInEnd-rightTreeInStart+1];
		index = 0;
		for (String s : levelOrder) {
			for (int i = rightTreeInStart; i <= rightTreeInEnd; i++) {
				if (s.equals(inOrder[i])) {
					levelOrderOfRight[index] = s;
					index++;
				}
			}
		}
		Node<String> leftRoot = construct(inOrder, leftTreeInStart, leftTreeInEnd, levelOrderOfLeft);
		Node<String> rightRoot = construct(inOrder, rightTreeInStart, rightTreeInEnd, levelOrderOfRight);
		
		root.setLeft(leftRoot);
		root.setRight(rightRoot);
		
		return root;
	}

}
