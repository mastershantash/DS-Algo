package com.shantash.tree.convert;

import java.util.ArrayList;
import java.util.List;

import com.shantash.tree.construction.TreeConstructionCompleteBnLevel;
import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

/*
 *   			 0 
              /     \
             1       2
           /   \    /
          3     4  5    
 * */
public class ConvertToHaveChildrenSumProperty {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		for(int i = 0; i<=5; i++){
			intList.add(i);
		}
		Node<Integer> root = TreeConstructionCompleteBnLevel.constructTree(intList);
		LevelOrderTraversal.printRecursiveLevelWise(root);
		//root = convert(root);
		convertTree(root);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	private static int convertTree(Node<Integer> root) {
		if(root==null)
			return 0;
		if(root.getLeft()==null && root.getRight()==null)
			return root.getData();
		int x = convertTree(root.getLeft());
		int y = convertTree(root.getRight());
		int data = root.getData();
		root.setData(x+y);
		return x+y;
	}

	private static Node<Integer> convert(Node<Integer> root) {
		if(root ==  null){
			return null;
		}
		Node<Integer> left = convert(root.getLeft());
		Node<Integer> right = convert(root.getRight());
		if(left!=null && right!=null){
			root.setData(left.getData()+right.getData());
		} else if(left!=null){
			root.setData(left.getData());
		} else if(right!=null){
			root.setData(right.getData());
		}
		return root;
	}
}
