package com.shantash.tree.construction;

import java.util.Arrays;
import java.util.List;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionFullBnPrePreNL {
	
	public static int index = 0;

	public static void main(String[] args) {
		List<String> pre = Arrays.asList(new String[] { "A", "B", "D", "E", "C", "F", "G" });
		List<String> preNL = Arrays.asList(new String[] { "N", "N", "L", "L", "N", "L", "L" });
		Node<String> root = constructTree(pre, preNL);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static Node<String> constructTree(List<String> pre, List<String> preNL) {
		return construct(pre, preNL);
	}

	private static Node<String> construct(List<String> pre, List<String> preNL) {
		if (index >= pre.size())
			return null;
		Node<String> root = new Node<String>(pre.get(index));
		String rootNL = preNL.get(index);
		index++;
		if(rootNL.equals("N")){
			root.setLeft(construct(pre, preNL));
			root.setRight(construct(pre, preNL));
		}
		return root;
	}

}
