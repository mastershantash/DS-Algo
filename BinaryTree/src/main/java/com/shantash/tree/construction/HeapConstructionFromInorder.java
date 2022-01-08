package com.shantash.tree.construction;

import java.util.Arrays;
import java.util.List;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class HeapConstructionFromInorder {
	

	public static void main(String[] args) {
		List<Integer> inOrder = Arrays.asList(new Integer[] {5, 10, 40, 30, 28});
		Node<Integer> root = constructHeap(inOrder);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<Integer> constructHeap(List<Integer> inOrder) {
		return construct(inOrder, 0, inOrder.size()-1);
	}

	private static Node<Integer> construct(List<Integer> inOrder, int inStart, int inEnd) {
		System.out.println(inStart + " " + inEnd);
		if(inStart>inEnd){
			return null;
		}
		if(inStart==inEnd){
			return new Node<Integer>(inOrder.get(inStart));
		}
		int max_i = inStart;
		for(int i = inStart+1; i <= inEnd; i++){
			if(inOrder.get(i)>inOrder.get(max_i)){
				max_i = i;
			}
		}
		Node<Integer> root = new Node<Integer>(inOrder.get(max_i));
		root.setLeft(construct(inOrder, inStart, max_i-1));
		root.setRight(construct(inOrder, max_i+1, inEnd));
		return root;
	}

	

	

}
