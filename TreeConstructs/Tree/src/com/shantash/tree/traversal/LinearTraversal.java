package com.shantash.tree.traversal;

public class LinearTraversal {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("***** printLoop ******");
		printLoop(A);
		System.out.println("***** printLoopRecursive ******");
		printLoopRecursive(A);
		System.out.println("***** printLoopRecursiveReverse ******");
		printLoopRecursiveReverse(A);
	}

	/*private static void printLoopRecursiveReverse(int[] a) {
		printRecursiveReverse(a, 0);
	}

	private static void printRecursiveReverse(int[] a, int current) {
		if (current == a.length)
			return;
		printRecursiveReverse(a, current + 1);
		System.out.println(a[current]);
	}*/
	
	private static void printLoopRecursiveReverse(int[] a) {
		printRecursiveReverse(a, a.length - 1);
	}

	private static void printRecursiveReverse(int[] a, int current) {
		if (current == -1)
			return;
		System.out.println(a[current]);
		printRecursiveReverse(a, current - 1);
		
	}

	/*private static void printLoopRecursive(int[] a) {
		printRecursive(a, 0);
	}

	private static void printRecursive(int[] a, int current) {
		if (current == a.length)
			return;
		System.out.println(a[current]);
		printRecursive(a, current + 1);
	}*/

	private static void printLoopRecursive(int[] a) {
		printRecursive(a, a.length - 1);
	}

	private static void printRecursive(int[] a, int current) {
		if (current == -1)
			return;
		printRecursive(a, current - 1);
		System.out.println(a[current]);
	}
	
	private static void printLoop(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
