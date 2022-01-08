package com.shantash.tree.construction;

import java.util.LinkedList;
import java.util.Queue;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.InorderTraversal;
import com.shantash.tree.traversal.LevelOrderTraversal;
import com.shantash.tree.traversal.PreorderTraversal;

public class TreeConstructionFromParentArray {

	public static void main(String[] args) {
		int[] parent = {1, 5, 5, 2, 2, -1, 3};
		Node<Integer> root = constructTree(parent);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		InorderTraversal.printRecursive(root);
		System.out.println("");
		PreorderTraversal.printRecursive(root);
	}

	private static Node<Integer> constructTree(int[] parent) {
		int rootInt = -1;
		for(int i =0; i< parent.length; i++){
			if(parent[i]==-1){
				rootInt = i;
				break;
			}
		}
		Node<Integer> root = new Node<Integer>(rootInt);
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.poll();
			for(int i = 0; i< parent.length; i++){
				if(parent[i]==temp.getData()){
					Node<Integer> node = new Node<Integer>(i);
					if(temp.getLeft()==null){
						temp.setLeft(node);
					} else if(temp.getRight()==null){
						temp.setRight(node);
					}
					queue.add(node);
				}
			}
		}
		return root;
	}	
}
