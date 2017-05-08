package com.ds.algo.interview.amzn.set332;

import com.ds.algo.tree.Node;

public class PrintKLargestInBST {
	static int k=3;
	private static void printKLargest(Node root) {
		if( root == null)
			return;
		printKLargest(root.right);
		k--;
		if(k == 0)
			System.out.println("3rd largest element is :: "+root.data);
		printKLargest(root.left);
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(7);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(3);
		root.right.left = new Node(12);
		root.right.right = new Node(18);
		root.right.right.left = new Node(16);
		
		printKLargest(root);
	}

}
