package com.shantash.tree.nodes;

public class Tree {
	
	public static Node<Integer> generateIntegerTreeOne(){
		Node<Integer> root = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);
		/*Node<Integer> node8 = new Node<Integer>(8);
		Node<Integer> node9 = new Node<Integer>(9);
		Node<Integer> node10 = new Node<Integer>(10);
		Node<Integer> node11 = new Node<Integer>(11);
		Node<Integer> node12 = new Node<Integer>(12);
		Node<Integer> node13 = new Node<Integer>(13);
		Node<Integer> node14 = new Node<Integer>(14);
		Node<Integer> node15 = new Node<Integer>(15);*/
		
		root.setLeft(node2);
		root.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		
		/*node4.setLeft(node8);
		node4.setRight(node9);
		node5.setLeft(node10);
		node5.setRight(node11);
		node6.setLeft(node12);
		node6.setRight(node13);
		node7.setLeft(node14);
		node7.setRight(node15);*/
		
		return root;
	}
}
