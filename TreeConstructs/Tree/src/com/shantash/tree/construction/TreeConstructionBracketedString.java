package com.shantash.tree.construction;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.InorderTraversal;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionBracketedString {

	public static void main(String[] args) {
		String input = "4(2(3)(1))(6(5))";
		Node<String> root = constructTree(input);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		InorderTraversal.printRecursive(root);
	}

	private static Node<String> constructTree(String input) {
		System.out.println(input);
		if (input.length() == 0) {
			return null;
		}
		Node<String> root = input.indexOf('(') > -1 ? new Node<String>(input.substring(0, input.indexOf('(')))
				: new Node<String>(input);
		int count = 0;
		int closingIndex = -1;
		if (input.indexOf('(') > -1) {
			for (int i = input.indexOf('('); i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					count++;
				} else if (input.charAt(i) == ')') {
					count--;
				}
				if (count == 0) {
					closingIndex = i;
					break;
				}
			}
			if (input.indexOf('(') + 1 < input.length())
				root.setLeft(constructTree(input.substring(input.indexOf('(') + 1, closingIndex)));
			if (closingIndex + 2 < input.length())
				root.setRight(constructTree(input.substring(closingIndex + 2, input.length() - 1)));
		}
		return root;
	}

}
