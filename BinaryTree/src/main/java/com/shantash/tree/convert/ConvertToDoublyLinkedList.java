package com.shantash.tree.convert;

import com.shantash.tree.nodes.DoublyLinkedlist;
import com.shantash.tree.nodes.ListNode;
import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

/*
 *     1
      / \
     2   3
    / \   \
   4   5   6
 * */

public class ConvertToDoublyLinkedList {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.setLeft(new Node<Integer>(2));
		root.setRight(new Node<Integer>(3));
		root.getLeft().setLeft(new Node<Integer>(4));
		root.getLeft().setRight(new Node<Integer>(5));
		root.getRight().setRight(new Node<Integer>(6));
		DoublyLinkedlist<Integer> list = new DoublyLinkedlist<>();
		root = convert(root, list);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		System.out.println("Forward");
		DoublyLinkedlist.print(list);
		System.out.println("Reverse");
		DoublyLinkedlist.printReverse(list);
		
		Node<Integer> start = convertInPlace(root);
		Node<Integer> temp = findStart(start);
		System.out.println("printForward");
		printNodeList(temp);

	}

	private static void printNodeList(Node<Integer> temp) {
		while(temp != null){
			System.out.print(temp.getData());
			temp = temp.getRight();
		}
		System.out.println("");
	}

	private static Node<Integer> findStart(Node<Integer> start) {
		Node<Integer> temp = start;
		while(temp!=null){
			start = temp;
			temp = temp.getLeft();
		}
		temp = start;
		return temp;
	}

	private static <T> Node<T> convert(Node<T> root, DoublyLinkedlist<T> list) {
		if (root == null)
			return root;
		Node<T> left = convert(root.getLeft(), list);
		ListNode<T> listNode = new ListNode<T>(root.getData());
		if (root != null) {
			if (list.getStart() == null && list.getEnd() == null) {
				list.setEnd(listNode);
				list.setStart(listNode);
			} else {
				list.getEnd().setNext(listNode);
				listNode.setPrev(list.getEnd());
				list.setEnd(listNode);
			}
		}
		Node<T> right = convert(root.getRight(), list);
		return root;
	}
	
	private static <T> Node<T> convertInPlace(Node<T> root) {
		if (root == null)
			return root;
		if(root.getLeft() != null){
			Node<T> left = convertInPlace(root.getLeft());
			while(left.getRight()!=null){
				left = left.getRight();
			}
			left.setRight(root);
			root.setLeft(left);
		}
		if(root.getRight() != null){
			Node<T> right = convertInPlace(root.getRight());
			while(right.getLeft()!=null){
				right = right.getLeft();
			}
			root.setRight(right);
			right.setLeft(root);
		}
		return root;
	}
}
