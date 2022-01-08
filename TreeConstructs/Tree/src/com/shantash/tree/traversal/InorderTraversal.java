package com.shantash.tree.traversal;

import java.util.Stack;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.nodes.Tree;

public class InorderTraversal {

	public static Node<Integer> root = null;

	public static int count = 0;

	public static void printRecursive(Node<?> root) {
		count++;
		if (root != null) {
			printRecursive(root.getLeft());
			System.out.print(root.getData());
			printRecursive(root.getRight());
		}
	}

	public static void printRecursiveOptimized(Node<?> root) {
		count++;
		if (root != null) {
			if (root.getLeft() != null)
				printRecursiveOptimized(root.getLeft());
			System.out.print(root.getData());
			if (root.getRight() != null)
				printRecursiveOptimized(root.getRight());
		}
	}

	public static void main(String[] args) {
		root = Tree.generateIntegerTreeOne();
		printRecursive(root);
		System.out.println("");
		System.out.println(count);
		count = 0;
		printRecursiveOptimized(root);
		System.out.println("");
		System.out.println(count);
		count = 0;
		printIterative(root);
		System.out.println("");
		System.out.println(count);
		/*Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			if (string.equals("EXIT")) {
				break;
			}
			System.out.println(string);
			Node<Integer> node = new Node<Integer>();
			node.setData(Integer.valueOf(string));
		}*/
	}

	private static void printIterative(Node<Integer> root) {
		System.out.println("printIterative.");
		if(root==null)
			return;
		
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> current = root;
		while(current != null || !stack.isEmpty()) {
			count++;
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else if (current == null && !stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.getData());
				current = current.getRight();
			}
		}
	}

	private static void printStack(Stack<Node<Integer>> stack) {
		System.out.println("stack");
		stack.stream().forEach(a -> System.out.print(a.getData()));
		System.out.println("\nstack");
	}
}
