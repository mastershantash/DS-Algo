package com.shantash.tree.construction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.InorderTraversal;
import com.shantash.tree.traversal.LevelOrderTraversal;
import com.shantash.tree.util.TreeUtil;

public class TreeConstructionFromAncestorMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{0,0,0,0,0,0,1},
						  {1,0,0,0,1,0,1},
						  {0,0,0,1,0,0,0},
						  {0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0},
						  {1,1,1,1,1,0,1},
						  {0,0,0,0,0,0,0}};
		System.out.println("\nconstructFromDescendentCountsTree");
		Node<Integer> root = constructFromDescendentCountsTree(matrix);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		InorderTraversal.printRecursiveOptimized(root);
		System.out.println("\nconstructTreeWithoutAlteringMatrix");
		root = constructTreeWithoutAlteringMatrix(matrix);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		InorderTraversal.printRecursiveOptimized(root);
		System.out.println("\nconstructTreeWithAlteringMatrix");
		root = constructTree(matrix);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		InorderTraversal.printRecursiveOptimized(root);
		printMatrix(root);
	}

	private static Node<Integer> constructTreeWithoutAlteringMatrix(int[][] matrix) {
		int rootInt = Integer.MIN_VALUE;
		/* data to set of data of ancestors map */
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int j = 0; j < matrix.length; j++) {
			if(map.get(j)==null){
				map.put(j, new HashSet<Integer>());
			}
			int sum = 0;
			for (int i = 0; i < matrix.length; i++) {
				if(matrix[i][j]==1){
					map.get(j).add(i);
					sum += matrix[i][j];
				}
			}
			if(sum==0 && rootInt==Integer.MIN_VALUE){
				rootInt = j;
			}
		}
		Queue<Node<Integer>> queue = new LinkedList<>();
		Node<Integer> root = new Node<Integer>(rootInt);
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<Integer> temp = queue.poll();
			int tempInt = temp.getData();
			List<Integer> children = map.keySet().stream()
					.filter(key -> map.get(key).size() == 1 && map.get(key).contains(tempInt))
					.collect(Collectors.toList());
			map.keySet().stream().forEach(key -> map.get(key).remove(tempInt));
			for(Integer nodeInt : children){
				Node<Integer> node = new Node<Integer>(nodeInt);
				queue.add(node);
				if(temp.getLeft() == null){
					temp.setLeft(node);
				} else if(temp.getRight()==null){
					temp.setRight(node);
				}
			}
		}
		return root;
	}

	private static void printMatrix(Node<Integer> root) {
		int size = TreeUtil.size(root);
		if(size > 0){
			int[][] matrix = new int[size][size];
			for(int i=0; i<size; i++){
				for(int j=0; j<size; j++){
					matrix[i][j] = 0;
				}
			}
			constructAncestorMatrix(matrix, root);
			for(int i=0; i<size; i++){
				System.out.println(Arrays.toString(matrix[i]));
			}
		}
	}

	private static Node<Integer> constructAncestorMatrix(int[][] matrix, Node<Integer> root) {
		System.out.println("");
		if(root == null){
			return null;
		}
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
				//System.out.print(current.getData() + "\t");
				stack.stream().forEach(x -> {
					//System.out.print(x.getData()+",");
					if(x.getData() != current.getData()){
						matrix[x.getData()][current.getData()] = 1;
					}
				});
				//System.out.println("");
				stack.pop();
			}
			prev = current;
		}
		return root;
	}

	private static Node<Integer> constructTree(int[][] matrix) {
		int rootInt = Integer.MIN_VALUE;
		for (int j = 0; j < matrix.length; j++) {
			int sum = 0;
			for (int i = 0; i < matrix.length; i++) {
				sum += matrix[i][j];
			}
			if(sum==0){
				rootInt = j;
				break;
			}
		}
		Queue<Node<Integer>> queue = new LinkedList<>();
		Node<Integer> root = new Node<Integer>(rootInt);
		queue.add(root);
		while(!queue.isEmpty()){
			Node<Integer> temp = queue.poll();
			List<Node<Integer>> children = new LinkedList<>();
			for (int j = 0; j < matrix.length; j++) {
				int sum = 0;
				for (int i = 0; i < matrix.length; i++) {
					if(j!=temp.getData())
						sum += matrix[i][j];
				}
				if(sum==1 && matrix[temp.getData()][j]==1){
					Node<Integer> node = new Node<Integer>(j);
					children.add(node);
				}
				matrix[temp.getData()][j]=0;
			}
			for(Node<Integer> node : children){
				queue.add(node);
				if(temp.getLeft() == null){
					temp.setLeft(node);
				} else if(temp.getRight()==null){
					temp.setRight(node);
				}
			}
		}
		return root;
	}

	private static Node<Integer> constructFromDescendentCountsTree(int[][] matrix) {
		Map<Integer, Integer> descendentCountMap =  new HashMap<>();
		Map<Integer, Boolean> addedStatus = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			descendentCountMap.put(i, 0);
			addedStatus.put(i, false);
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]==1){
					descendentCountMap.put(i,descendentCountMap.get(i)+1);
				}
			}
		}
		
		return construct(descendentCountMap);
	}

	private static Node<Integer> construct(Map<Integer, Integer> descendentCountMap) {
		List<Node<Integer>> leaves = new LinkedList<>();
		List<Node<Integer>> nodes = new LinkedList<>();
		for(int i : descendentCountMap.keySet()){
			if(descendentCountMap.get(i)==0){
				leaves.add(new Node<Integer>(i));
			} else {
				nodes.add(new Node<Integer>(i));
			}
		}
		nodes.sort((a,b)-> descendentCountMap.get(b.getData()) - descendentCountMap.get(a.getData()));
		Node<Integer> root = nodes.get(0);
		Stack<Node<Integer>> stack = new Stack<>();
		nodes.stream().forEach(x -> stack.push(x));
		while(!stack.isEmpty()){
			int peek = stack.peek().getData();
			if(descendentCountMap.get(peek)>0){
				if (stack.peek().getLeft() == null) {
					Node<Integer> left = leaves.remove(0);
					stack.peek().setLeft(left);
				} else if (stack.peek().getRight() == null) {
					Node<Integer> right = leaves.remove(0);
					stack.peek().setRight(right);
				}
				descendentCountMap.put(peek, descendentCountMap.get(peek) - 1);
			} else if (descendentCountMap.get(peek) == 0) {
				leaves.add(stack.pop());
			}
		}
		return root;
	}
}
