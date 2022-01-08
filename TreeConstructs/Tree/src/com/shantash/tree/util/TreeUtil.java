package com.shantash.tree.util;

import com.shantash.tree.nodes.Node;

public class TreeUtil {
	public static int size(Node<?> root){
		if(root == null){
			return 0;
		}
		return 1 + size(root.getLeft()) + size(root.getRight());
	}
}
