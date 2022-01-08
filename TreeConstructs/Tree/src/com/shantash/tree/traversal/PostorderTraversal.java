package com.shantash.tree.traversal;

import java.util.Stack;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.nodes.Tree;

public class PostorderTraversal {

	public static Node<Integer> root = null;

	public static int count = 0;

	public static void printRecursive(Node<Integer> root) {
		count++;
		if (root != null) {
			printRecursive(root.getLeft());
			printRecursive(root.getRight());
			System.out.print(root.getData());
		}
	}

	public static void printRecursiveOptimized(Node<Integer> root) {
		count++;
		if (root != null) {
			if (root.getLeft() != null)
				printRecursiveOptimized(root.getLeft());
			if (root.getRight() != null)
				printRecursiveOptimized(root.getRight());
			System.out.print(root.getData());
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
		stack.push(root);
		Node<Integer> prev = null;
		while(!stack.isEmpty()) {
			Node<Integer> current = stack.peek();
			if(prev == null || prev.getLeft() == current || prev.getRight()==current){
				if(current.getLeft() != null){
					stack.push(current.getLeft());
				} else if(current.getRight() != null){
					stack.push(current.getRight());
				}
			} else if(prev == current.getLeft()) {
				if(current.getRight() != null){
					stack.push(current.getRight());
				}
			} else {
				System.out.print(current.getData());
				stack.pop();
			}
			prev = current;
		}
	}

	private static void printStack(Stack<Node<Integer>> stack) {
		System.out.println("stack");
		stack.stream().forEach(a -> System.out.print(a.getData()));
		System.out.println("\nstack");
	}
}
