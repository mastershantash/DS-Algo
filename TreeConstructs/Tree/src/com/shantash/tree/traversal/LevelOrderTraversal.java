package com.shantash.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.nodes.Tree;

public class LevelOrderTraversal {
	public static Node<Integer> root = null;
	
	public static void main(String[] args) {
		root = Tree.generateIntegerTreeOne();
		System.out.println("height = " + height(root));
		printRecursive(root);
		System.out.println("");
		printRecursiveLevelWise(root);
		System.out.println("");
		printRecursiveLevelWiseUlta(root);
		System.out.println("");
		printIterative(root);
		System.out.println("");
		printIterativeLevelWise(root);
		System.out.println("");
		printIterativeLevelWiseUlta(root);
		System.out.println("");
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
		System.out.println("printIterative");
		if(root == null)
			return;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty()){
			Node<Integer> current = queue.poll();
			System.out.print(current.getData());
			if(current.getLeft() != null)
				queue.offer(current.getLeft());
			if(current.getRight() != null)
				queue.offer(current.getRight());
		}
	}
	
	private static void printIterativeLevelWise(Node<Integer> root) {
		System.out.println("printIterative");
		if(root == null)
			return;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.offer(root);
		queue.offer(null);
		while(!(queue.size() == 1 && queue.peek() == null)){
			Node<Integer> current = queue.poll();
			if (current != null) {
				System.out.print(current.getData());
				if (current.getLeft() != null)
					queue.offer(current.getLeft());
				if (current.getRight() != null)
					queue.offer(current.getRight());
			} else {
				System.out.println("");
				queue.offer(null);
			}
		}
	}
	
	private static void printIterativeLevelWiseUlta(Node<Integer> root) {
		System.out.println("printIterativeLevelWiseUlta");
		if(root == null)
			return;
		Stack<List<Node<Integer>>> levelStack =  new Stack<List<Node<Integer>>>();
		levelStack.push(new ArrayList<Node<Integer>>());
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.offer(root);
		queue.offer(null);
		while(!(queue.size() == 1 && queue.peek() == null)){
			Node<Integer> current = queue.poll();
			if (current != null) {
				//System.out.print(current.getData());
				levelStack.peek().add(current);
				if (current.getLeft() != null)
					queue.offer(current.getLeft());
				if (current.getRight() != null)
					queue.offer(current.getRight());
			} else {
				//System.out.println("");
				queue.offer(null);
				levelStack.push(new ArrayList<Node<Integer>>());
			}
		}
		while(!levelStack.isEmpty()){
			List<Node<Integer>> list = levelStack.pop();
			list.stream().forEach(item -> System.out.print(item.getData()));
			System.out.println("");
		}
	}

	public static void printRecursive(Node<?> root) {
		System.out.println("printRecursive");
		for (int level = 1; level <= height(root); level++) {
			printLevel(root, level);
		}
	}
	
	public static void printRecursiveLevelWise(Node<?> root) {
		System.out.println("printRecursiveLevelWise");
		for (int level = 1; level <= height(root); level++) {
			printLevel(root, level);
			System.out.println("");
		}
	}
	
	private static void printRecursiveLevelWiseUlta(Node<Integer> root) {
		System.out.println("printRecursiveLevelWiseUlta");
		for (int level = height(root); level >= 1; level--) {
			printLevel(root, level);
			System.out.println("");
		}
	}
	
	private static void printLevel(Node<?> root, int level) {
		if(root == null)
			return;
		if(level == 1)
			System.out.print(root.getData());
		printLevel(root.getLeft(), level-1);
		printLevel(root.getRight(), level-1);
	}

	private static int height(Node<?> root){
		if(root == null)
			return 0;
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
	}

}
