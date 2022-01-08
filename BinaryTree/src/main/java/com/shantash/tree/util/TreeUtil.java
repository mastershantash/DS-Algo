package com.shantash.tree.util;

import com.shantash.tree.nodes.Node;

public class TreeUtil {
	public static int size(Node<?> root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.getLeft()) + size(root.getRight());
	}

	public static int sum(Node<Integer> root) {
		if (root == null)
			return 0;
		int ls = sum(root.getLeft());
		int rs = sum(root.getRight());
		return root.getData() + ls + rs;
	}

	public static boolean isLeaf(Node<Integer> root) {
		if (root == null)
			return false;
		return root.getLeft() == null && root.getRight() == null;
	}
}
