package com.shantash.tree.construction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.shantash.tree.nodes.Node;
import com.shantash.tree.traversal.LevelOrderTraversal;

public class TreeConstructionCompleteBnLevel {

	public static void main(String[] args) {
		List<String> level = Arrays.asList(new String []{"A","B","C","D","E","F"});
		Node<String> root = constructTree(level);
		LevelOrderTraversal.printRecursiveLevelWise(root);
	}

	public static <T> Node<T> constructTree(List<T> levelOrder) {
		if(levelOrder == null || levelOrder.size()<1)
		return null;
		Map<Long, List<Node<T>>> map = new TreeMap<>();
		Node<T> root = new Node<T>(levelOrder.get(0));
		map.put(0l, new ArrayList<Node<T>>());
		map.get(0l).add(root);
		double height = Math.log(levelOrder.size()) / Math.log(2);
		long levels = (long) Math.ceil(height);
		long n = levelOrder.size();
		long current = 1;
		
		for(long level = 1;level < levels; level++){
			long levelCount = (long) Math.pow(2, level);
			long lastLevelEndIndex = ((long) Math.pow(2, level)) -2;
			current = lastLevelEndIndex + 1;
			if(n<levelCount){
				levelCount = n; 
			}
			while(current<= lastLevelEndIndex + levelCount && current<levelOrder.size()){
				if(map.get(level) == null){
					map.put(level, new ArrayList<Node<T>>());
				}
				map.get(level).add(new Node<T>(levelOrder.get((int) current)));
				current++;
			}
			n = n-levelCount;
		}
		
		
		for(long level =1; level<levels; level++){
			List<Node<T>> parents = map.get(level-1);
			List<Node<T>> children = map.get(level);
			int childIndex = 0;
			for(Node<T> parent : parents){
				if(childIndex<children.size())
				parent.setLeft(children.get(childIndex));
				childIndex++;
				if(childIndex<children.size())
				parent.setRight(children.get(childIndex));
				childIndex++;
			}
			
		}
		return root;
	}


	
	
}
